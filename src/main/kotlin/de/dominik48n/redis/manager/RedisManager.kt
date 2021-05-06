package de.dominik48n.redis.manager

import redis.clients.jedis.Jedis

class RedisManager(val jedis: Jedis) {

    fun append(key: String, value: Any): Long {
        return this.jedis.append(key, value.toString())
    }

    fun remove(key: String): Long {
        return this.jedis.del(key)
    }

    fun exists(key: String): Boolean {
        return this.jedis.exists(key)
    }

    fun expire(key: String, seconds: Long): Long {
        return this.jedis.expire(key, seconds)
    }

}
