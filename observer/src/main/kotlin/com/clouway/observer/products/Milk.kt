package com.clouway.observer.products

class Milk: Product {
    override var name = "Milk"
    override var priceForOne = 1.25f
    override var price = 0f
    override var measureUnit = MEASURE_UNIT.LITER
    override var quantity = 0f
        set(value) {
            field = value
            price = quantity * priceForOne
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