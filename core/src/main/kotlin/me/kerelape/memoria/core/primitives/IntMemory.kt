package me.kerelape.memoria.core.primitives

import me.kerelape.memoria.core.BytesMemory
import me.kerelape.memoria.core.Memory
import java.nio.ByteBuffer

class IntMemory(private val memory: BytesMemory) : Memory<Int> {

    override fun write(value: Int) {
        val buffer = ByteBuffer.allocate(Int.SIZE_BYTES).putInt(value)
        this.memory.write(buffer.array())
    }

    override fun value(): Int {
        return ByteBuffer.wrap(this.memory.value()).int
    }
}