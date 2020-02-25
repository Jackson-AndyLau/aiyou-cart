package com.huazai.b2c.aiyou.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.huazai.b2c.aiyou.repo.AiyouResultData;
import com.huazai.b2c.aiyou.service.TbItemCartService;
import com.huazai.b2c.aiyou.service.TbJedisClientService;
import com.huazai.b2c.aiyou.utils.JsonUtils;
import com.huazai.b2c.aiyou.vo.TbItemCartVO;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className TbItemCartServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月18日
 *
 * @version V1.0.0
 */
@Service
public class TbItemCartServiceImpl implements TbItemCartService
{

	@Autowired
	private TbJedisClientService tbJedisClientService;

	@Value(value = "${TB_ITEM_CART_PREFIX_KEY}")
	private String TB_ITEM_CART_PREFIX_KEY;

	@Override
	public AiyouResultData addTbItemCart(Long userId, TbItemCartVO tbItemVO, Integer num)
	{
		// 判断当前添加的商品是否已存在
		TbItemCartVO resulTbItemCartVO = this.queryTbItemByUserIdAndItemId(userId, tbItemVO.getId());
		if (StringUtils.isEmpty(resulTbItemCartVO))
		{
			// 如果商品不存在，则添加购物车
			String image = tbItemVO.getImage();
			tbItemVO.setImage(image.split(",")[0]);
			tbItemVO.setNum(num);
			tbJedisClientService.hset(TB_ITEM_CART_PREFIX_KEY + ":" + userId, String.valueOf(tbItemVO.getId()),
					JsonUtils.objectToJson(tbItemVO));
		} else
		{
			// 如果商品存在，则直接新增商品数量
			tbItemVO.setNum(resulTbItemCartVO.getNum() + num);
			tbJedisClientService.hset(TB_ITEM_CART_PREFIX_KEY + ":" + userId, String.valueOf(tbItemVO.getId()),
					JsonUtils.objectToJson(resulTbItemCartVO));
		}
		return AiyouResultData.ok();
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title queryTbItemByUserIdAndItemId
	 *        <ul>
	 * @description 根据用户用户Id和商品Id获取商品信息
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param userId 用户Id
	 * @param itemId 商品Id
	 * @return
	 * @return TbItemCartVO
	 *
	 * @version : V1.0.0
	 */
	private TbItemCartVO queryTbItemByUserIdAndItemId(Long userId, Long itemId)
	{
		// 查询用户商品信息
		String resultData = tbJedisClientService.hget(TB_ITEM_CART_PREFIX_KEY + ":" + userId, String.valueOf(itemId));
		if (!StringUtils.isEmpty(resultData))
		{
			// 转换商品视图对象
			TbItemCartVO tbItemCartVO = JsonUtils.jsonToPojo(resultData, TbItemCartVO.class);
			return tbItemCartVO;
		} else
		{
			return null;
		}
	}

	@Override
	public List<TbItemCartVO> queryTbItemByUserIdAndItemId(Long userId)
	{
		// 查询用户购物车商品
		Map<String, String> resultMap = tbJedisClientService.hgetAll(TB_ITEM_CART_PREFIX_KEY + ":" + userId);
		Set<Entry<String, String>> resultSet = resultMap.entrySet();
		if (!CollectionUtils.isEmpty(resultSet))
		{
			// 转换购物车商品集合
			List<TbItemCartVO> tbItemCartVOs = new ArrayList<TbItemCartVO>();
			for (Entry<String, String> entry : resultSet)
			{
				TbItemCartVO tbItemCartVO = JsonUtils.jsonToPojo(entry.getValue(), TbItemCartVO.class);
				tbItemCartVOs.add(tbItemCartVO);
			}
			return tbItemCartVOs;
		}
		return null;
	}

}
