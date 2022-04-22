package me.kerelape.memoria.cactoos

import me.kerelape.memoria.core.BytesMemory
import me.kerelape.memoria.core.RamMemory
import org.cactoos.Output
import java.io.OutputStream

class OutputMemory(private val memory: BytesMemory) : Output {

    override fun stream(): OutputStream {
        return object : OutputStream() {
            private val buffer: BytesMemory = RamMemory()

            override fun write(b: Int) {
                // Check fails here due to '*' (spread) operator
                // Tho I cannot see a more elegant way to do it
                // @kerelape — issue #7
                this.buffer.write(byteArrayOf(*this.buffer.value(), b.toByte()))
                this@OutputMemory.memory.write(this.buffer.value())
            }
        }
    }
}
