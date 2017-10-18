package com.clouway.factory

import com.clouway.factory.codecs.MessageCodec

interface CodecFactory {
    fun getCodec(codec: String): MessageCodec?
}