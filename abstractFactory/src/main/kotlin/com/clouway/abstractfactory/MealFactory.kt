package com.clouway.abstractfactory

open class MealFactory: AbstractFactory {
    override fun getMeal(meal: String): Meal?{
        if(meal.compareTo("dinner", ignoreCase = true) == 0) {
            return Dinner()
        }
        if(meal.compareTo("lunch", ignoreCase = true) == 0) {
            return Lunch()
        }
        return null
    }

    override fun getDrink(drink: String): Drink? {
        return null
    }
}