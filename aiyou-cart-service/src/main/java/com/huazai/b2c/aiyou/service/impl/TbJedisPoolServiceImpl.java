package com.huazai.b2c.aiyou.service.impl;

import javax.annotation.Resource;

import com.huazai.b2c.aiyou.service.TbJedisClientService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description Jedis单机版实现类
 *              </ul>
 * @className TJedisPoolServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月14日
 *
 * @version V1.0.0
 */
public class TbJedisPoolServiceImpl implements TbJedisClientService
{

	@Resource(name = "jedisPool")
	private JedisPool jedisPool;

	@Override
	public String set(String key, String value)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			String str = jedis.set(key, value);
			return str;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public String get(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			String str = jedis.get(key);
			return str;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public Boolean exists(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			Boolean result = jedis.exists(key);
			return result;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public Long expire(String key, int seconds)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			Long expire = jedis.expire(key, seconds);
			return expire;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public Long ttl(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			Long result = jedis.ttl(key);
			return result;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public Long incr(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			Long result = jedis.incr(key);
			return result;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public Long hset(String key, String field, String value)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			Long result = jedis.hset(key, field, value);
			return result;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public String hget(String key, String field)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			String result = jedis.hget(key, field);
			return result;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			jedis.close();
		}
		return null;
	}

	@Override
	public Long hdel(String key, String... field)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
