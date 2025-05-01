# 🦊 ValorantWrapper

This is a Kotlin wrapper for the [Unofficial VALORANT API](https://github.com/Henrik-3/unofficial-valorant-api), designed to make interacting with VALORANT data easy and efficient. This library is also used internally in the [Foxy](https://github.com/FoxyTheBot/Foxy) project.

## 📦 Installation

Add the following dependency to your `build.gradle.kts` file:

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.FoxyTheBot:ValorantWrapper:1.0.0")
}
```

> Replace `1.0.0` with the version you need.

## 🔧 Requirements

- Kotlin: 2.0.0
- Java 21

## 🚀 Features

- **Account Information**: Retrieve user data by `name#tag` or `UUID`.
- **MMR Data**: Get the MMR of a player based on their `name#tag` or `UUID`.
- **Match Information**: Fetch detailed match information by match ID, `name#tag`, or `UUID`.

## 🛠️ Usage

### 1. Get User Information by UserTag

```kotlin
suspend fun getUserByTag(userTag: String): UserInfo
```

Example:

```kotlin
val userTag = "username#1234"
val userInfo = wrapper.getUserByTag(userTag)
println(userInfo)
```

### 2. Get MMR by UserTag

```kotlin
suspend fun getMMRByTag(userTag: String, region: String): MMRInfo
```

Example:

```kotlin
val region = "na"
val userTag = "username#1234"
val mmrInfo = wrapper.getMMRByTag(userTag, region)
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

## ⚙️ Configuration

By default, the API uses the endpoint provided by the [Unofficial VALORANT API](https://github.com/Henrik-3/unofficial-valorant-api). If you need to configure the base URL or any other settings, you can modify the `HttpProvider` class accordingly.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
