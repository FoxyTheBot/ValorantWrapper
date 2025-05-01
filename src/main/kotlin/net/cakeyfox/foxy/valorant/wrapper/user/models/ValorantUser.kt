package net.cakeyfox.foxy.valorant.wrapper.user.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ValorantUser(
    val status: Int,
    val data: UserData
) {
    @kotlinx.serialization.Serializable
    data class UserData(
        val puuid: String,
        val region: String,
        @SerialName("account_level")
        val accountLevel: Long,
        val name: String,
        val tag: String,
        val card: String,
        val title: String,
        val platforms: List<String>
    )
}
