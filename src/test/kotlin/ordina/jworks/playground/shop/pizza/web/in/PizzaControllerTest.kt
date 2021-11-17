package ordina.jworks.playground.shop.pizza.web.`in`

import ordina.jworks.playground.shop.pizza.persistence.jpa.PizzaJpaRepository
import ordina.jworks.playground.shop.pizza.persistence.jpa.model.PizzaEntity
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

/**
 * @author Maarten Casteels
 * @since 2021
 */
@SpringBootTest
@AutoConfigureMockMvc
internal class PizzaControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val repository: PizzaJpaRepository
) {

    @Nested
    @DisplayName("GET /pizzas")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
}