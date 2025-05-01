package net.cakeyfox.foxy.valorant.wrapper.user.models

@kotlinx.serialization.Serializable
data class SimpleValorantUser(
    val puuid: String,
    val name: String,
    val tag: String
)
