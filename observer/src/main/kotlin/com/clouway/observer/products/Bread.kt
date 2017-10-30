package com.clouway.observer.products

class Bread : Product() {
    override var name = "Bread"
    override var priceForOne = 1f
    override var price = 0f
    override var measureUnit = MEASURE_UNIT.PIECE
    override var quantity = 0f
        set(value) {
            field = value
            price = quantity * priceForOne
        }
}