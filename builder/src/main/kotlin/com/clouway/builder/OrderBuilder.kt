package com.clouway.builder

import java.util.*

class OrderBuilder {
    var orderId = 0L
    var customerName = ""
    var customerAddress = ""
    var orderCreationDate: Date? = null
    var orderDeliveryDate: Date? = null
    val items = ArrayList<OrderItem>()

    fun addItem(item: OrderItem) {
        items.add(item)
    }

    fun build(): Order {
        return Order(this)
    }
}