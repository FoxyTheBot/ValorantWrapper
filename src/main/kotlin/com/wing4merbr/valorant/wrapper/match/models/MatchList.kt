package com.wing4merbr.valorant.wrapper.match.models

@kotlinx.serialization.Serializable
data class MatchList(
    val status: Int,
    val data: List<MatchInfo.MatchData>
)
