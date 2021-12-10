package ordina.jworks.playground.shop.pizza.web.`in`.mapper

import ordina.jworks.playground.shop.pizza.domain.model.Pizza
import ordina.jworks.playground.shop.pizza.domain.model.PizzaId
import ordina.jworks.playground.shop.pizza.domain.model.Price
import ordina.jworks.playground.shop.pizza.domain.model.Topping
import ordina.jworks.playground.shop.pizza.web.`in`.model.CreatePizzaResource
import ordina.jworks.playground.shop.pizza.web.`in`.model.PizzaResource
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author Maarten Casteels
 * @since 2021
 */
@Component
class PizzaResourceMapper {

    fun toResource(pizza: Pizza): PizzaResource =
        PizzaResource(
            name = pizza.name,
            price = pizza.price.value,
            toppings = pizza.toppings.map { it.value }
        )

    fun toDomain(resource: CreatePizzaResource): Pizza =
        Pizza(
            id = PizzaId(UUID.randomUUID().toString()),
            name = resource.name,
            price = Price(resource.price),
            toppings = resource.toppings.map { Topping(it) }
        )
}
