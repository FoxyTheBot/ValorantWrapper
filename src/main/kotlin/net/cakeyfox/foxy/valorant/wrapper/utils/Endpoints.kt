package net.cakeyfox.foxy.valorant.wrapper.utils

object Endpoints {

    private const val BASE_URL = "https://api.henrikdev.xyz"

    /* User endpoints */
    // https://docs.henrikdev.xyz/valorant/changes/v4.0.0#endpoint-account

    const val GET_USER_BY_USERTAG = "$BASE_URL/valorant/v2/account/{name}/{tag}"
    const val GET_USER_BY_UUID = "$BASE_URL/valorant/by-puuid/v2/account/{puuid}"

    /* User MMR endpoints */
    // https://docs.henrikdev.xyz/valorant/changes/v4.0.0#endpoint-matches

    const val GET_MMR_BY_USERTAG = "$BASE_URL/valorant/v3/mmr/{region}/{platform}/{name}/{tag}"
    const val GET_MMR_BY_UUID = "$BASE_URL/valorant/v3/by-puuid/{region}/{platform}/{puuid}"

    /* Match endpoints */
    // https://docs.henrikdev.xyz/valorant/changes/v4.0.0#endpoint-matches

    const val GET_MATCH_BY_ID = "$BASE_URL/valorant/v4/match/{region}/{platform}/{id}"
    const val GET_MATCHES_BY_USERTAG = "$BASE_URL/valorant/v4/matches/{region}/{platform}/{name}/{tag}"
    const val GET_MATCHES_BY_UUID = "$BASE_URL/valorant/v4/by-puuid/matches/{region}/{platform}/{puuid}"
}
