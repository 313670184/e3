package cn.e3.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.e3.content.service.ContentCategoryService;
import cn.e3.mapper.TbContentCategoryMapper;
import cn.e3.pojo.TbContentCategory;
import cn.e3.pojo.TbContentCategoryExample;
import cn.e3.pojo.TbContentCategoryExample.Criteria;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.TreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Resource
	 private TbContentCategoryMapper categoryMapper;
	
	/**
	 * 需求:根据id查询树形菜单(门户系统页面分类信息)子节点
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 */
	@Override
	public List<TreeNode> findContentCategoryWithTreeNodeList(Long parentId) {
		//创建分类对象example对象
		TbContentCategoryExample categoryExample=new TbContentCategoryExample();
		//创建criteria对象,设置查询参数
		Criteria createCriteria = categoryExample.createCriteria();
		//根据父id查询树形菜单
		createCriteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> selectByExample = categoryMapper.selectByExample(categoryExample);
		//创建树形节点集合对象,封装树形节点数据
		
		List<TreeNode> treeNodeList=new ArrayList<TreeNode>();
		for (TbContentCategory example : selectByExample) {
			TreeNode e=new TreeNode();
			//设置树形节点名称
			e.setText(example.getName());
			//设置树形节点状态
			//is_parent=1,标识此节点有子节点,state="closed"
			//id_parent=0,表示此节点没有子节点,stateed="open"
			e.setState(example.getIsParent()?"closed":"open");
			//设置树形节点id
			e.setId(example.getId());
			//添加节点到集合中
			treeNodeList.add(e);
		}
		return treeNodeList;
	}

	/**
	 * 需求:根据 添加或修改子节点
	 *参数:Long parentId,String name
	 *返回值  E3mallResult
	 *业务:新建节点一定是子节点,is_parent=false
	 *如果新建节点的父节点是子节点,修改原子节点状态is_parent=true
	 *如果新建节点的父节点是父节点,直接创建
	 */
	@Override
	public E3mallResult createNode(Long parentId, String name) {
		
		//创建分类对象
		TbContentCategory record=new TbContentCategory();
		//设置树形节点参数
		//父类目ID=0时，代表的是一级的类目
		record.setParentId(parentId);
		//分类名称
		record.setName(name);
		//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
		record.setSortOrder(1);
		//该类目是否为父类目，1为true，0为false
		record.setIsParent(false);
		//设置状态,1:正常,2删除
		record.setStatus(1);
		Date date=new Date();
		record.setCreated(date);
		record.setUpdated(date);
		//执行添加
		categoryMapper.insert(record);
		//如果新建节点的父节点是子节点,修改原子节点状态is_parent=true
		//如果新建节点的父节点是父节点,直接创建	
		TbContentCategory selectByPrimaryKey = categoryMapper.selectByPrimaryKey(parentId);
		if (!selectByPrimaryKey.getIsParent()) {
			//父节点是子节点的状态,做修改
			selectByPrimaryKey.setIsParent(true);
			selectByPrimaryKey.setUpdated(date);
			//执行修改
			categoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		}
		
		return E3mallResult.ok(record);
	}

}
