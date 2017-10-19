package com.clouway.abstractfactory

class FactoryProducer {
    fun getFactory(choice: String): AbstractFactory? {
        if (choice.equals("meal", ignoreCase = true)) {
            return MealFactory()

        } else if (choice.equals("drink", ignoreCase = true)) {
            return DrinkFactory()
        }
        return null
    }
}