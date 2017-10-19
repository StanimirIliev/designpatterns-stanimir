package com.clouway.observer

class AvailableStockObserver: Observer {

    override var info = "There is no available products in the warehouse"
    lateinit var warehouse: Warehouse

    override fun addWarehouse(warehouse: Warehouse) {
        this.warehouse = warehouse
    }

    override fun update() {
        if(warehouse.available.size != 0) {
            info = "Available products in warehouse:\n" +
                    "################################\n"
            for(available in warehouse.available) {
                info += "\n$available\n"
            }
            info += "################################\n" +
                    "################################\n\n"
        }
        else {
            info = "There is no available products in the warehouse"
        }
    }
}