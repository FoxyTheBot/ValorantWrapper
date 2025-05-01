package net.cakeyfox.foxy.valorant.wrapper.user.models

import kotlinx.serialization.SerialName
import net.cakeyfox.foxy.valorant.wrapper.match.models.Season

@kotlinx.serialization.Serializable
data class MmrData(
    val status: Int,
    val data: Mmr
) {
    @kotlinx.serialization.Serializable
    data class Mmr(
        val account: SimpleValorantUser,
        val peak: Peak,
        @SerialName("current")
        val currentInfo: CurrentInfo
    ) {
        @kotlinx.serialization.Serializable
        data class CurrentInfo(
            val tier: Tier,
            val rr: Int,
            @SerialName("last_change")
            val lastChange: Int,
            val elo: Int
        )
        @kotlinx.serialization.Serializable
        data class Peak(
            val season: Season,
            @SerialName("ranking_schema")
            val rankingSchema: String,
            val tier: Tier
        )
    }
}
