package me.kerelape.memoria.core

import org.junit.Test
import kotlin.test.assertFails

class BoundedBytesMemoryTest {

    @Test
    fun `fails with too large array`() {
        assertFails {
            with(BoundedBytesMemory(2, RamMemory())) {
                write(byteArrayOf(0x0, 0x0, 0x0))
            }
        }
    }

    @Test
    fun `fails with too small array`() {
        assertFails {
            with(BoundedBytesMemory(2, Int.MAX_VALUE, RamMemory())) {
                write(byteArrayOf(0x0))
            }
        }
    }
}