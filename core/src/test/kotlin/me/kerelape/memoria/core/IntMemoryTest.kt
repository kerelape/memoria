package me.kerelape.memoria.core

import me.kerelape.memoria.core.primitives.IntMemory
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class IntMemoryTest {

    @Test
    fun `can convert`() {
        val value = Random.nextInt()
        assertEquals(
            value,
            with(IntMemory(RamMemory())) {
                write(value)
                value()
            }
        )
    }
}