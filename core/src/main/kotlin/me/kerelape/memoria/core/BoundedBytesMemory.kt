package me.kerelape.memoria.core

class BoundedBytesMemory(private val min: Int, private val max: Int, private val origin: BytesMemory) : BytesMemory {

    constructor(max: Int, origin: BytesMemory) : this(0, max, origin)

    override fun write(value: ByteArray) {
        if (value.size !in min..max) {
            throw IllegalArgumentException("Size of given byte array is out of bounds (${min..max})")
        }
        this.origin.write(value)
    }

    override fun value(): ByteArray {
        return this.origin.value()
    }
}