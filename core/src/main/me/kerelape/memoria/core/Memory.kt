package me.kerelape.memoria.core

interface Memory<T> {

    /**
     * Saves the [value]
     */
    fun write(value: T)

    /**
     * @return Stored value
     */
    fun value(): T
}