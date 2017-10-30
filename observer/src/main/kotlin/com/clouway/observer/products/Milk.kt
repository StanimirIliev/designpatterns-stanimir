package com.clouway.observer.products

class Milk: Product() {
    override var name = "Milk"
    override var priceForOne = 1.25f
    override var price = 0f
    override var measureUnit = MEASURE_UNIT.LITER
    override var quantity = 0f
        set(value) {
            field = value
            price = quantity * priceForOne
        }
}