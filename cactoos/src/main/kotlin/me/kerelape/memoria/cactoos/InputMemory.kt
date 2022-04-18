package me.kerelape.memoria.cactoos

import me.kerelape.memoria.core.BytesMemory
import org.cactoos.Bytes
import org.cactoos.Input
import org.cactoos.io.InputStreamOf
import java.io.InputStream

class InputMemory(private val memory: BytesMemory) : Input {

    override fun stream(): InputStream {
        return InputStreamOf(
            Bytes {
                this.memory.value()
            }
        )
    }
}
