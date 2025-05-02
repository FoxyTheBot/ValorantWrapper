package com.wing4merbr.valorant.wrapper.core

import com.wing4merbr.valorant.wrapper.utils.ApiError
import com.wing4merbr.valorant.wrapper.utils.ApiErrorResponse
import com.wing4merbr.valorant.wrapper.utils.ApiException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object HttpProvider {
    val client = HttpClient(CIO) {
        expectSuccess = false
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
        val updatedUrl = HttpProvider.replaceUrlParams(url, urlParams)

        val response = HttpProvider.client.get(updatedUrl) {
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }

        return if (response.status.value in 200..299) {
            response.body()
        } else {
            val errorBody = response.bodyAsText()
            val apiError = try {
                Json.decodeFromString<ApiErrorResponse>(errorBody)
            } catch (_: Exception) {
                ApiErrorResponse(
                    status = response.status.value,
                    errors = listOf(ApiError("Unexpected error", -1, errorBody))
                )
            }
            throw ApiException(apiError)
        }
    }

    fun close() {
        com.wing4merbr.valorant.wrapper.core.HttpProvider.client.close()
    }
}