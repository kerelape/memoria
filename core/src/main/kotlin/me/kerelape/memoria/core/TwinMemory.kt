package me.kerelape.memoria.core

/**
 * Memory of two sources
 */
class TwinMemory<T>(private val origin: Memory<T>, private val mirror: Memory<T>) : Memory<T> {

    override fun write(value: T) {
        this.origin.write(value)
        this.mirror.write(value)
    }

    override fun value(): T {
        return this.origin.value()
    }
}
