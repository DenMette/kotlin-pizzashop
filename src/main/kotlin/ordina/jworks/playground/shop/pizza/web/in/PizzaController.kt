package ordina.jworks.playground.shop.pizza.web.`in`

import ordina.jworks.playground.shop.pizza.domain.PizzaService
import ordina.jworks.playground.shop.pizza.web.`in`.mapper.PizzaResourceMapper
import ordina.jworks.playground.shop.pizza.web.`in`.model.PizzaResource
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * @author Maarten Casteels
 * @since 2021
 */
@RestController
@RequestMapping("/pizzas")
class PizzaController(
    private val pizzaResourceMapper: PizzaResourceMapper,
    private val pizzaService: PizzaService
) {

    @GetMapping
    fun index(): Collection<PizzaResource> =
        pizzaService.getPizzas().map {
            pizzaResourceMapper.mapDomainToResource(it)
        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(): PizzaResource {
        return PizzaResource(
            name = "Margherita",
            price = 12.25,
            toppings = listOf("tomato", "mozzarella", "fresh basil")
        )
    }
}
