package me.kerelape.memoria.cactoos

import me.kerelape.memoria.core.RamMemory
import me.kerelape.memoria.core.primitives.StringMemory
import org.cactoos.text.TextOf
import org.junit.Test
import kotlin.test.assertEquals

class InputMemoryTest {

    @Test
    fun `can read String`() {
        val string = "cacti!"
        val memory = RamMemory()
        StringMemory(memory).write(string)
        assertEquals(
            string,
            TextOf(
                InputMemory(
                    memory
                )
            ).asString()
        )
    }
}
