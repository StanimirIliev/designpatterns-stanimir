package com.clouway.factory.codecs

import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type

interface MessageCodec {
    fun encode(value: Any): String
    @Throws(IOException::class)
    fun <T> decode(type: Type, source: InputStream): T
}