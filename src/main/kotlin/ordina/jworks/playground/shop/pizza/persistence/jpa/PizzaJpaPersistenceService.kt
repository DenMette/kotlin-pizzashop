package ordina.jworks.playground.shop.pizza.persistence.jpa

import ordina.jworks.playground.shop.pizza.domain.model.Pizza
import ordina.jworks.playground.shop.pizza.persistence.PizzaPersistenceFacade
import ordina.jworks.playground.shop.pizza.persistence.jpa.mapper.PizzaDaoMapper
import org.springframework.stereotype.Service

@Service
class PizzaJpaPersistenceService(
    val repository: PizzaJpaRepository,
    val mapper: PizzaDaoMapper
) : PizzaPersistenceFacade {

    override fun retrievePizzas(): Collection<Pizza> {
        return repository.findAll().map { mapper.toDomain(it) }
    }

    override fun save(pizza: Pizza): Pizza {
        return mapper.toDomain(
            repository.save(
                mapper.toEntity(pizza)
            )
        )
    }
}