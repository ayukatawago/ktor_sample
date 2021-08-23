package com.example.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

@Suppress("unused")
fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
