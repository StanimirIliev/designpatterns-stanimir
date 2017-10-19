package com.clouway.observer

class SoldStockObserver: Observer {

    override var info = "There is no sold products in the warehouse"
    lateinit var warehouse: Warehouse

    override fun addWarehouse(warehouse: Warehouse) {
        this.warehouse = warehouse
    }

    override fun update() {
        if(warehouse.sold.size != 0) {
            info = "Sold products in warehouse:\n" +
                    "###########################\n"
            for(sold in warehouse.sold) {
                info += "\n$sold\n"
            }
            info += "###########################\n" +
                    "###########################\n\n"
        }
        else {
            info = "There is no sold products in the warehouse"
        }
    }
}