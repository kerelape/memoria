> **Warning**
> Functionality of this library is now in [reikai](https://github.com/kerelape/reikai)

# <img src="https://raw.githubusercontent.com/kerelape/memoria/develop/memoria.png" height="64px" /> Memoria

> Why should an object care about where to store their bytes?

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](http://www.rultor.com/b/yegor256/cactoos)](http://www.rultor.com/p/yegor256/cactoos)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

![Code quality](https://api.codiga.io/project/32832/score/svg)
![Code grade](https://api.codiga.io/project/32832/status/svg)

## Examples

### Basics
RAM can used as a memory storage:
```kotlin
val ram: BytesMemory = RamMemory()
```

Also a file could:
```kotlin
val cache: BytesMemory = FileMemory(File("//path"))
```

### Restrictions
If you do not want your object to suddenly take to much space:
```kotlin
BoundedBytesMemory(
    min = 0, // might be omitted (0 by default)
    max = 128,
    RamMemory()
)
```

Thus, once the limit is overflown you'll see `IllegalArgumentExcepton`

### Useful
#### Primitives
There is a number of adapters to kotlin 'primitives'. These use `BytesMemory` to store the value,
but acts as memory of their type:
 - `StringMemory` implements `MutableMemory<String>`, so you can `write("Hello, World")` instread of working with bytes.
 - `IntMemory`.

#### TwinMemory
`TwinMemory` class allows you to have two different (or the same... why not) memory sources:
```kotlin
val twin = StringMemory(
    TwinMemory(
        RamMemory(),
        FileMemory(
            File("twin.txt")
        )
    )
)

twin.write("twin me!") // -> will write the value to both sources, ram and file
twin.value() // -> returns value stored in ram, the first (origin) argument of the constructor
```
