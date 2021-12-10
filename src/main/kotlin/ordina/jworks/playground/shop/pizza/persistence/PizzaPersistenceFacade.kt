package ordina.jworks.playground.shop.pizza.persistence

import ordina.jworks.playground.shop.pizza.domain.model.Pizza

/**
 * @author Maarten Casteels
 * @since 2021
 */
interface PizzaPersistenceFacade {

    fun retrievePizzas(): Collection<Pizza>

    fun save(pizza: Pizza): Pizza
}