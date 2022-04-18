package me.kerelape.memoria.core

/**
 * Memory of two sources
 */
class TwinMemory<T>(private val origin: MutableMemory<T>, private val mirror: MutableMemory<T>) : MutableMemory<T> {

    override fun write(value: T) {
        this.origin.write(value)
        this.mirror.write(value)
    }

    override fun value(): T {
        return this.origin.value()
    }
}
