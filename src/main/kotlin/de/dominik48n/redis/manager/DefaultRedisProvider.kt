package de.dominik48n.redis.manager

import redis.clients.jedis.Jedis

class DefaultRedisProvider : RedisProvider {

    lateinit var redisManager: RedisManager
    lateinit var jedis: Jedis

    override fun getManager(): RedisManager {
        return this.redisManager
    }

    override fun start(redisDatabase: RedisDatabase) {
        this.initClasses(redisDatabase)

        this.jedis.auth(redisDatabase.password)
        this.jedis.select(redisDatabase.databaseIndex)
        this.jedis.connect()
    }

    override fun stop() {
        this.jedis.disconnect()
    }

    private fun initClasses(redisDatabase: RedisDatabase) {
        this.jedis = Jedis(redisDatabase.hostName, redisDatabase.port)
        this.redisManager = RedisManager(this.jedis)
    }
}
