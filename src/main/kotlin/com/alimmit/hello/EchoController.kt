package com.alimmit.hello

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class EchoController {

    @Get("/echo")
    fun echo(input: String) : String {
        return input
    }
}