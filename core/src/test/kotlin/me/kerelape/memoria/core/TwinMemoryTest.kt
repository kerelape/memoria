package me.kerelape.memoria.core

import org.junit.Test
import kotlin.test.assertEquals

class TwinMemoryTest {

    @Test
    fun `can write to two sources`() {
        val mirror = StringMemory(RamMemory())
        val twin = TwinMemory(
            StringMemory(
                RamMemory()
            ),
            mirror
        )
        assertEquals(
            "Hello, World",
            with(twin) {
                write("Hello, World")
                mirror.value()
            }
        )
    }
}