package com.clouway.observer

import com.clouway.observer.products.Apple
import com.clouway.observer.products.Milk
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class SoldStockObserverTest {

    val warehouse = Warehouse(AvailableStockObserver(), SoldStockObserver())

    @Before
    fun setUp() {
        //set some products
        warehouse.add(Apple().apply { quantity = 10f })
    }

    @After
    fun clear() {
        warehouse.clear()
    }

    @Test
    fun sellPartOfProduct() {
        assertThat(warehouse.sell(Apple(), 2f), `is`(equalTo(true)))
        assertThat(warehouse.getSoldProductsInfo(), `is`(equalTo(
                "Sold products in warehouse:\n" +
                        "###########################\n" +
                        "\n" +
                        "Name: Apple\n" +
                        "Measure unit: KILOGRAM\n" +
                        "Price for one: 2.5\n" +
                        "Quantity: 2.0\n" +
                        "Total price: 5.0\n" +
                        "###########################\n" +
                        "###########################\n" +
                        "\n"
        )))
    }

    @Test
    fun sellWholeProduct() {
        assertThat(warehouse.sell(Apple(), 10f), `is`(equalTo(true)))
        assertThat(warehouse.getSoldProductsInfo(), `is`(equalTo(
                "Sold products in warehouse:\n" +
                        "###########################\n" +
                        "\n" +
                        "Name: Apple\n" +
                        "Measure unit: KILOGRAM\n" +
                        "Price for one: 2.5\n" +
                        "Quantity: 10.0\n" +
                        "Total price: 25.0\n" +
                        "###########################\n" +
                        "###########################\n" +
                        "\n")))
    }

    @Test
    fun sellTheSameProductTwice() {
        assertThat(warehouse.sell(Apple(), 2f), `is`(equalTo(true)))
        assertThat(warehouse.sell(Apple(), 2f), `is`(equalTo(true)))
        assertThat(warehouse.getSoldProductsInfo(), `is`(equalTo(
                "Sold products in warehouse:\n" +
                        "###########################\n" +
                        "\n" +
                        "Name: Apple\n" +
                        "Measure unit: KILOGRAM\n" +
                        "Price for one: 2.5\n" +
                        "Quantity: 4.0\n" +
                        "Total price: 10.0\n" +
                        "###########################\n" +
                        "###########################\n" +
                        "\n"
        )))
    }

    @Test
    fun sellProductThatDoesNotExist() {
        assertThat(warehouse.sell(Milk(), 1f), `is`(equalTo(false)))
    }
}