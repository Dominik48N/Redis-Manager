package de.dominik48n.redis.manager

interface RedisProvider {

    /**
     * @return RedisManager
     */
    fun getManager(): RedisManager

    /**
     * Starts the redis provider
     */
    fun start(redisDatabase: RedisDatabase)

    /**
     * Stops the redis provider
     */
    fun stop()

}
