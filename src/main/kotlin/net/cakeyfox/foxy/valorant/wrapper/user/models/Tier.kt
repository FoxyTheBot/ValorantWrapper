package net.cakeyfox.foxy.valorant.wrapper.user.models

@kotlinx.serialization.Serializable
data class Tier(
    val id: Int? = 0,
    val name: String? = "Unranked"
)