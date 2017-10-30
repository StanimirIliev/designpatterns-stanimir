package com.clouway.observer

import com.clouway.observer.products.Product

class Warehouse(val productChangeListener: ProductChangeListener) {

    val available = ArrayList<Product>()
    val sold = ArrayList<Product>()

    fun add(product: Product) {// If there is such a product just increase its quantity
        if (product.quantity == 0f) {
            return
        }
        val oldProduct = isAvailable(product)
        if (oldProduct != null) {
            oldProduct.quantity += product.quantity
            productChangeListener.onProductAdded(oldProduct, oldProduct.quantity)
        } else {
            available.add(product)
            productChangeListener.onProductAdded(product, product.quantity)
        }
    }

    fun sell(product: Product): Boolean {
        val availableProduct = isAvailable(product) ?: return false
        if (availableProduct.quantity < product.quantity) {//    Not enough quantity to sell
            return false
        }
        val soldProduct = isSold(product)
        if (soldProduct != null) {
            soldProduct.quantity += product.quantity
            if (availableProduct.quantity > product.quantity) {
                availableProduct.quantity -= product.quantity
            } else {
                available.remove(availableProduct)
            }
            productChangeListener.onProductSold(soldProduct, product.quantity)
            return true
        } else {
            if (availableProduct.quantity > product.quantity) {
                sold.add(product.apply { this.quantity = quantity })
                availableProduct.quantity -= product.quantity
            } else {
                available.remove(availableProduct)
                sold.add(availableProduct)
            }
            productChangeListener.onProductSold(availableProduct, product.quantity)
            return true
        }
    }

    fun clear() {
        available.clear()
        sold.clear()
        productChangeListener.onProductsErased()
    }

    private fun isAvailable(product: Product): Product? {
        return available.find { it == product }
    }

    private fun isSold(product: Product): Product? {
        return sold.find { it == product }
    }

}