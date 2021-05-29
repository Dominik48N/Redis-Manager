package de.dominik48n.redis.manager

import redis.clients.jedis.Jedis

class DefaultRedisProvider : RedisProvider {

    lateinit var redisManager: RedisManager
    lateinit var jedis: Jedis

    /**
     * @return redisManager
     */
    override fun getManager(): RedisManager {
        return this.redisManager
    }

    /**
     * Initializes the necessary classes and establishes a connection to the redis server
     */
    override fun start(redisDatabase: RedisDatabase) {
        // Initializes the necessary classes
        this.initClasses(redisDatabase)

        // Establishes a connection to the redis server
        this.jedis.auth(redisDatabase.password)
        this.jedis.select(redisDatabase.databaseIndex)
        this.jedis.connect()
    }

    /**
     * Closes the connection to the redis server
     */
    override fun stop() {
        // Close the connection
        this.jedis.disconnect()
    }

    /**
     * Initializes the necessary classes
     */
    private fun initClasses(redisDatabase: RedisDatabase) {
        this.jedis = Jedis(redisDatabase.hostName, redisDatabase.port)
        this.redisManager = RedisManager(this.jedis)
    }
}
