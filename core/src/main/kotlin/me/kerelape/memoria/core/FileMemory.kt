package me.kerelape.memoria.core

import java.io.File

class FileMemory(private val destination: File) : BytesMemory {

    override fun write(value: ByteArray) {
        if (!this.destination.exists()) {
            this.destination.createNewFile()
        }
        require(this.destination.isFile) { "Cannot store a byte array into directory" }
        this.destination.writeBytes(value)
    }

    override fun value(): ByteArray {
        return this.destination.readBytes()
    }
}