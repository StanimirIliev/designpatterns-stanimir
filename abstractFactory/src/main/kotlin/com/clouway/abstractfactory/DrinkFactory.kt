package com.clouway.abstractfactory

open class DrinkFactory: AbstractFactory {
    override fun getMeal(dinner: String): Dinner? {
        return null
    }

    override fun getDrink(drink: String): Drink? {
        if(drink.compareTo("tea", ignoreCase = true) == 0){
            return Tea()
        }
        if(drink.compareTo("water", ignoreCase = true) == 0){
            return Water()
        }
        return null
    }
}