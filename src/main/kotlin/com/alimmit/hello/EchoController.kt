package com.alimmit.hello

import io.micronaut.context.annotation.Parameter
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/echo")
class EchoController {

    @Get("/")
    fun echo(@Parameter input: String): String {
        return "Echo: $input"
    }
}