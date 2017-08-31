package cn.e3.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.content.service.ContentService;
import cn.e3.mapper.TbContentMapper;
import cn.e3.pojo.TbContent;
import cn.e3.pojo.TbContentExample;
import cn.e3.pojo.TbContentExample.Criteria;
import cn.e3.utils.DatagridPageBean;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;
	
	/**
	 * 需求:根据分类id查询内容信息
	 * 请求:/content/query/list
	 * 参数:Long categoryId,Integer page, Integer rows
	 * 返回值:DatagridPageBean
	 */
	@Override
	public DatagridPageBean findContentWithCategoryId(Long categoryId,
			Integer page, Integer rows) {
		//创建DatagridPageBean封装返回参数
		DatagridPageBean bean=new DatagridPageBean();
		//创建内容对象TbContentExample对象
		TbContentExample example=new TbContentExample();
		Criteria createCriteria = example.createCriteria();
		//设置查询参数,根据分类id查询内容信息
		createCriteria.andCategoryIdEqualTo(categoryId);
		//查询之前,设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		List<TbContent> tbContentList = contentMapper.selectByExample(example);
		//床pageInfo对象,获取分页详细信息
		PageInfo<TbContent> info=new PageInfo<TbContent>(tbContentList);
		bean.setRows(tbContentList);
		bean.setTotal(info.getTotal());
		return bean;
	}

	/**
	 * 需求:添加广告内容 
	 * 请求:/content/save
	 * 请求参数 :TbContent
	 * 返回值:E3mallResult
	 */
	@Override
	public void saveContent(TbContent content) {
		Date date=new Date();
		content.setCreated(date);
		content.setUpdated(date);
		contentMapper.insert(content);
		
	}
	


}
