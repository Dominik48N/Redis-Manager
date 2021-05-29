package de.dominik48n.redis.manager

import redis.clients.jedis.Jedis

class RedisManager(private val jedis: Jedis) {

    /**
     * Inserts a new entry in redis
     */
    fun append(key: String, value: Any): Long {
        return this.jedis.append(key, value.toString())
    }

    /**
     * Removes an existing entry
     */
    fun remove(key: String): Long {
        return this.jedis.del(key)
    }

    /**
     * Checks whether an entry exists
     *
     * @return true, when an value was founded
     */
    fun exists(key: String): Boolean {
        return this.jedis.exists(key)
    }

    /**
     * Removes an entry after the specified number of seconds
     */
    fun expire(key: String, seconds: Long): Long {
        return this.jedis.expire(key, seconds)
    }

}
