package com.wing4merbr.valorant.wrapper.utils

class ApiException(error: ApiErrorResponse) : Exception(
    "API Error ${error.status}: ${error.errors?.joinToString { it.message.toString() }}"
)