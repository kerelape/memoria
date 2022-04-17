package me.kerelape.memoria.core

import org.junit.Test
import java.io.File
import kotlin.test.assertContentEquals

class FileMemoryTest {

    @Test
    fun `can store`() {
        val file = File.createTempFile("test", "can_store")
        assertContentEquals(
            byteArrayOf(0x0, 0x1, 0x2),
            with(FileMemory(file)) {
                write(byteArrayOf(0x0, 0x1, 0x2))
                value()
            }
        )
        file.delete()
    }
}
