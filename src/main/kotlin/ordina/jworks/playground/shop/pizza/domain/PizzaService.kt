package ordina.jworks.playground.shop.pizza.domain

import ordina.jworks.playground.shop.pizza.domain.model.Pizza
import ordina.jworks.playground.shop.pizza.persistence.PizzaPersistenceFacade
import org.springframework.stereotype.Service

/**
 * @author Maarten Casteels
 * @since 2021
 */
@Service
class PizzaService(private val pizzaPersistenceFacade: PizzaPersistenceFacade) {

    fun getPizzas(): Collection<Pizza> =
        pizzaPersistenceFacade.retrievePizzas()
}