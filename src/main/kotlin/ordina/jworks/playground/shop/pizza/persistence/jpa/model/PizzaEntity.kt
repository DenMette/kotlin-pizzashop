package ordina.jworks.playground.shop.pizza.persistence.jpa.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "PIZZA", schema = "pizzashop")
@Entity
class PizzaEntity(
    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "price")
    val price: Double,

    @Column(name = "toppings")
    val toppings: String,
) {
    @Id
    @Column(name = "id", nullable = false, length = 16, unique = true)
    val id: UUID? = UUID.randomUUID()
}