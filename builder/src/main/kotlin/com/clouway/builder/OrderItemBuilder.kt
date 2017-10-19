package com.clouway.builder

class OrderItemBuilder {
    var productName = "something"
    var measureUnit = "something"
    var quantity = 0.0
    var price = 0.0

    fun build(): OrderItem {
        return OrderItem(this)
    }
}