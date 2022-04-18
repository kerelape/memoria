package me.kerelape.memoria.core

interface MutableMemory<T> : Memory<T> {

    /**
     * Saves the [value]
     */
    fun write(value: T)
}
