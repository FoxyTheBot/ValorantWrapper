package net.cakeyfox.foxy.valorant.wrapper.user.models

import kotlinx.serialization.SerialName

data class ValorantUser(
    val status: Int,
    val data: UserData
) {
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
