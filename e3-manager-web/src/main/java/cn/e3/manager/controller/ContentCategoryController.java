package cn.e3.manager.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.content.service.ContentCategoryService;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.TreeNode;

@Controller
public class ContentCategoryController {
	
	@Resource
	ContentCategoryService contentCategoryService;
	
	/**
	 * 需求:根据父id查询树形菜单(menu系统页面分类信息)子节点
	 * 请求:/content/category/list
	 * 参数:Long parentId
	 * 返回值 List<TreeNode>
	 */
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<TreeNode> findContentCategoryWithTreeNodeList(@RequestParam(value="id",defaultValue="0")Long parentId){
		List<TreeNode> findContentCategoryWithTreeNodeList = contentCategoryService.findContentCategoryWithTreeNodeList(parentId);
		return findContentCategoryWithTreeNodeList;
	}
	
	/**
	 * 需求:根据 添加或修改子节点
	 *请求 /content/category/create
	 *参数:Long parentId,String name
	 *返回值  E3mallResult
	 */
	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3mallResult createNode(Long parentId, String name) {
		E3mallResult createNode = contentCategoryService.createNode(parentId, name);
		return createNode;
	}
	

}
