package com.clouway.builder

class OrderItem(val builder: OrderItemBuilder) {
    private var productName = builder.productName
    private var measureUnit = builder.measureUnit
    private var quantity = builder.quantity
    private var price = builder.price
}