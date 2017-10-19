package com.clouway.observer

import com.clouway.observer.products.Apple
import com.clouway.observer.products.Milk
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class AvailableStockObserverTest {

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
    fun existingProducts() {
        assertThat(warehouse.getAvailableProductsInfo(), `is`(equalTo(
                "Available products in warehouse:\n" +
                        "################################\n" +
                        "\n" +
                        "Name: Apple\n" +
                        "Measure unit: KILOGRAM\n" +
                        "Price for one: 2.5\n" +
                        "Quantity: 10.0\n" +
                        "Total price: 25.0\n" +
                        "################################\n" +
                        "################################\n" +
                        "\n"
        )))
    }

    @Test
    fun addNewProduct() {
        warehouse.add(Milk().apply { quantity = 15f })
        assertThat(warehouse.getAvailableProductsInfo(), `is`(equalTo(
                "Available products in warehouse:\n" +
                        "################################\n" +
                        "\n" +
                        "Name: Apple\n" +
                        "Measure unit: KILOGRAM\n" +
                        "Price for one: 2.5\n" +
                        "Quantity: 10.0\n" +
                        "Total price: 25.0\n" +
                        "\n" +
                        "Name: Milk\n" +
                        "Measure unit: LITER\n" +
                        "Price for one: 1.25\n" +
                        "Quantity: 15.0\n" +
                        "Total price: 18.75\n" +
                        "################################\n" +
                        "################################\n" +
                        "\n"
        )))
    }

    @Test
    fun addExistingProduct() {
        warehouse.add(Apple().apply { quantity = 12.5f })
        assertThat(warehouse.getAvailableProductsInfo(), `is`(equalTo(
                "Available products in warehouse:\n" +
                        "################################\n" +
                        "\n" +
                        "Name: Apple\n" +
                        "Measure unit: KILOGRAM\n" +
                        "Price for one: 2.5\n" +
                        "Quantity: 22.5\n" +
                        "Total price: 56.25\n" +
                        "################################\n" +
                        "################################\n" +
                        "\n"
        )))
    }

    @Test
    fun sellAllAvailableProducts() {
        warehouse.sell(Apple(), 10f)
        assertThat(warehouse.getAvailableProductsInfo(),
                `is`(equalTo("There is no available products in the warehouse")))
    }

    @Test
    fun clearWarehouse() {
        warehouse.clear()
        assertThat(warehouse.getAvailableProductsInfo(),
                `is`(equalTo("There is no available products in the warehouse")))
        assertThat(warehouse.getSoldProductsInfo(),
                `is`(equalTo("There is no sold products in the warehouse")))
    }
}