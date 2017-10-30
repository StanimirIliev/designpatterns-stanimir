package com.clouway.observer

import com.clouway.observer.products.Apple
import com.clouway.observer.products.Milk
import org.jmock.Expectations
import org.jmock.integration.junit4.JUnitRuleMockery
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class ProductChangeListenerTest {

    @Rule
    @JvmField
    val context = JUnitRuleMockery()
    private val availableListener = context.mock(ProductChangeListener::class.java)
    private val warehouse = Warehouse(availableListener)
    private val milk = Milk()
    private val apple = Apple()
    private val otherApple = Apple()

    @Before
    fun setUp() {
        context.checking(object : Expectations() {
            init {
                exactly(1).of(availableListener).onProductAdded(apple, 10f)
            }
        })
        warehouse.add(apple.apply { quantity = 10f })
    }

    @After
    fun clear() {
        context.checking(object : Expectations() {
            init {
                exactly(1).of(availableListener).onProductsErased()
            }
        })
        warehouse.clear()
    }

    @Test
    fun addNewProduct() {
        context.checking(object : Expectations() {
            init {
                exactly(1).of(availableListener).onProductAdded(milk, 15f)
            }
        })
        warehouse.add(milk.apply { quantity = 15f })
    }

    @Test
    fun addExistingProduct() {
        context.checking(object : Expectations() {
            init {
                exactly(1).of(availableListener).onProductAdded(apple, 22.5f)
            }
        })
        warehouse.add(otherApple.apply { quantity = 12.5f })
    }

    @Test
    fun sellProduct() {
        context.checking(object : Expectations() {
            init {
                exactly(1).of(availableListener).onProductSold(apple, 10f)
            }
        })
        warehouse.sell(apple.apply { quantity = 10f })
    }
}