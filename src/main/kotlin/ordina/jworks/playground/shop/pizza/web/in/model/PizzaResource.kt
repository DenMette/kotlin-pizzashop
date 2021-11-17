package ordina.jworks.playground.shop.pizza.web.`in`.model

/**
 * @author Maarten Casteels
 * @since 2021
 */
data class PizzaResource(
    val name: String,
    val price: Double,
    val toppings: Collection<String>
)