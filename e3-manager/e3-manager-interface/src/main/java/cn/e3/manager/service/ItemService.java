package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

public interface ItemService {
	
	/**
	 * 需求:根据id查询商品信息
	 * 参数:Long itemId
	 * 返回值:Tbitem
	 * 方法:findItemByID
	 */
	public TbItem findItemByID(Long itemId);
	
	/**
	 * 需求:分页查询 商品信息
	 * 参数:Integer page,Integer rows
	 * 返回值:DatagridPageBean
	 * 方法:findItemList
	 */
	public DatagridPageBean findItemList(Integer page,Integer rows);
	
	/**
	 * 添加商品
	 * @param page
	 * @param rows
	 * @return
	 */
	public E3mallResult addItem(TbItem item,TbItemDesc desc);

}
