package com.clouway.builder

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class OrderDelayTest {
    lateinit var orderBuilder: OrderBuilder
    lateinit var order: Order

    @Before
    fun setUp() {
        orderBuilder = OrderBuilder().apply {
            customerAddress = "Gabrovo, Zelena Livada"
            customerName = "Stanimir Iliev"
            orderCreationDate = GregorianCalendar(2017, 10, 15).time
            orderId = 562215316316
            addItem(OrderItemBuilder().apply {
                productName = "jumper"
                measureUnit = "pcs"
                quantity = 150.0
                price = 0.05
            }.build())
        }
    }


    @Test
    fun hasDelay() {
        orderBuilder.orderDeliveryDate = GregorianCalendar(2017, 10, 19).time
        order = orderBuilder.build()
        assertThat(order.isDelayDelivery(), `is`(equalTo(true)))
    }

    @Test
    fun hasNotDelay() {
        orderBuilder.orderDeliveryDate = GregorianCalendar(2017, 10, 17).time
        order = orderBuilder.build()
        assertThat(order.isDelayDelivery(), `is`(equalTo(false)))
    }

    @Test(expected = NullPointerException::class)
    fun unsetDate() {
        order = orderBuilder.build()
        order.isDelayDelivery()
    }
}
