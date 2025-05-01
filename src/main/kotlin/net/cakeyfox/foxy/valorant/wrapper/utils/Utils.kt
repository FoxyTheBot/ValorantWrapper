package net.cakeyfox.foxy.valorant.wrapper.utils

object Utils {
    fun formatUserTag(userTag: String): ValorantUsername {
        val parts = userTag.split("#")
        require(parts.size == 2) { throw IllegalArgumentException("Expected NAME#TAG") }

        return ValorantUsername(
            name = parts[0],
            tag = parts[1]
        )
    }
}