package de.dominik48n.redis.manager

interface RedisProvider {

    fun getManager(): RedisManager

    fun start(redisDatabase: RedisDatabase)

    fun stop()

}
