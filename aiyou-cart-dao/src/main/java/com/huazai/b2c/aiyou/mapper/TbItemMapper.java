package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbItem;
import com.huazai.b2c.aiyou.pojo.TbItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * 			@description TODO
 *          </ul>
 * @className TbItemMapper
 * @package com.huazai.b2c.aiyou.mapper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemMapper
{
	int countByExample(TbItemExample example);

	int deleteByExample(TbItemExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbItem record);

	int insertSelective(TbItem record);

	List<TbItem> selectByExample(TbItemExample example);

	TbItem selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

	int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

	int updateByPrimaryKeySelective(TbItem record);

	int updateByPrimaryKey(TbItem record);
}