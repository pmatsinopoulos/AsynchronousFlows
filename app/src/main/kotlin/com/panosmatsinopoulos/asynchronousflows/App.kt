/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.panosmatsinopoulos.asynchronousflows

fun simple(): Sequence<Int> = sequence {
    repeat(3) { it ->
        Thread.sleep(1_000)
        yield(it)
    }
}

fun main() {
    simple().forEach { value -> println(value) }
}
