@file:Suppress("unused")

package com.wing4merbr.valorant.wrapper

import com.wing4merbr.valorant.wrapper.match.Match
import com.wing4merbr.valorant.wrapper.user.User
import com.wing4merbr.valorant.wrapper.utils.Endpoints
import com.wing4merbr.valorant.wrapper.utils.Utils


class ValorantWrapper(token: String) {
    val user = User(token)
    val match = Match(token)
    val utils = Utils
    val endpoints = Endpoints
}