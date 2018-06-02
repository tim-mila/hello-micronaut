package com.alimmit.hello

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build().packages("com.alimmit.hello").mainClass(Application.javaClass).start()
    }
}