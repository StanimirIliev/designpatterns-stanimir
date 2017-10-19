package com.clouway.observer

import com.clouway.observer.products.Product

class Warehouse(val availableObserver: Observer, val soldObserver: Observer) {

    init {
        availableObserver.addWarehouse(this)
        soldObserver.addWarehouse(this)
    }

    val available = ArrayList<Product>()
    val sold = ArrayList<Product>()

    fun add(product: Product) {// If there is such a product just increase its quantity
        if(product.quantity > 0f) {
            val oldProduct = isAvailable(product)
            if(oldProduct != null) {
                oldProduct.quantity += product.quantity
            }
            else {
                available.add(product)
            }
            availableObserver.update()
        }
    }

    fun sell(product: Product, quantity: Float): Boolean {
        val availableProduct = isAvailable(product) ?: return false
        if (availableProduct.quantity < quantity) {//    Not enough quantity to sell
            return false
        }
        val soldProduct = isSold(product)
        if(soldProduct != null) {
            soldProduct.quantity += quantity
            soldObserver.update()
            return true
        }
        else {
            if (availableProduct.quantity > quantity) {
                sold.add(product.apply{this.quantity = quantity})
                availableProduct.quantity -= quantity
            } else {
                available.remove(availableProduct)
                sold.add(availableProduct)
                availableObserver.update()
            }
            soldObserver.update()
            return true
        }
    }

    fun isAvailable(product: Product): Product? {
        for (availableProduct in available) {
            if (availableProduct.equals(product)) {
                return availableProduct
            }
        }
        return null
    }

    fun isSold(product: Product): Product? {
        for (soldProduct in sold) {
            if (soldProduct.equals(product)) {
                return soldProduct
            }
        }
        return null
    }

    fun getAvailableProductsInfo(): String {
        return availableObserver.info
    }

    fun getSoldProductsInfo(): String {
        return soldObserver.info
    }

    fun clear() {
        available.clear()
        sold.clear()
        availableObserver.update()
        soldObserver.update()
    }
}