package ordina.jworks.playground.shop.pizza.web.`in`

import ordina.jworks.playground.shop.pizza.domain.PizzaService
import ordina.jworks.playground.shop.pizza.web.`in`.mapper.PizzaResourceMapper
import ordina.jworks.playground.shop.pizza.web.`in`.model.PizzaResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
        pizzaService.getPizzas().map { pizzaResourceMapper.mapDomainToResource(it) }
}