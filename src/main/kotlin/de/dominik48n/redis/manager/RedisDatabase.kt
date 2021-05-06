package de.dominik48n.redis.manager

data class RedisDatabase(
    val hostName: String,
    val port: Int,
    val password: String,
    val databaseIndex: Int)
