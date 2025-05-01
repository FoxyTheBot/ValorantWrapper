package net.cakeyfox.foxy.valorant.wrapper.utils

import net.cakeyfox.foxy.valorant.wrapper.models.ApiErrorResponse

class ApiException(private val error: ApiErrorResponse) : Exception(
    "API Error ${error.status}: ${error.errors.joinToString { it.message }}"
)