package net.cakeyfox.foxy.valorant.wrapper.utils

@kotlinx.serialization.Serializable
data class ApiErrorResponse(
    val status: Int,
    val errors: List<ApiError>
)

@kotlinx.serialization.Serializable
data class ApiError(
    val message: String,
    val code: Int,
    val details: String
)

