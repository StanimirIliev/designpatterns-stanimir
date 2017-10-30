package com.clouway.observer.products

class Apple: Product() {
    override var name = "Apple"
    override var priceForOne = 2.5f
    override var price = 0f
    override var measureUnit = MEASURE_UNIT.KILOGRAM
    override var quantity = 0f
        set(value) {
            field = value
            price = quantity * priceForOne
        }
}