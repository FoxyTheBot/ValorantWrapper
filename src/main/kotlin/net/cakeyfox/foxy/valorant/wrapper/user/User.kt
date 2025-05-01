package net.cakeyfox.foxy.valorant.wrapper.user

import net.cakeyfox.foxy.valorant.wrapper.core.HttpProvider
import net.cakeyfox.foxy.valorant.wrapper.utils.Endpoints

class User(private val token: String) {
    private val headers = mapOf("Authorization" to "Bearer $token")

    suspend fun getUserByTag(userTag: String): Any {
        val parts = userTag.split("#")
        require(parts.size == 2) { throw IllegalArgumentException("Expected NAME#TAG") }
        val username = parts[0]
        val tag = parts[1]

        val params = mapOf("name" to username, "tag" to tag)
        val url = Endpoints.GET_USER_BY_USERTAG
        return HttpProvider.get(url, params, headers)
    }

    suspend fun getUserByUUID(uuid: String): Any {
        val url = Endpoints.GET_USER_BY_UUID
        val params = mapOf("puuid" to uuid)
        return HttpProvider.get(url, params, headers)
    }
}