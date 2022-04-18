package me.kerelape.memoria.core

import me.kerelape.memoria.core.primitives.StringMemory
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
