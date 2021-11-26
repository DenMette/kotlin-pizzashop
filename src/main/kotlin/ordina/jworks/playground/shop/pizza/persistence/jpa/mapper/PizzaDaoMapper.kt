package ordina.jworks.playground.shop.pizza.persistence.jpa.mapper

import ordina.jworks.playground.shop.pizza.domain.model.Pizza
import ordina.jworks.playground.shop.pizza.domain.model.PizzaId
import ordina.jworks.playground.shop.pizza.domain.model.Price
import ordina.jworks.playground.shop.pizza.domain.model.Topping
import ordina.jworks.playground.shop.pizza.persistence.jpa.model.PizzaEntity
import org.springframework.stereotype.Component

/**
 * @author Maarten Casteels
 * @since 2021
 */
@Component
class PizzaDaoMapper {
    fun toDomain(entity: PizzaEntity): Pizza {
        return Pizza(
            id = PizzaId(entity.id.toString()),
            name = entity.name,
            price = Price(entity.price),
            toppings = entity.toppings.split(",").map { Topping(it) }
        )
    }
}
