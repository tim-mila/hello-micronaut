package com.alimmit.hello

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.on

class EchoControllerSpec: Spek ({

    describe("EchoController") {
        val embeddedServer : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client: HttpClient = HttpClient.create(embeddedServer.url)
        on("test /echo?input=Foo responds \"Echo: Foo\"") {
            val r : String = client.toBlocking().retrieve("/echo?input=Foo")
            assert("Echo: Foo" == r)
        }
        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})