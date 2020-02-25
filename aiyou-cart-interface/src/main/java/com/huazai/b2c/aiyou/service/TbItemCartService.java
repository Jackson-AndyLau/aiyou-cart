package com.huazai.b2c.aiyou.service;

import java.util.List;

import com.huazai.b2c.aiyou.repo.AiyouResultData;
import com.huazai.b2c.aiyou.vo.TbItemCartVO;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品详情Controller
 *              </ul>
 * @className TbItemCartService
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月18日
 *
 * @version V1.0.0
 */
public interface TbItemCartService
{

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title addTbItemCart
	 *        <ul>
	 * @description 添加商品购物车
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param userId 用户ID
	 * @param tbItem 商品实体
	 * @param num    商品数量
	 * @return
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData addTbItemCart(Long userId, TbItemCartVO tbItemVO, Integer num);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title queryTbItemByUserIdAndItemId
	 *        <ul>
	 * @description 根据用户Id查询购物车商品信息
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param userId 用户 ID
	 * @return
	 * @return TbItemCartVO
	 *
	 * @version : V1.0.0
	 */
	public List<TbItemCartVO> queryTbItemByUserId(Long userId);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title updateTbItemByUserIdAndItemId
	 *        <ul>
	 * @description 根据用户Id和商品Id修改购物商品数量
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param userId 用户Id
	 * @param itemId 商品Id
	 * @param num 商品数量
	 * @return
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData updateTbItemByUserIdAndItemId(Long userId, Long itemId, Integer num);
}
