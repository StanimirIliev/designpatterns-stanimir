package com.clouway.abstractfactory

interface AbstractFactory {
    fun getDrink(drink: String): Drink?
    fun getMeal(meal: String): Meal?
}