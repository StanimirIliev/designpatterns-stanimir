package com.clouway.factory.codecs

import com.google.gson.GsonBuilder
import java.io.InputStream
import java.lang.reflect.Type

class JSONCodec : MessageCodec {
    override fun encode(value: Any): String {
        return GsonBuilder().create().toJson(value, value.javaClass)
    }

    override fun <T> decode(type: Type, source: InputStream): T {
        return GsonBuilder().create().fromJson(source.readBytes().toString(), type)
    }
}