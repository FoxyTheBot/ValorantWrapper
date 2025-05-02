package com.wing4merbr.valorant.wrapper.user.models

@kotlinx.serialization.Serializable
data class SimpleValorantUser(
    val puuid: String,
    val name: String,
    val tag: String
)
