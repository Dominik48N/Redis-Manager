package de.dominik48n.redis.manager

import redis.clients.jedis.Jedis

class DefaultRedisProvider : RedisProvider {

    lateinit var jedis: Jedis

    override fun start(redisDatabase: RedisDatabase) {
        this.initClasses(redisDatabase)
    }

    override fun stop() {
        this.jedis.disconnect()
    }

    private fun initClasses(redisDatabase: RedisDatabase) {
        this.jedis = Jedis(redisDatabase.hostName, redisDatabase.port)
    }
}
