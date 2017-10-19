package com.clouway.abstractfactory

fun main(args: Array<String>) {
    val factoryProducer = FactoryProducer()
    val lunch = factoryProducer.getFactory("meal")?.getMeal("lunch")
    lunch?.whatMealIsThis()
    val water = factoryProducer.getFactory("drink")?.getDrink("water")
    water?.whatDrinkIsThis()
}