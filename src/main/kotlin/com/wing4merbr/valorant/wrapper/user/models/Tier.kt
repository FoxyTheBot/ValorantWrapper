package com.wing4merbr.valorant.wrapper.user.models

@kotlinx.serialization.Serializable
data class Tier(
    val id: Int? = 0,
    val name: String? = "Unranked"
)