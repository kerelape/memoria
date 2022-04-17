package me.kerelape.memoria.core

class RamMemory(default: ByteArray) : BytesMemory {
    private var value = default

    constructor() : this(ByteArray(0))

    override fun write(value: ByteArray) {
        this.value = value
    }

    override fun value(): ByteArray {
        return this.value
    }
}