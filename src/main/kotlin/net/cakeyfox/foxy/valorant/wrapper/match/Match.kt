@file:Suppress("unused")

package net.cakeyfox.foxy.valorant.wrapper.match

import net.cakeyfox.foxy.valorant.wrapper.core.HttpProvider
import net.cakeyfox.foxy.valorant.wrapper.match.models.MatchInfo
import net.cakeyfox.foxy.valorant.wrapper.match.models.MatchList
import net.cakeyfox.foxy.valorant.wrapper.utils.Endpoints
import net.cakeyfox.foxy.valorant.wrapper.utils.Utils

class Match(token: String) {
    private val headers = mapOf("Authorization" to token)

    suspend fun getMatchById(matchId: String, region: String): MatchInfo {
        val url = Endpoints.GET_MATCH_BY_ID
        val params = mapOf(
            "id" to matchId,
            "region" to region
        )

        return HttpProvider.get(url, params, headers)
    }

    // TODO: Create a data class for these methods
    suspend fun getMatchesByUserTag(userTag: String, region: String, platform: String): MatchList {
        val url = Endpoints.GET_MATCHES_BY_USERTAG
        val user = Utils.formatUserTag(userTag)
        val params = mapOf(
            "name" to user.name,
            "tag" to user.tag,
            "region" to region,
            "platform" to platform
        )

        return HttpProvider.get(url, params, headers)
    }

    suspend fun getMatchesByUuid(puuid: String, region: String, platform: String): MatchList {
        val url = Endpoints.GET_MATCHES_BY_UUID
        val params = mapOf(
            "puuid" to puuid,
            "region" to region,
            "platform" to platform.uppercase()
        )

        return HttpProvider.get(url, params, headers)
    }
}