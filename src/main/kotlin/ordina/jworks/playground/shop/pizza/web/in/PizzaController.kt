package ordina.jworks.playground.shop.pizza.web.`in`

import ordina.jworks.playground.shop.pizza.domain.PizzaService
import ordina.jworks.playground.shop.pizza.web.`in`.mapper.PizzaResourceMapper
import ordina.jworks.playground.shop.pizza.web.`in`.model.CreatePizzaResource
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
    private val mapper: PizzaResourceMapper,
    private val pizzaService: PizzaService
) {

    @GetMapping
    fun index(): Collection<PizzaResource> =
        pizzaService.getPizzas().map {
            mapper.toResource(it)
        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody resource: CreatePizzaResource) =
        mapper.toResource(pizzaService.createPizza(mapper.toDomain(resource)))
}
