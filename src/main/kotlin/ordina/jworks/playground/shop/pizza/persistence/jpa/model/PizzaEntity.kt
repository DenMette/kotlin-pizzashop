package ordina.jworks.playground.shop.pizza.persistence.jpa.model

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "PIZZA", schema = "pizzashop")
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
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PizzaEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , price = $price , toppings = $toppings )"
    }
}
