package com.clouway.adapter

import java.io.InputStream


class InputStreamAdapter(val stream: InputStream) {
    fun read(b: ByteArray?, off: Int, len: Int): Int {
        return stream.read(b, off, len)
    }
}