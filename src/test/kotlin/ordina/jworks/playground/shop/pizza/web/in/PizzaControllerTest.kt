package ordina.jworks.playground.shop.pizza.web.`in`

import com.fasterxml.jackson.databind.ObjectMapper
import ordina.jworks.playground.shop.pizza.persistence.jpa.PizzaJpaRepository
import ordina.jworks.playground.shop.pizza.persistence.jpa.model.PizzaEntity
import ordina.jworks.playground.shop.pizza.web.`in`.model.CreatePizzaResource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

/**
 * @author Maarten Casteels
 * @since 2021
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
internal class PizzaControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val repository: PizzaJpaRepository,
    val mapper: ObjectMapper
) {

    companion object {
        @Container
        private val postgreSQLContainer = PostgreSQLContainer<Nothing>("postgres:latest")


        @DynamicPropertySource
        @JvmStatic
        fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl)
            registry.add("spring.datasource.username", postgreSQLContainer::getUsername)
            registry.add("spring.datasource.password", postgreSQLContainer::getPassword)
        }
    }

    @Nested
    @DisplayName("GET /pizzas")
    inner class GetAllPizzas {

        @Test
        fun `should return a list of pizzas`() {

            val margherita = PizzaEntity(
                name = "Margherita",
                price = 12.25,
                toppings = "tomato,mozzarella,fresh basil"
            )

            repository.save(margherita)

            mockMvc.get("/pizzas")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].name") { value("Margherita") }
                    jsonPath("$[0].price") { value(12.25) }
                    jsonPath("$[0].toppings") { isArray() }
                }

            repository.delete(margherita)
        }
    }

    @Nested
    @DisplayName("POST /pizzas")
    inner class CreatePizza {

        @Test
        fun `should create a pizza`() {
            mockMvc.post("/pizzas")
            {
                contentType = MediaType.APPLICATION_JSON
                content = mapper.writeValueAsString(
                    CreatePizzaResource(
                        name = "Margherita",
                        price = 12.25,
                        toppings = listOf("tomato", "mozzarella", "fresh basil")
                    )
                )
                accept = MediaType.APPLICATION_JSON
            }
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("name") { value("Margherita") }
                    jsonPath("price") { value(12.25) }
                    jsonPath("toppings") { isArray() }
                }

            Assertions.assertThat(repository.count()).isEqualTo(1)
            Assertions.assertThat(repository.findAll()).allMatch {
                it.name == "Margherita"
            }
        }
    }
}