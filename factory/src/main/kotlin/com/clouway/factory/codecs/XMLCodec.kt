package com.clouway.factory.codecs

import com.thoughtworks.xstream.XStream
import java.io.InputStream
import java.lang.reflect.Type

class XMLCodec : MessageCodec {

    override fun encode(value: Any): String {
        return XStream().toXML(value)
    }

    @SuppressWarnings("unchecked")
    override fun <T> decode(type: Type, source: InputStream): T {
        return XStream().fromXML(source) as T
    }
}