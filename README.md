# memoria

Objects that abstract memory inspired by @yegor256 talks  

## Examples
### Immutable cache (persistent)
```kotlin
interface User {
    fun name(): String
}

class RemoteUser : User {
    override fun name(): String {
        return timeConsumingRemoteCall()
    }
}

/**
 * Immutable cache example
 */
class CachedUser(private val origin: User, private val cache: Memory<String>) : User {
    
    override fun name(): String {
        val cache = this.cache.value()
        if (cache.isNotEmpty()) {
            return cache
        }
        val originalValue = this.origin.name()
        this.cache.write(originalValue)
        return this.name()
    }
}

//...
val jeff = 
    CachedUser(
        RemoteUser(),
        StringMemory(
            FileMemory(
                File("jeff.cache")
            )
        )
    )

jeff.name() // -> remote "Jeff"
jeff.name() // -> cached "Jeff"
```