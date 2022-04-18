package me.kerelape.memoria.core

interface Memory<out T> {

    /**
     * @return Stored value
     */
    fun value(): T
}
