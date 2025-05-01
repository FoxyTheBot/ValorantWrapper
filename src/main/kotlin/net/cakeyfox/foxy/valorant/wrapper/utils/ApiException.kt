package net.cakeyfox.foxy.valorant.wrapper.utils

class ApiException(error: ApiErrorResponse) : Exception(
    "API Error ${error.status}: ${error.errors.joinToString { it.message }}"
)