package com.clouway.builder

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DefaultArguments {

    fun funWithDefaultArgs(str: String = "default string"): String {
        return str
    }

    @Test
    fun usingDefaultArguments() {
        assertThat(funWithDefaultArgs(), `is`(equalTo("default string")))
    }

    @Test
    fun usingCustomArguments() {
        assertThat(funWithDefaultArgs("new string"), `is`(equalTo("new string")))
    }
}