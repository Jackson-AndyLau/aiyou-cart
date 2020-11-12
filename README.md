# aiyou-cart
# B2C哎呦商城购物车后台服务系统

## 目录
- [前言](https://github.com/Jackson-AndyLau/aiyou-cart#%E5%89%8D%E8%A8%80)
- [一、项目总体架构](https://github.com/Jackson-AndyLau/aiyou-cart#%E4%B8%80%E9%A1%B9%E7%9B%AE%E6%80%BB%E4%BD%93%E6%9E%B6%E6%9E%84)
- [二、系统软硬件设施总体规划](https://github.com/Jackson-AndyLau/aiyou-cart#%E4%BA%8C%E7%B3%BB%E7%BB%9F%E8%BD%AF%E7%A1%AC%E4%BB%B6%E8%AE%BE%E6%96%BD%E6%80%BB%E4%BD%93%E8%A7%84%E5%88%92)
- [三、项目数据库创建](https://github.com/Jackson-AndyLau/aiyou-cart#%E4%B8%89%E9%A1%B9%E7%9B%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E5%88%9B%E5%BB%BA)
- [四、项目拉取](https://github.com/Jackson-AndyLau/aiyou-cart#%E5%9B%9B%E9%A1%B9%E7%9B%AE%E6%8B%89%E5%8F%96)
- [五、应用服务启动](https://github.com/Jackson-AndyLau/aiyou-cart#%E4%BA%94%E5%BA%94%E7%94%A8%E6%9C%8D%E5%8A%A1%E5%90%AF%E5%8A%A8)
- [六、B2C商城示例代码演示](https://github.com/Jackson-AndyLau/aiyou-cart#%E5%85%ADb2c%E5%95%86%E5%9F%8E%E7%A4%BA%E4%BE%8B%E4%BB%A3%E7%A0%81%E6%BC%94%E7%A4%BA)
- [七、项目效果图展示](https://github.com/Jackson-AndyLau/aiyou-cart#%E4%B8%83%E9%A1%B9%E7%9B%AE%E6%95%88%E6%9E%9C%E5%9B%BE%E5%B1%95%E7%A4%BA)
- [八、结束语](https://github.com/Jackson-AndyLau/aiyou-cart#%E5%85%AB%E7%BB%93%E6%9D%9F%E8%AF%AD)

## 前言
这个类似于电商的项目为什么说是B2C项目，是个人取的，何为电商，全称为电子商务，是指在互联网（Internet）、内部网（Intranet）和增值网（VAN，Value Added Network）上以电子交易方式进行交易活动和相关服务活动，是传统商业活动各环节的电子化、网络化。

当然，电商涵盖的范围很广，一般以三大电商模式为代表，即企业对企业（B2B/Business-to-Business）、企业对消费者（B2C/Business-to-Consumer）、消费者对消费者（C2C/Consumer-to-Consumer）。

随着国民经济网络化、社会生活信息化，国内互联网使用人数的爆发式增长，利用互联网进行网络购物消费，网上交易的方式已渐趋流行，所以，各种类型的电商网站也将层出不穷。迸发了包括：线上到线下（O2O/Online To Offline）、消费者对企业（C2B/Consumer-to-Business)、企业对市场营销（B2M/Business-to-Marketing）、生产厂家对消费者（M2C/Manufacturers-to-Consumer）、企业对行政机构（B2A/Business-to-Administration）、消费者对行政机构（C2A/Consumer-to-Administration）等电商模式。

本B2C商城，基于Java开发的高可用分布式B2C商城系统，技术架构：Java、JSP、CSS、JQuery、Spring MVC、Dubbo、Zookeeper、MySQL、Redis、FastDFS、Nginx、Solr。本项目的所有源码均已上传到GitHub开源，仅供学习交流，如果有什么问题欢迎留言讨论，如果有不足的地方，欢迎指正。

## 一、项目总体架构
![商城系统总体架构](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200701113619.png)

**本B2C商城通过三层架构实现，分别为：表现层、服务层、持久层；**

**表现层包括：后台管理系统、B2C商城门户网站系统、搜索系统、商品详情系统、单点登录系统、购物车系统、订单系统；**

**服务层包括：商品服务、内容服务、单点登录服务、购物车服务、订单服务、搜索服务、图片服务；**

**持久层包括：Redis 集群、MySQL 集群、Solr 集群、FastDFS 集群；**

## 二、系统软硬件设施总体规划
### 1、系统服务规划
|类目|名称 |	服务器数量|	虚拟机数量	|IP地址|端口号|
|:---:|:---:|:---:|:---:|:---:|:---:|
|MySQL|	RDBMS，关系型数据库|	2	|1	|192.168.159.128|	3306~3307|
|Redis	|NoSQL，非关系型数据库	|6	|1	|192.168.159.129	|6001~6006|
|FastDFS|	文件服务器|	2|	1	|192.168.159.130	|Tracker 22122-22123 <br>Storage 23000-23001<br>Http_Port 8888-8889|
|Nginx|	WEB服务器	|2	|1|	192.168.159.131|	80|
|ActiveMQ|	消息中间件	|2	|1|	192.168.159.132|	8161~8162|
|Zookeeper|	服务注册中心	|3|	1|	192.168.159.133|	2181~2183|
|Solr|	文档索引库	|6	|1	|192.168.159.134	|2001~2006|

### 2、应用服务规划
|应用名称|	说明|服务器数量	|虚拟数量|	IP地址	|端口号|
|:---:|:---:|:---:|:---:|:---:|:---:|
|aiyou-manager|	商品后台管理服务|	2|	1	|192.168.159.135	|8001~8002|
|aiyou-content	|内容后台管理服务	|2	|1	|192.168.159.136|	8001~8002|
|aiyou-search	|索引库内容搜索服务|	2	|1	|192.168.159.137	|8001~8002|
|aiyou-manager-web	|商城后台管理系统	|2	|1|	192.168.159.138|	8001~8002|
|aiyou-portal-web|	商城门户网站系统|	2|	1|	192.168.159.139	|8001~8002|
|aiyou-search-web|	内容搜索系统	|2	|1	|192.168.159.140	|8001~8002|
|aiyou-item-web|	商品详情系统	|2|	1	|192.168.159.141|	8001~8002|
|aiyou-sso	|单点登录后台服务	|2|	1	|192.168.159.142	|8001~8002|
|aiyou-sso-web	|单点系统	|2	|1	|192.168.159.143	|8001~8002|
|aiyou-cart	|购物车后台服务	|2	|1|	192.168.159.144	|8001~8002|
|aiyou-cart-web	|购物车系统|	2	|1	|192.168.159.145	|8001~8002|
|aiyou-order	|订单后台服务|	2	|1	|192.168.159.146	|8001~8002|
vaiyou-order-web|	订单系统	|2|	1	|192.168.159.147|	8001~8002|

### 3、域名地址规划
|系统名称	|说明	|一级域名|	二级域名|
|:---:|:---:|:---:|:---:|
|aiyou-manager-web	|商城后台管理系统	|aiyou.cn|	manager.aiyou.cn|
|aiyou-portal-web	|商城门户网站系统|	aiyou.cn|	portal.aiyou.cn|
|aiyou-search-web|	内容搜索系统	|aiyou.cn|	search.aiyou.cn|
|aiyou-item-web|	商品详情系统|	aiyou.cn	|item.aiyou.cn|
|aiyou-sso-web|	单点系统	|aiyou.cn|	passport.aiyou.cn|
|aiyou-cart-web|	购物车系统|	aiyou.cn	|cart.aiyou.cn|
|aiyou-order-web|	订单系统	|aiyou.cn	|order.aiyou.cn|

## 三、项目数据库创建
**>从aiyou_common项目中拿sql进行导入到已创建的b2c_aiyou数据库中（如果不存在，则自行创建一个）**

**文件路径：aiyou-common\src\main\resources\sql\b2c_aiyou.sql**

## 四、项目拉取

### 1、aiyou-parent

项目地址：《 [GitHub aiyou-parent 项目地址](https://github.com/Jackson-AndyLau/aiyou-parent) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-parent.git

 

### 2、aiyou-common

项目地址：《 [GitHub aiyou-common 项目地址](https://github.com/Jackson-AndyLau/aiyou-common) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-common.git

 

### 3、aiyou-manager

项目地址：《 [GitHub aiyou-manager 项目地址](https://github.com/Jackson-AndyLau/aiyou-manager) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-manager.git

 

### 4、aiyou-content

项目地址：《 [GitHub aiyou-content 项目地址](https://github.com/Jackson-AndyLau/aiyou-content) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-content.git

 

### 5、aiyou-manager-web

项目地址：《 [GitHub aiyou-manager-web 项目地址](https://github.com/Jackson-AndyLau/aiyou-manager-web) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-manager-web.git

 

### 6、aiyou-portal-web

项目地址：《 [GitHub aiyou-portal-web 项目地址](https://github.com/Jackson-AndyLau/aiyou-portal-web) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-portal-web.git

 

### 7、aiyou-search

项目地址：《 [GitHub aiyou-search 项目地址](https://github.com/Jackson-AndyLau/aiyou-search) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-search.git

 

### 8、aiyou-search-web

项目地址：《 [GitHub aiyou-search-web 项目地址](https://github.com/Jackson-AndyLau/aiyou-search-web) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-search-web.git

 

### 9、aiyou-item-web

项目地址：《 [GitHub aiyou-item-web 项目地址](https://github.com/Jackson-AndyLau/aiyou-item-web) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-item-web.git

 

### 10、aiyou-sso

项目地址：《 [GitHub aiyou-sso 项目地址](https://github.com/Jackson-AndyLau/aiyou-sso) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-sso.git

 

### 11、aiyou-sso-web

项目地址：《 [GitHub aiyou-sso-web 项目地址](https://github.com/Jackson-AndyLau/aiyou-sso-web) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-sso-web.git

 

### 12、aiyou-cart

项目地址：《 [GitHub aiyou-cart 项目地址](https://github.com/Jackson-AndyLau/aiyou-cart) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-cart.git

 

### 13、aiyou-cart-web

项目地址：《 [GitHub aiyou-cart-web 项目地址](https://github.com/Jackson-AndyLau/aiyou-cart-web) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-cart-web.git

 

### 14、aiyou-order

项目地址：《 [GitHub aiyou-order 项目地址](https://github.com/Jackson-AndyLau/aiyou-order) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-order.git

 

### 15、aiyou-order-web

项目地址：《 [GitHub aiyou-order-web 项目地址](https://github.com/Jackson-AndyLau/aiyou-order-web) 》<br>
项目拉取地址：https://github.com/Jackson-AndyLau/aiyou-order-web.git


项目拉取完成后，工程目录如下图：
![项目结构图片](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200820153005.png)


![项目结构图片](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200820154105.png)


## 五、应用服务启动

### 1、首先需要启动后台服务
1、aiyou-manager <br>
2、aiyou-content<br>
3、aiyou-search<br>
4、aiyou-sso<br>
5、aiyou-cart<br>
6、aiyou-order<br>

### 2、再启动前端WEB服务
1、aiyou-manager-web<br>
2、aiyou-portal-web<br>
3、aiyou-search-web<br>
4、aiyou-item-web<br>
5、aiyou-sso-web<br>
6、aiyou-cart-web<br>
7、aiyou-order-web<br>

## 六、B2C商城示例代码演示
本项目所有代码均按照统一规范编写，严格遵循MVC三层架构设计模式实现，风格统一，代码整洁、美观、大方，重要的一点，注释多多，关键节点都有注释注明，方便阅读代码，示例代码如下：

### Controller 控制层：

```Java
package com.huazai.aiyou.manager.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.manager.pojo.TbItem;
import com.huazai.aiyou.manager.service.TbItemDescService;
import com.huazai.aiyou.manager.service.TbItemService;
 
/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品信息controller层
 *              </ul>
 * @className TbItemController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
@Controller
@RequestMapping(value = "/item")
public class TbItemController
{
 
	@Autowired
	private TbItemService tbItemService;
 
	@Autowired
	private TbItemDescService tbItemDescService;
 
	@Description(value = "获取商品列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGrid getItemList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "row", defaultValue = "30") Integer rows)
	{
		EasyUIDataGrid easyUIDataGrid = tbItemService.getTbItemList(page, rows, null);
		return easyUIDataGrid;
	}
 
	@Description(value = "添加商品")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData addTbItem(TbItem item, String desc)
	{
		AiyouResultData resultData = tbItemService.addTbItem(item, desc);
		return resultData;
	}
 
	@Description(value = "删除商品")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData deleteTbItem(String ids)
	{
		AiyouResultData resultData = tbItemService.deleteTbItem(ids);
		return resultData;
	}
 
	@Description(value = "下架商品")
	@RequestMapping(value = "/instock", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData instockTbItem(String ids)
	{
		AiyouResultData resultData = tbItemService.instockTbItem(ids);
		return resultData;
	}
 
	@Description(value = "上架商品")
	@RequestMapping(value = "/reshelf", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData reshelfTbItem(String ids)
	{
		AiyouResultData resultData = tbItemService.reshelfTbItem(ids);
		return resultData;
	}
 
	@Description(value = "查询商品参数")
	@RequestMapping(value = "/param/item/query/{itemId}")
	@ResponseBody
	public AiyouResultData queryTbItemParam(@PathVariable(value = "itemId") Long itemId)
	{
		AiyouResultData resultData = tbItemService.findTbItemById(itemId);
		return resultData;
	}
 
	@Description(value = "查询商品描述信息")
	@RequestMapping(value = "/query/item/desc/{itemId}")
	@ResponseBody
	private AiyouResultData queryTbItemDesc(@PathVariable(value = "itemId") Long itemId)
	{
		AiyouResultData resultData = tbItemDescService.findTbItemDescById(itemId);
		return resultData;
	}
 
	@Description(value = "修改商品信息")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData updateTbItem(TbItem tbItem, String desc)
	{
		AiyouResultData resultData = tbItemService.updateTbItem(tbItem, desc);
		return resultData;
	}
 
}
```

### Service 接口层：
```Java
package com.huazai.aiyou.manager.service;
 
import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.manager.pojo.TbItemDesc;
 
/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品描述接口
 *              </ul>
 * @className TbItemDescService
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemDescService {
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getItemDescList
	 *        <ul>
	 * @description 获取商品描述列表
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param pageNum    当前页码
	 * @param pageSize   页大小
	 * @param tbItemDesc 查询条件
	 * @return EasyUIDataGrid 数据列表
	 *
	 * @version : V1.0.0
	 */
	public EasyUIDataGrid getItemDescList(Integer pageNum, Integer pageSize, TbItemDesc tbItemDesc);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title findTbItemDescById
	 *        <ul>
	 * @description 根据商品ID获取商品描述
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param itemId 商品ID
	 * @return AiyouResultData 商品数据
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData findTbItemDescById(long itemId);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title geTbItemDescById
	 *        <ul>
	 * @description 通过商品Id,获取商品描述
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param itemId 商品ID
	 * @return TbItemDesc 商品描述
	 *
	 * @version : V1.0.0
	 */
	public TbItemDesc geTbItemDescById(Long itemId);
}
```

```Java
package com.huazai.aiyou.manager.service;
 
import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.manager.pojo.TbItem;
 
/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品接口类
 *              </ul>
 * @className ItemService
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemService {
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getItemList
	 *        <ul>
	 * @description 获取商品列表
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param pageNum  当前页码
	 * @param pageSize 页大小
	 * @param item     查询条件
	 * @return EasyUIDataGrid 返回数据载体
	 *
	 * @version : V1.0.0
	 */
	public EasyUIDataGrid getTbItemList(Integer pageNum, Integer pageSize, TbItem item);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title saveTbItem
	 *        <ul>
	 * @description 添加商品
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param item 商品实体
	 * @param desc 商品描述
	 * @return AiyouResultData 相应数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData addTbItem(TbItem item, String itemDesc);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title deleteTbItem
	 *        <ul>
	 * @description 删除商品信息
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param ids 商品ID集合
	 * @return AiyouResultData 数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData deleteTbItem(String ids);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title instockTbItem
	 *        <ul>
	 * @description 下架商品
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param ids 商品ID集合
	 * @return AiyouResultData 数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData instockTbItem(String ids);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title reshelfTbItem
	 *        <ul>
	 * @description 上架商品
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param ids 商品ID集合
	 * @return AiyouResultData 数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData reshelfTbItem(String ids);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title findTbItemById
	 *        <ul>
	 * @description 根据商品ID获取商品信息
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param itemId 商品ID
	 * @return AiyouResultData 数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData findTbItemById(Long itemId);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title updateTbItem
	 *        <ul>
	 * @description 修改商品信息
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param item 商品信息实体
	 * @param desc 商品描述
	 * @return AiyouResultData 数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData updateTbItem(TbItem item, String desc);
 
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getTbItemById
	 *        <ul>
	 * @description 根据商品Id，查询商品详情
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param itemId 商品ID
	 * @return TbItem 商品信息
	 *
	 * @version : V1.0.0
	 */
	public TbItem getTbItemById(Long itemId);
 
}
```

### Service 实现层：
```Java
package com.huazai.aiyou.manager.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
 
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.common.utils.JsonUtils;
import com.huazai.aiyou.manager.mapper.TbItemDescMapper;
import com.huazai.aiyou.manager.pojo.TbItemDesc;
import com.huazai.aiyou.manager.pojo.TbItemDescExample;
import com.huazai.aiyou.manager.pojo.TbItemDescExample.Criteria;
import com.huazai.aiyou.manager.service.TbItemDescService;
import com.huazai.aiyou.manager.service.TbJedisClientService;
 
/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品描述实现类
 *              </ul>
 * @className TbItemDescServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
@Service
public class TbItemDescServiceImpl implements TbItemDescService
{
 
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
 
	@Autowired
	private TbJedisClientService tbJedisClientService;
 
	@Value("${AIYOU_TB_SERVICE_ITEM_INFO_KEY}")
	private String AIYOU_TB_SERVICE_ITEM_INFO_KEY;
 
	@Value("${AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE}")
	private Integer AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE;
 
	@Override
	public EasyUIDataGrid getItemDescList(Integer pageNum, Integer pageSize, TbItemDesc tbItemDesc)
	{
        // TODO
 
		return null;
	}
 
	@Override
	public AiyouResultData findTbItemDescById(long itemId)
	{
		TbItemDesc itemDesc = null;
		try
		{
			// 查询商品信息
			TbItemDescExample example = new TbItemDescExample();
			Criteria criteria = example.createCriteria();
			criteria.andItemIdEqualTo(itemId);
			List<TbItemDesc> list = tbItemDescMapper.selectByExampleWithBLOBs(example);
			if(CollectionUtils.isNotEmpty(list))
            {
				itemDesc = list.get(0);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品描述查询异常");
		}
		return AiyouResultData.ok(itemDesc);
	}
 
	@Override
	public TbItemDesc geTbItemDescById(Long itemId)
	{
		try
		{
			// 从缓存中获取数据
			if (itemId != null)
			{
				// 获取数据
				String str = tbJedisClientService.get(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE");
				if (!StringUtils.isEmpty(str))
				{
					// 重置数据的有效时间
					tbJedisClientService.expire(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
							AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE);
					// 解析数据并返回
					TbItemDesc tbItemDesc = JsonUtils.jsonToPojo(str, TbItemDesc.class);
					return tbItemDesc;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);
		try
		{
			// 新增缓存
			tbJedisClientService.set(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
					JsonUtils.objectToJson(tbItemDesc));
			// 设置过期时间
			tbJedisClientService.expire(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
					AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return tbItemDesc;
	}
 
}
```

```Java
package com.huazai.aiyou.manager.service.impl;
 
import java.util.Date;
import java.util.List;
 
import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazai.aiyou.common.constant.TbConstant;
import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.common.utils.IDUtils;
import com.huazai.aiyou.common.utils.JsonUtils;
import com.huazai.aiyou.manager.mapper.TbItemDescMapper;
import com.huazai.aiyou.manager.mapper.TbItemMapper;
import com.huazai.aiyou.manager.pojo.TbItem;
import com.huazai.aiyou.manager.pojo.TbItemDesc;
import com.huazai.aiyou.manager.pojo.TbItemExample;
import com.huazai.aiyou.manager.pojo.TbItemExample.Criteria;
import com.huazai.aiyou.manager.service.TbItemService;
import com.huazai.aiyou.manager.service.TbJedisClientService;
 
/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品实现类
 *              </ul>
 * @className TbItemServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
@Service
public class TbItemServiceImpl implements TbItemService
{
	@Autowired
	private TbItemMapper tbItemMapper;
 
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
 
	@Autowired
	private JmsTemplate jmsTemplate;
 
	@Autowired
	private TbJedisClientService tbJedisClientService;
 
	@Resource(name = "itemTopicDestination")
	private Destination itemTopicDestination;
 
	@Value("${AIYOU_TB_SERVICE_ITEM_INFO_KEY}")
	private String AIYOU_TB_SERVICE_ITEM_INFO_KEY;
 
	@Value("${AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE}")
	private Integer AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE;
 
	@Override
	public EasyUIDataGrid getTbItemList(Integer pageNum, Integer pageSize, TbItem item)
	{
		// 初始化数据载体
		EasyUIDataGrid resultData = new EasyUIDataGrid();
		try
		{
			// 通过PageHelper设置分页信息
			PageHelper.startPage(pageNum, pageSize);
			// 设置查询条件获得查询结果
			TbItemExample example = new TbItemExample();
			Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(item) && item.getCid() != null)
				criteria.andCidEqualTo(item.getCid());
			criteria.andStatusNotEqualTo(Byte.valueOf("3"));
			List<TbItem> list = tbItemMapper.selectByExample(example);
			// 获取分页信息
			PageInfo<TbItem> pageInfo = new PageInfo<>(list);
			// 封装数据
			resultData.setRows(list);
			resultData.setTotal(pageInfo.getTotal());
			resultData.setPageSize(pageInfo.getPageSize());
			resultData.setPageNum(pageInfo.getPageNum());
			resultData.setPages(pageInfo.getPages());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultData;
	}
 
	@Transactional
	@Override
	public AiyouResultData addTbItem(TbItem item, String itemDesc)
	{
		// 获取生成商品ID
		final long itemId = IDUtils.genItemId();
		// 初始化系统时间
		Date date = new Date();
		// 补全商品信息
		item.setId(itemId);
		item.setStatus(TbConstant.TB_ITEM_STATUS_RESHELF);
		item.setCreated(date);
		item.setUpdated(date);
		// 初始化 TbItemDesc 对象
		TbItemDesc tbItemDesc = new TbItemDesc();
		// 补全商品描述信息
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setItemDesc(itemDesc);
		tbItemDesc.setCreated(date);
		tbItemDesc.setUpdated(date);
		try
		{
			// 添加商品数据
			tbItemMapper.insertSelective(item);
			// 添加商品描述
			tbItemDescMapper.insertSelective(tbItemDesc);
			// 同步更新索引库
			jmsTemplate.send(itemTopicDestination, new MessageCreator()
			{
				@Override
				public Message createMessage(Session session) throws JMSException
				{
					TextMessage textMessage = session.createTextMessage(String.valueOf(String.valueOf(itemId)));
					return textMessage;
				}
			});
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "添加商品失败");
		}
		return AiyouResultData.ok();
	}
 
	@Transactional
	private void optByTbItemId(String ids, Byte status) throws Exception
	{
		String[] idStrings = ids.split(",");
		for (int i = 0; i < idStrings.length; i++)
		{
			// 在一般的实际应用中，都是进行的是逻辑操作
			TbItem tbItem = tbItemMapper.selectByPrimaryKey(Long.valueOf(idStrings[i]));
			tbItem.setStatus(status);
			tbItemMapper.updateByPrimaryKey(tbItem);
			// 同步更新索引库
            // TODO
		}
	}
 
	@Transactional
	@Override
	public AiyouResultData deleteTbItem(String ids)
	{
		try
		{
			optByTbItemId(ids, TbConstant.TB_ITEM_STATUS_DELETE);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品删除异常");
		}
		return AiyouResultData.ok();
	}
 
	@Override
	public AiyouResultData instockTbItem(String ids)
	{
		try
		{
			optByTbItemId(ids, TbConstant.TB_ITEM_STATUS_INSTOCK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品下架异常");
		}
		return AiyouResultData.ok();
	}
 
	@Override
	public AiyouResultData reshelfTbItem(String ids)
	{
		try
		{
			optByTbItemId(ids, TbConstant.TB_ITEM_STATUS_RESHELF);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品上架异常");
		}
		return AiyouResultData.ok();
	}
 
	@Override
	public AiyouResultData findTbItemById(Long itemId)
	{
		TbItem tbItem;
		try
		{
			tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品信息查询异常");
		}
		return AiyouResultData.ok(tbItem);
	}
 
	@Transactional
	@Override
	public AiyouResultData updateTbItem(TbItem item, String desc)
	{
		try
		{
			// 修改商品信息
			TbItem tbItem = tbItemMapper.selectByPrimaryKey(item.getId());
			// 补全信息
			Date date = new Date();
			tbItem.setCid(item.getCid());
			tbItem.setTitle(item.getTitle());
			tbItem.setSellPoint(item.getSellPoint());
			tbItem.setPrice(item.getPrice());
			tbItem.setNum(item.getNum());
			tbItem.setBarcode(item.getBarcode());
			tbItem.setImage(item.getImage());
			tbItem.setUpdated(date);
			tbItemMapper.updateByPrimaryKey(tbItem);
			// 修改商品描述
			TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(item.getId());
			// 补全信息
			tbItemDesc.setItemDesc(desc);
			tbItemDesc.setUpdated(date);
			tbItemDescMapper.updateByPrimaryKeyWithBLOBs(tbItemDesc);
			// 同步更新索引库
            // TODO
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "修改商品信息异常");
		}
		return AiyouResultData.ok();
	}
 
	@Override
	public TbItem getTbItemById(Long itemId)
	{
		try
		{
			// 从缓存中获取数据
			if (itemId != null)
			{
				// 获取数据
				String str = tbJedisClientService.get(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE");
				if (!StringUtils.isEmpty(str))
				{
					// 重置数据的有效时间
					tbJedisClientService.expire(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
							AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE);
					// 解析数据并返回
					TbItem tbItemCache = JsonUtils.jsonToPojo(str, TbItem.class);
					return tbItemCache;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// 从数据库中获取数据
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		try
		{
			// 新增缓存
			tbJedisClientService.set(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
					JsonUtils.objectToJson(tbItem));
			// 设置过期时间
			tbJedisClientService.expire(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
					AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return tbItem;
	}
 
}
```

补充说明：

本项目中关于键的定义规范说明，举例：

AIYOU_TB_SERVICE_ITEM_INFO_KEY

主题：AIYOU

前缀：TB

服务端/本地：SERVICE/LOCAL

键的具体表示内容/作用：ITEM_INFO_KEY

更多规范：参考 《 [Java 工程师开发规范，我看行！](https://download.csdn.net/download/Hello_World_QWP/12618365) 》

## 七、项目效果图展示

### 1、商城后台管理界面效果展示

后台管理系统-菜单栏展示

![后台管理系统-菜单栏展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826103538.png)

后台管理系统-新增商品

![后台管理系统-新增商品](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826152433.png)

后台管理系统-商品管理界面展示

![后台管理系统-商品管理界面展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826103857.png)

后台管理系统-内容分类管理界面展示

![后台管理系统-内容分类管理界面展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826104144.png)

后台管理系统-内容管理界面展示

![后台管理系统-内容管理界面展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826110616.png)

后台管理系统-新增内容界面展示

![后台管理系统-新增内容界面展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826111234.png)

### 2、商城门户网站界面效果展示

门户网站-商城首页展示

![门户网站-商城首页展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826143452.png)

门户网站-商品搜索页展示

![门户网站-商品搜索页展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826144933.png)

门户网站-商品详情页面展示

![门户网站-商品详情页面展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826145444.png)

门户网站-登录页面展示

![门户网站-登录页面展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826150715.png)

门户网站-注册页面展示

![门户网站-注册页面展示](https://raw.githubusercontent.com/Jackson-AndyLau/pictures-storage/master/002/202011/20200826151159.png)

## 八、结束语
**技术在不断的进步，要想走技术的这条道路，站稳脚跟，就要保持持续的学习态度，好好学习，天天向上。**

**————不积跬步，无以至千里；不积小流，无以成江海。**
<br>
<br>
<br>
**《 [CSDN -> B2C商城项目源码说明，基于Java开发的高可用分布式B2C商城系统](https://blog.csdn.net/Hello_World_QWP/article/details/106919419) 》**

[>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>回到顶部<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<](https://github.com/Jackson-AndyLau/aiyou-cart#aiyou-cart)

