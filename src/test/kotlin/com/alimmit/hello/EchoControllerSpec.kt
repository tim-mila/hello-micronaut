package com.alimmit.hello

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.on

class EchoControllerSpec: Spek ({

    describe("HelloController") {
        val embeddedServer : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client: HttpClient = HttpClient.create(embeddedServer.url)
        on("test /hello responds \"Hello\"") {
            val r : String = client.toBlocking().retrieve("/hello")
            assert("Hello" == r)
        }
        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})