package net.cakeyfox.foxy.valorant.wrapper.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class MatchInfo(
    val status: Int,
    val data: MatchData
) {
    @kotlinx.serialization.Serializable
    data class MatchData(
        val metadata: Metadata
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
            val players: List<PlayerInMatch>
        ) {

            @kotlinx.serialization.Serializable
            data class PlayerInMatch(
                val puuid: String,
                val name: String,
                val tag: String,
                @SerialName("team_id")
                val teamId: String,
                val platform: String,
                val agent: Agent,
                val stats: Stats,
                @SerialName("ability_casts")
                val abilityCasts: AbilityCasts,
                val tier: Tier
            ) {
                @kotlinx.serialization.Serializable
                data class AbilityCasts(
                    val grenade: Int,
                    @SerialName("ability_1")
                    val abilityOne: Int,
                    @SerialName("ability_2")
                    val abilityTwo: Int,
                    val ultimate: Int
                )
                @kotlinx.serialization.Serializable
                data class Stats(
                    val score: Int,
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
