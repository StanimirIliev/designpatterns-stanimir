package com.clouway.observer

interface Observer {
    var info: String
    fun update()
    fun addWarehouse(warehouse: Warehouse)
}