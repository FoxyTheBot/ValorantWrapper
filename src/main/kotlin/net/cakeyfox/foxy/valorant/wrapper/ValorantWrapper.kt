package net.cakeyfox.foxy.valorant.wrapper

import net.cakeyfox.foxy.valorant.wrapper.core.HttpProvider
import net.cakeyfox.foxy.valorant.wrapper.user.User

class ValorantWrapper(token: String) {
    val client = HttpProvider()

    val user = User(token)
    // TODO: Create "Match" class and data classes
    // Reference: https://docs.henrikdev.xyz/valorant/changes/v4.0.0
}