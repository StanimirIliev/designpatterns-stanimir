package com.clouway.factory

import com.clouway.factory.codecs.JSONCodec
import com.clouway.factory.codecs.MessageCodec
import com.clouway.factory.codecs.XMLCodec

class CodecFactoryImplNew : CodecFactory {
    override fun getCodec(codec: String): MessageCodec? {
        if (codec.compareTo("XMLCODEC", ignoreCase = true) == 0) {
            return XMLCodec()
        }
        if (codec.compareTo("JSONCODEC", ignoreCase = true) == 0) {
            return JSONCodec()
        }
        return null
    }
}