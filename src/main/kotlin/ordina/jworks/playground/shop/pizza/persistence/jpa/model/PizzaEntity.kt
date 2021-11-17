package ordina.jworks.playground.shop.pizza.persistence.jpa.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class PizzaEntity(
    @Id
    @Column(name = "id", nullable = false, length = 16, unique = true)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "price")
    val price: Double,

    @Column(name = "toppings")
    val toppings: String,
)