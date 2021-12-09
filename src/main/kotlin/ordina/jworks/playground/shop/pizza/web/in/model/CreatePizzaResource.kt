package ordina.jworks.playground.shop.pizza.web.`in`.model

/**
 * @author Maarten Casteels
 * @since 2021
 */
data class CreatePizzaResource(
    val name: String,
    val price: Double,
    val toppings: Collection<String>
)