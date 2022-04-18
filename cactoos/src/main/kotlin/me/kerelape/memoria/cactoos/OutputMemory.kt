package me.kerelape.memoria.cactoos

import me.kerelape.memoria.core.BytesMemory
import org.cactoos.Output
import java.io.OutputStream

class OutputMemory(private val memory: BytesMemory) : Output {

    override fun stream(): OutputStream {
        return object : OutputStream() {
            override fun write(b: Int) {
                this@OutputMemory.memory.write(byteArrayOf(*this@OutputMemory.memory.value(), b.toByte()))
            }
        }
    }
}
