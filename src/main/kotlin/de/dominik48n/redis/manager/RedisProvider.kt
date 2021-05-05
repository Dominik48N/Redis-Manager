package de.dominik48n.redis.manager

interface RedisProvider {

    fun start(redisDatabase: RedisDatabase)

    fun stop()

}
