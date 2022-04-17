package me.kerelape.memoria.core

import org.junit.Test
import kotlin.test.assertContentEquals

class RamMemoryTest {

    @Test
    fun `can store simple byte array`() {
        assertContentEquals(
            byteArrayOf(0xA, 0xB, 0xC),
            with(RamMemory()) {
                write(byteArrayOf(0xA, 0xB, 0xC))
                value()
            }
        )
    }
}
