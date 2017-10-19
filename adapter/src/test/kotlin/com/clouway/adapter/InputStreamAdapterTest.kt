package com.clouway.adapter

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class InputStreamAdapterTest {
    @Test
    fun readFile() {
        val inputStream = InputStreamAdapter::class.java.getResourceAsStream("Text.txt")
        val allBytes = inputStream.available()
        val adapter = InputStreamAdapter(inputStream)
        var count: Int
        var downloadedBytes = 0
        val buffer = ByteArray(1024)
        do {
            count = adapter.read(buffer, 0, 1024)
            if (count == -1) {
                break
            }
            downloadedBytes += count
        } while (true)
        assertThat(downloadedBytes, `is`(equalTo(allBytes)))
    }
}