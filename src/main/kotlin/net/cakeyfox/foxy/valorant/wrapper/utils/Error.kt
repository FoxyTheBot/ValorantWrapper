package net.cakeyfox.foxy.valorant.wrapper.utils

@kotlinx.serialization.Serializable
data class ApiErrorResponse(
    val status: Int,
    val errors: List<ApiError>? = emptyList()
)

@kotlinx.serialization.Serializable
data class ApiError(
    val message: String? = null,
    val code: Int? = 0,
    val details: String? = null
)

