package ordina.jworks.playground.shop.pizza.domain

import ordina.jworks.playground.shop.pizza.persistence.PizzaPersistenceFacade
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

/**
 * @author Maarten Casteels
 * @since 2021
 */
internal class PizzaServiceTest {

    val facade: PizzaPersistenceFacade = mock()
    val service = PizzaService(facade)

    @Test
    fun `should call it's data source to retrieve pizzas`() {
        // when
        service.getPizzas()

        // then
        verify(facade, times(1)).retrievePizzas()
    }
}