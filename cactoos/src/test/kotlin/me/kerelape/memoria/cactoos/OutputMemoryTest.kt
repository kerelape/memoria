package me.kerelape.memoria.cactoos

import me.kerelape.memoria.core.RamMemory
import me.kerelape.memoria.core.primitives.StringMemory
import org.cactoos.io.OutputStreamTo
import org.junit.Test
import kotlin.test.assertEquals

class OutputMemoryTest {

    @Test
    fun `can write String`() {
        val string = "eo is the best language"
        val memory = RamMemory()
        OutputStreamTo(
            OutputMemory(
                memory
            )
        ).write(RamMemory().apply { StringMemory(this).write(string) }.value())
        assertEquals(
            string,
            StringMemory(memory).value()
        )
    }
}