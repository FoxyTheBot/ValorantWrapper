package com.wing4merbr.valorant.wrapper.utils

object Utils {
    fun formatUserTag(userTag: String): com.wing4merbr.valorant.wrapper.utils.ValorantUsername {
        val parts = userTag.split("#")
        require(parts.size == 2) { throw IllegalArgumentException("Expected NAME#TAG") }

        return com.wing4merbr.valorant.wrapper.utils.ValorantUsername(
            name = parts[0],
            tag = parts[1]
        )
    }
}