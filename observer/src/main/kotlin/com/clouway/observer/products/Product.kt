package com.clouway.observer.products

abstract class Product: Comparable<Product> {
    abstract var name: String
    abstract var priceForOne: Float
    abstract var price: Float
    abstract var measureUnit: MEASURE_UNIT
    abstract var quantity: Float

    override fun compareTo(other: Product): Int {
        return price.compareTo(other.price)
    }

    override fun toString(): String {
        return "Name: $name\nMeasure unit: $measureUnit\n" +
                "Price for one: $priceForOne\nQuantity: $quantity\nTotal price: $price"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Apple

        if (name != other.name) return false
        if (priceForOne != other.priceForOne) return false
        if (measureUnit != other.measureUnit) return false

        return true
    }
}