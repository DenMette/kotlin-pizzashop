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
        PizzaResource(pizza.name, pizza.price.value, pizza.toppings.map { it.value })
}