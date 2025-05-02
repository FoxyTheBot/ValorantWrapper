package com.wing4merbr.valorant.wrapper.match.models

import com.wing4merbr.valorant.wrapper.user.models.Tier
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class MatchInfo(
    val status: Int,
    val data: MatchData
) {
    @kotlinx.serialization.Serializable
    data class MatchData(
        val metadata: Metadata,
        val players: List<Metadata.PlayerInMatch>? = null
    ) {
        @kotlinx.serialization.Serializable
        data class Metadata(
            @SerialName("match_id")
            val matchId: String,
            val map: MapInfo,
            @SerialName("game_version")
            val gameVersion: String,
            @SerialName("game_length_in_ms")
            val gameLengthInMs: Long,
            @SerialName("is_completed")
            val isCompleted: Boolean,
            val queue: Queue,
            val season: Season,
            val platform: String,
            val players: List<PlayerInMatch>? = null
        ) {

            @kotlinx.serialization.Serializable
            data class PlayerInMatch(
                val puuid: String,
                val name: String,
                val tag: String,
                @SerialName("team_id")
                val teamId: String? = null,
                val platform: String,
                val agent: Agent,
                val stats: Stats,
                @SerialName("ability_casts")
                val abilityCasts: AbilityCasts? = null,
                val tier: Tier
            ) {
                @kotlinx.serialization.Serializable
                data class AbilityCasts(
                    val grenade: Int? = 0,
                    @SerialName("ability_1")
                    val abilityOne: Int? = 0,
                    @SerialName("ability_2")
                    val abilityTwo: Int? = 0,
                    val ultimate: Int? = 0
                )
                @kotlinx.serialization.Serializable
                data class Stats(
                    val score: Int? = 0,
                    val kills: Int,
                    val deaths: Int,
                    val assists: Int,
                    val headshots: Int,
                    val legshots: Int,
                    val bodyshots: Int,
                    val damage: Damage
                ) {
                    @kotlinx.serialization.Serializable
                    data class Damage(
                        val dealt: Int,
                        val received: Int
                    )
                }
            }
        }
    }
}
