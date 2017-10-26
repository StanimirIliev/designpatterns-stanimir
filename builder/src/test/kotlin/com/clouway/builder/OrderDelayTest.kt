package com.clouway.builder

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class OrderDelayTest {
    val orderBuilder = OrderBuilder().apply {
        orderCreationDate = GregorianCalendar(2017, 10, 15).time
    }

    @Test
    fun hasDelay() {
        orderBuilder.orderDeliveryDate = GregorianCalendar(2017, 10, 19).time
        assertThat(orderBuilder.build().isDelayDelivery(), `is`(equalTo(true)))
    }

    @Test
    fun hasNotDelay() {
        orderBuilder.orderDeliveryDate = GregorianCalendar(2017, 10, 17).time
        assertThat(orderBuilder.build().isDelayDelivery(), `is`(equalTo(false)))
    }

    @Test(expected = NullPointerException::class)
    fun unsetDate() {
        orderBuilder.build().isDelayDelivery()
    }
}
