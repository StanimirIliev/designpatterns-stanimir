package com.clouway.singleton

class Singleton private constructor() {

    companion object {
        val singleton = Singleton()
        fun getInstance(): Singleton {
            return singleton
        }
    }

    init {
        println("Singleton created")
    }
}