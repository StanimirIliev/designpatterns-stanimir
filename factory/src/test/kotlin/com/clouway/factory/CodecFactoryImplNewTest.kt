package com.clouway.factory

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CodecFactoryImplNewTest {
    val factory = CodecFactoryImplNew()

    @Test
    fun getXmlObject() {
        val xmlObject = factory.getCodec("xmlcodec")!!
        assertThat(xmlObject::class.java.canonicalName, `is`(equalTo("com.clouway.factory.codecs.XMLCodec")))
    }

    @Test
    fun getJsonObject() {
        val jsonObject = factory.getCodec("jsoncodec")!!
        assertThat(jsonObject::class.java.canonicalName, `is`(equalTo("com.clouway.factory.codecs.JSONCodec")))
    }

    @Test(expected = KotlinNullPointerException::class)
    fun typoInObjectDescription() {
        factory.getCodec("")!!
    }
}