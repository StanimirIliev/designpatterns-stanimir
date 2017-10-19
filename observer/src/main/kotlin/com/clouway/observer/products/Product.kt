package com.clouway.observer.products

interface Product: Comparable<Product> {
    var name: String
    var priceForOne: Float
    var price: Float
    var measureUnit: MEASURE_UNIT
    var quantity: Float

    override fun compareTo(other: Product): Int {
        return price.compareTo(other.price)
    }

    override fun toString(): String
    override fun equals(other: Any?): Boolean
}