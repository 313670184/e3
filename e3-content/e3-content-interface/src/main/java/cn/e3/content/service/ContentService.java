package cn.e3.content.service;

import cn.e3.pojo.TbContent;
import cn.e3.utils.DatagridPageBean;

public interface ContentService {
	
	/**
	 * 需求:根据分类id查询内容信息
	 * 请求:/content/query/list
	 * 参数:Long categoryId,Integer page, Integer rows
	 * 返回值:DatagridPageBean
	 */
	
	public DatagridPageBean findContentWithCategoryId(Long categoryId,Integer page,Integer rows);

	/**
	 * 需求:添加广告内容 
	 * 请求:/content/save
	 * 请求参数 :TbContent
	 * 返回值:E3mallResult
	 */
	public void saveContent(TbContent content);

}
