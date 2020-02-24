package com.huazai.b2c.aiyou.service;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 操作Redis服务的TJedisClientServer接口类
 *              </ul>
 * @className TJedisClientServer
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月14日
 *
 * @version V1.0.0
 */
public interface TbJedisClientService
{

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title set
	 *        <ul>
	 * @description 根据Key，添加String的value值
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @param value
	 * @return
	 * @return String
	 *
	 * @version : V1.0.0
	 */
	String set(String key, String value);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title get
	 *        <ul>
	 * @description 根据key获取对应的value
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @return
	 * @return String
	 *
	 * @version : V1.0.0
	 */
	String get(String key);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title exists
	 *        <ul>
	 * @description 获取某个key是否存在
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @return
	 * @return Boolean
	 *
	 * @version : V1.0.0
	 */
	Boolean exists(String key);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title expire
	 *        <ul>
	 * @description 设置key的过期时间
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @param seconds
	 * @return
	 * @return Long
	 *
	 * @version : V1.0.0
	 */
	Long expire(String key, int seconds);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title ttl
	 *        <ul>
	 * @description 获取key的当前存活时间
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @return
	 * @return Long
	 *
	 * @version : V1.0.0
	 */
	Long ttl(String key);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title incr
	 *        <ul>
	 * @description 获取增量值
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @return
	 * @return Long
	 *
	 * @version : V1.0.0
	 */
	Long incr(String key);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title hset
	 *        <ul>
	 * @description 添加hash类型的值
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @return Long
	 *
	 * @version : V1.0.0
	 */
	Long hset(String key, String field, String value);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title hget
	 *        <ul>
	 * @description 获取hash类型的值
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @param field
	 * @return
	 * @return String
	 *
	 * @version : V1.0.0
	 */
	String hget(String key, String field);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title hdel
	 *        <ul>
	 * @description 删除hash的值
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @param key
	 * @param field
	 * @return
	 * @return Long
	 *
	 * @version : V1.0.0
	 */
	Long hdel(String key, String... field);
}
