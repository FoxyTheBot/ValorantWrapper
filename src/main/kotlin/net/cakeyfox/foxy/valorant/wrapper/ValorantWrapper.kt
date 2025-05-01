@file:Suppress("unused")

package net.cakeyfox.foxy.valorant.wrapper

import net.cakeyfox.foxy.valorant.wrapper.user.Match
import net.cakeyfox.foxy.valorant.wrapper.user.User
import net.cakeyfox.foxy.valorant.wrapper.utils.Endpoints
import net.cakeyfox.foxy.valorant.wrapper.utils.Utils

class ValorantWrapper(token: String) {
    val user = User(token)
    val match = Match(token)
    val utils = Utils
    val endpoints = Endpoints
}