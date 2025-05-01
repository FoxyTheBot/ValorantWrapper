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
            val rr: Int? = 0,
            @SerialName("last_change")
            val lastChange: Int? = 0,
            val elo: Int? = 0
        )
        @kotlinx.serialization.Serializable
        data class Peak(
            val season: Season,
            @SerialName("ranking_schema")
            val rankingSchema: String? = null,
            val tier: Tier
        )
    }
}
