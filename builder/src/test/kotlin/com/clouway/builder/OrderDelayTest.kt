package com.clouway.builder

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class OrderDelayTest {
    val orderBuilder = OrderBuilder()
    lateinit var order: Order

    @Before
    fun setUp() {
        val chip = OrderItemBuilder()
        chip.productName = "Atmega 328"
        chip.measureUnit = "pcs"
        chip.quantity = 7.0
        chip.price = 7.5

        val jumper = OrderItemBuilder()
        jumper.productName = "jumper"
        jumper.measureUnit = "pcs"
        jumper.quantity = 150.0
        jumper.price = 0.05

        orderBuilder.addItem(chip.build())
        orderBuilder.addItem(jumper.build())

        orderBuilder.customerAddress = "Gabrovo, Zelena Livada"
        orderBuilder.customerName = "Stanimir Iliev"
        orderBuilder.orderCreationDate = GregorianCalendar(2017, 10, 15).time
        orderBuilder.orderId = 562215316316
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