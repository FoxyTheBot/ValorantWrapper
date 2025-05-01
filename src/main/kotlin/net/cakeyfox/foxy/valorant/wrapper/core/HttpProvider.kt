package net.cakeyfox.foxy.valorant.wrapper.core

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object HttpProvider {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }

    fun replaceUrlParams(url: String, params: Map<String, String>): String {
        var updatedUrl = url
        params.forEach { (key, value) ->
            updatedUrl = updatedUrl.replace("{$key}", value)
        }
        return updatedUrl
    }

    suspend inline fun <reified T> get(
        url: String,
        urlParams: Map<String, String> = emptyMap(),
        headers: Map<String, String> = emptyMap()
    ): T {
        val updatedUrl = replaceUrlParams(url, urlParams)
        return client.get(updatedUrl) {
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }.body()
    }

    fun close() {
        client.close()
    }
}