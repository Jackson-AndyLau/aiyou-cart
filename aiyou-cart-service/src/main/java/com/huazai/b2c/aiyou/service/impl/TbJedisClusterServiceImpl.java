package com.huazai.b2c.aiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.huazai.b2c.aiyou.service.TbJedisClientService;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description Jedis集群版实现类
 *              </ul>
 * @className TJedisClusterServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月14日
 *
 * @version V1.0.0
 */
public class TbJedisClusterServiceImpl implements TbJedisClientService
{

	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String set(String key, String value)
	{
		String result = jedisCluster.set(key, value);
		return result;
	}

	@Override
	public String get(String key)
	{
		String result = jedisCluster.get(key);
		return result;
	}

	@Override
	public Boolean exists(String key)
	{
		Boolean result = jedisCluster.exists(key);
		return result;
	}

	@Override
	public Long expire(String key, int seconds)
	{
		Long result = jedisCluster.expire(key, seconds);
		return result;
	}

	@Override
	public Long ttl(String key)
	{
		Long result = jedisCluster.ttl(key);
		return result;
	}

	@Override
	public Long incr(String key)
	{
		Long result = jedisCluster.incr(key);
		return result;
	}

	@Override
	public Long hset(String key, String field, String value)
	{
		Long result = jedisCluster.hset(key, field, value);
		return result;
	}

	@Override
	public String hget(String key, String field)
	{
		String result = jedisCluster.hget(key, field);
		return result;
	}

	@Override
	public Long hdel(String key, String... field)
	{
		Long result = jedisCluster.hdel(key, field);
		return result;
	}

}
