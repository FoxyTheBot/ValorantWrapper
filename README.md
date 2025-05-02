# 🦊 ValorantWrapper

A simple [Unofficial VALORANT API](https://github.com/Henrik-3/unofficial-valorant-api) wrapper written in Kotlin

<div align="center">

[![](https://jitpack.io/v/WinG4merBR/ValorantWrapper.svg)](https://jitpack.io/#WinG4merBR/ValorantWrapper)

</div>


## ❓ Can I use?
Yes, you can use this wrapper! Just follow the installation instructions.

## 📦 Installation

Add the following dependency to your `build.gradle.kts` file:

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.WinG4merBR:ValorantWrapper:VERSION")
}
```

## 🔧 Requirements

- Kotlin: 2.0.0 or latest
- Java 21 or latest
- Ktor 3.0.3 or latest

## 🚀 Features

- **Account Information**: Retrieve user data by `name#tag` or `UUID`.
- **MMR Data**: Get the MMR of a player based on their `name#tag` or `UUID`.
- **Match Information**: Fetch detailed match information by match ID, `name#tag`, or `UUID`.

## 🛠️ Usage

### 1. Get User Information by UserTag

```kotlin
suspend fun getUserByTag(userTag: String): ValorantUser
```

Example:

```kotlin
val userTag = "username#1234"
val userInfo = wrapper.getUserByTag(userTag)
println(userInfo)
```

### 2. Get MMR by UserTag

```kotlin
suspend fun getMmrByTag(userTag: String, region: String): MmrInfo
```

Example:

```kotlin
val region = "na"
val userTag = "username#1234"
val mmrInfo = wrapper.getMmrByTag(userTag, region)
println(mmrInfo)
```

### 3. Get Match Info by Match ID

```kotlin
suspend fun getMatchById(matchId: String, region: String): MatchInfo
```

Example:

```kotlin
val region = "na"
val matchId = "someMatchId"
val matchInfo = wrapper.getMatchById(matchId, region)
println(matchInfo)
```

## ❓ Npm version when?
Never :3
