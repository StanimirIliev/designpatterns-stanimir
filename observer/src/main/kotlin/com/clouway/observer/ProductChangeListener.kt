package com.clouway.observer

import com.clouway.observer.products.Product

interface ProductChangeListener {

    fun onProductAdded(product: Product, availableQuantity: Float)

    fun onProductSold(product: Product, soldQuantity: Float)

    fun onProductsErased()
}