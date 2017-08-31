package cn.e3.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemDescMapper;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.IDUtils;
@Service
public class ItemServiceImpl implements ItemService {
	
	//注入商品Mapper接口代理对象
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	/**
	 * 需求:根据id查询商品信息
	 * 参数:Long itemId
	 * 返回值:Tbitem
	 * 方法:findItemByID
	 */
	public TbItem findItemByID(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

	/**
	 * 需求:分页查询 商品信息
	 * 参数:Integer page,Integer rows
	 * 返回值:DatagridPageBean
	 * 方法:findItemList
	 * 业务:使用PageHelper分页查询进行分页
	 */
	@Override
	public DatagridPageBean findItemList(Integer page, Integer rows) {
		TbItemExample example=new TbItemExample();//查询所有
		PageHelper.startPage(page,rows);//设置分页信息
		List<TbItem> lists = itemMapper.selectByExample(example);//分页查询商品列表
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(lists);//分页插件提供,创建pageInfo对象获取分页信息
		DatagridPageBean bean=new DatagridPageBean();
		bean.setRows(lists);//设置查询分页记录
		bean.setTotal(pageInfo.getTotal());//设置总记录数
		return bean;
	}

	/**
	 * 保存商品数据,以商品的描述表的信息
	 * 参数: TbItem item, TbItemDesc desc
	 * 返回:E3mallResult
	 */
	@Override
	public E3mallResult addItem(TbItem item, TbItemDesc desc) {
		//保存商品
		long itemId = IDUtils.genItemId();
		//生成商品ID
		
		item.setId(itemId);
		//添加商品状态,1:正常,2:下架,3:删除
		item.setStatus((byte)1);
		//添加商品时间
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);
		
		//保存商品描述
		desc.setCreated(date);
		desc.setUpdated(date);
		desc.setItemId(itemId);
		itemDescMapper.insert(desc);
		return E3mallResult.ok();
	}
	
	

}
