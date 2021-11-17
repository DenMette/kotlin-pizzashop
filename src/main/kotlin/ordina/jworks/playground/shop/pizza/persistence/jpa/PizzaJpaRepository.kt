package ordina.jworks.playground.shop.pizza.persistence.jpa

import ordina.jworks.playground.shop.pizza.persistence.jpa.model.PizzaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * @author Maarten Casteels
 * @since 2021
 */
interface PizzaJpaRepository : JpaRepository<PizzaEntity, UUID> {
}