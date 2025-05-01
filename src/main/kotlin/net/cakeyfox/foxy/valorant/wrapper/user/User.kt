@file:Suppress("unused")

package net.cakeyfox.foxy.valorant.wrapper.user

import net.cakeyfox.foxy.valorant.wrapper.core.HttpProvider
import net.cakeyfox.foxy.valorant.wrapper.user.models.MmrData
import net.cakeyfox.foxy.valorant.wrapper.user.models.ValorantUser
import net.cakeyfox.foxy.valorant.wrapper.utils.Endpoints
import net.cakeyfox.foxy.valorant.wrapper.utils.Utils

class User(token: String) {
    private val headers = mapOf("Authorization" to "Bearer $token")

    suspend fun getUserByTag(userTag: String): ValorantUser {
        val user = Utils.formatUserTag(userTag)

        val params = mapOf("name" to user.name, "tag" to user.tag)
        val url = Endpoints.GET_USER_BY_USERTAG
        return HttpProvider.get(url, params, headers)
    }

    suspend fun getUserByUUID(uuid: String): ValorantUser {
        val url = Endpoints.GET_USER_BY_UUID
        val params = mapOf("puuid" to uuid)
        return HttpProvider.get(url, params, headers)
    }

    suspend fun getMmrByTag(userTag: String, region: String, platform: String): MmrData {
        val user = Utils.formatUserTag(userTag)
        val url = Endpoints.GET_MMR_BY_USERTAG
        val params = mapOf(
            "name" to user.name,
            "tag" to user.tag,
            "region" to region,
            "platform" to platform
        )

        return HttpProvider.get(url, params, headers)
    }

    suspend fun getMmrByUUID(puuid: String, region: String, platform: String): MmrData {
        val url = Endpoints.GET_MMR_BY_UUID
        val params = mapOf(
            "puuid" to puuid,
            "region" to region,
            "platform" to platform
        )

        return HttpProvider.get(url, params, headers)
    }
}