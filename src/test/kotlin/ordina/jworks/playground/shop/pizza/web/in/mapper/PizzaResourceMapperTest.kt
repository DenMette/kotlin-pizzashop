package ordina.jworks.playground.shop.pizza.web.`in`.mapper

import ordina.jworks.playground.shop.pizza.domain.model.Pizza
import ordina.jworks.playground.shop.pizza.domain.model.PizzaId
import ordina.jworks.playground.shop.pizza.domain.model.Price
import ordina.jworks.playground.shop.pizza.domain.model.Topping
import ordina.jworks.playground.shop.pizza.web.`in`.model.PizzaResource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * @author Maarten Casteels
 * @since 2021
 */
internal class PizzaResourceMapperTest {

    private val pizzaResourceMapper = PizzaResourceMapper()

    @Test
    fun `should map Pizza object into PizzaResource`() {
        // given
        val pizza = Pizza(
            id = PizzaId("123-456"),
            name = "Margherita",
            price = Price(12.25),
            toppings = listOf(
                Topping("tomato"),
                Topping("mozzarella"),
                Topping("fresh basil")
            )
        )

        // when
        val response = pizzaResourceMapper.toResource(pizza)

        // then
        val pizzaResource = PizzaResource("Margherita", 12.25, listOf("tomato", "mozzarella", "fresh basil"))
        assertThat(response).isEqualTo(pizzaResource)
    }
}
