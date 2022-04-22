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

    /**
     * Issue #7
     */
    @Test
    fun `doesn't append with multiple streams`() {
        val string = "abc"
        val memory = RamMemory()
        with(OutputMemory(memory)) {
            OutputStreamTo(this).write(string.toByteArray())
            OutputStreamTo(this).write(string.toByteArray())
        }
        assertEquals(
            string,
            StringMemory(memory).value()
        )
    }
}