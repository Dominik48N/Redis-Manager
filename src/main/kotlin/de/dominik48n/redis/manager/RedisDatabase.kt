package de.dominik48n.redis.manager

data class RedisDatabase(
    val hostName: String, // The host name or ip address of the redis server
    val port: Int, // The port of the redis server
    val password: String, // The password of the redis server
    val databaseIndex: Int // The id of the database to be selected
)
