package ordina.jworks.playground.shop.pizza.web.`in`.mapper

import ordina.jworks.playground.shop.pizza.domain.model.Pizza
import ordina.jworks.playground.shop.pizza.web.`in`.model.PizzaResource
import org.springframework.stereotype.Component

/**
 * @author Maarten Casteels
 * @since 2021
 */
@Component
class PizzaResourceMapper {

    fun mapDomainToResource(pizza: Pizza): PizzaResource =
        PizzaResource(
            name = pizza.name,
            price = pizza.price.value,
            toppings = pizza.toppings.map { it.value }
        )
}
