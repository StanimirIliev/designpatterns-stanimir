package com.clouway.builder

import java.util.*

class Order(val builder: OrderBuilder) {
    private val orderId = builder.orderId
    private val customerName = builder.customerName
    private val customerAddress = builder.customerAddress
    private val orderCreationDate = builder.orderCreationDate
    private val orderDeliveryDate = builder.orderDeliveryDate
    private val items = builder.items

    fun isDelayDelivery(): Boolean {
        if (orderCreationDate == null || orderDeliveryDate == null) {
            throw NullPointerException("Creation date or order date are not set")
        }
        if (orderDeliveryDate.after(GregorianCalendar(2017, 10, 18).time)) {
            return true
        }
        return false
    }
}