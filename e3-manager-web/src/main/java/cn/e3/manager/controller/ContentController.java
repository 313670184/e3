package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.content.service.ContentService;
import cn.e3.pojo.TbContent;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

@Controller
public class ContentController {
	
	//注入content服务
	@Autowired
	private ContentService contentService;
	
	/**
	 * 需求:根据分类id查询内容信息
	 * 请求:/content/query/list
	 * 参数:Long categoryId,Integer page, Integer rows
	 * 返回值:DatagridPageBean
	 */
	@RequestMapping("/content/query/list")
	public @ResponseBody DatagridPageBean findContentWithCategoryId(Long categoryId,
			@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="30")Integer rows) {
		DatagridPageBean findContentWithCategoryId = contentService.findContentWithCategoryId(categoryId, page, rows);
		return findContentWithCategoryId;
	}
	
	/**
	 * 需求:添加广告内容 
	 * 请求:/content/save
	 * 请求参数 :TbContent
	 * 返回值:E3mallResult
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public E3mallResult saveContent(TbContent content){
		contentService.saveContent(content);
		
		return E3mallResult.ok();
		
	}
}
