package me.kerelape.memoria.core

import java.nio.charset.Charset

class StringMemory(private val memory: BytesMemory, private val charset: Charset) : MutableMemory<String> {

    constructor(memory: BytesMemory) : this(memory, Charsets.UTF_8)

    override fun write(value: String) {
        this.memory.write(value.toByteArray(this.charset))
    }

    override fun value(): String {
        return String(this.memory.value(), this.charset)
    }
}
