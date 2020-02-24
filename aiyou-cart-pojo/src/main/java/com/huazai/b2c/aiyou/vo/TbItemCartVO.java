package com.huazai.b2c.aiyou.vo;

import java.io.Serializable;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 购物车商品视图对象
 *              </ul>
 * @className TbItemCartVO
 * @package com.huazai.b2c.aiyou.vo
 * @createdTime 2017年06月18日
 *
 * @version V1.0.0
 */
public class TbItemCartVO implements Serializable
{
	/**
	 * @Files serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private Long price;

	private Integer num;

	private String image;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title == null ? null : title.trim();
	}

	public Long getPrice()
	{
		return price;
	}

	public void setPrice(Long price)
	{
		this.price = price;
	}

	public Integer getNum()
	{
		return num;
	}

	public void setNum(Integer num)
	{
		this.num = num;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image == null ? null : image.trim();
	}

}
