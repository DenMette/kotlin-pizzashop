package ordina.jworks.playground.shop.pizza.domain.model

/**
 * @author Maarten Casteels
 * @since 2021
 */
data class Pizza(
    val id: PizzaId,
    val name: String,
    val price: Price,
    val toppings: Collection<Topping>
)
