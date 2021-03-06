package me.kerelape.memoria.core

/**
 * Memory that writes value to [destination] when it's read from [origin]
 */
class TeeMemory<T>(private val origin: MutableMemory<T>, private val destination: MutableMemory<T>) : MutableMemory<T> {

    override fun write(value: T) {
        this.origin.write(value)
    }

    override fun value(): T {
        val value = this.origin.value()
        this.destination.write(value)
        return value
    }
}
