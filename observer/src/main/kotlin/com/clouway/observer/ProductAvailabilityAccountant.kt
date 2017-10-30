package com.clouway.observer

import com.clouway.observer.products.Product
import java.time.LocalDateTime
import java.util.*

class ProductAvailabilityAccountant : ProductChangeListener {

    val availableProducts = mutableListOf<Product>()
    val soldProducts = mutableListOf<Product>()
    val historyOfSoldProducts = HashMap<LocalDateTime, List<Product>>()


    override fun onProductSold(product: Product, soldQuantity: Float) {
        soldProducts.find { it == product }?.apply { quantity += soldQuantity } ?:
                soldProducts.add(product.apply { quantity = soldQuantity })
    }

    override fun onProductsErased() {
        historyOfSoldProducts.put(LocalDateTime.now(), soldProducts)
        soldProducts.clear()
        availableProducts.clear()
    }

    override fun onProductAdded(product: Product, availableQuantity: Float) {
        availableProducts.find { it == product }?.apply { quantity += availableQuantity } ?:
                availableProducts.add(product.apply { quantity = availableQuantity })
    }
}