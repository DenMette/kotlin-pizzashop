package ordina.jworks.playground.shop.pizza.persistence.jpa

import ordina.jworks.playground.shop.pizza.persistence.jpa.mapper.PizzaDaoMapper
import ordina.jworks.playground.shop.pizza.persistence.jpa.model.PizzaEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

/**
 * @author Maarten Casteels
 * @since 2021
 */
@DataJpaTest
class PizzaJpaPersistenceServiceTest @Autowired constructor(
    val entityManager: TestEntityManager,
    repository: PizzaJpaRepository
) {

    private final val mapper = PizzaDaoMapper()
    val service = PizzaJpaPersistenceService(repository, mapper)

    @Test
    fun `should retrieve list of pizzas`() {
        // given
        val pizzaMargherita = PizzaEntity(
            name = "Margherita",
            price = 12.25,
            toppings = "tomato,mozzarella,fresh basil"
        )

        entityManager.persist(pizzaMargherita)
        entityManager.flush()

        // when
        val retrievePizzas = service.retrievePizzas()

        // then
        assertThat(retrievePizzas).allMatch { it.id.id != "" }
    }
}
