
/**
 * <一句话功能描述>
 * <p>权限资源，业务层
 * @author 陈宇林
 * @version [版本号, 2019年2月2日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.IotUserAuthorityMapper;
import cn.soa.dao.IotUserModuleResourceMapper;
import cn.soa.dao.IotUserRoleAuthMapper;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.Node;
import cn.soa.service.inter.ResourceServiceInter;
import cn.soa.util.DataUtil;

@Service
public class ResourceService implements ResourceServiceInter {

	@Autowired
	private IotUserModuleResourceMapper resourceMapper;
	
	@Autowired
	private IotUserAuthorityMapper userAuthorityMapper;
	
	@Autowired
	private IotUserRoleAuthMapper userRoleAuthMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.soa.service.inter.ResourceServiceInter#getResourceInfo()
	 */
	@Override
	public List<IotUserModuleResource> getResourceInfo() {
		
		List<IotUserModuleResource> resourceInfo = resourceMapper.findAllResourceInfo();
		System.out.println(resourceInfo);
		
		return resourceInfo;
	}


	/* (non-Javadoc)
	 * @see cn.soa.service.inter.ResourceServiceInter#delResourceInfoById(java.lang.String)
	 */
	@Override
	public int delResourceInfoById(String modId) {
		
		/**
		 * 删除资源
		 */
		int resultNum = resourceMapper.deleteByPrimaryKey(modId);
		
		resultNum += resourceMapper.deleteByParentId(modId);
		
		resultNum += userRoleAuthMapper.deleteByModid(modId);
		
		resultNum += userAuthorityMapper.deleteAuthByModid(modId);
		
		
		return resultNum;
	}


	/* (non-Javadoc)
	 * @see cn.soa.service.inter.ResourceServiceInter#getParentResource()
	 */
	@Override
	public List<Map<String, String>> getParentResource() {
		List<Map<String,String>> result = resourceMapper.findParentResource();
		return result;
	}


	/* (non-Javadoc)
	 * @see cn.soa.service.inter.ResourceServiceInter#addResourceInfo(cn.soa.entity.IotUserModuleResource)
	 */
	@Override
	public Integer addResourceInfo(IotUserModuleResource resource) {
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		Integer result = resourceMapper.insertSelective(resource);
		
		System.out.println(result);
		return result;
	}


	/* (non-Javadoc)
	 * @see cn.soa.service.inter.ResourceServiceInter#updateResourceInfo(cn.soa.entity.IotUserModuleResource)
	 */
	@Override
	public Integer updateResourceInfo(IotUserModuleResource resource) {
		
		Integer result = resourceMapper.updateByPrimaryKeySelective(resource);
		return result;
	}


	/* (non-Javadoc)
	 * @see cn.soa.service.inter.ResourceServiceInter#getResourceInfoOfNode()
	 */
	@Override
	public List<Node> getResourceInfoOfNode() {
		
		List<IotUserModuleResource> resourceInfos = resourceMapper.findAllResourceInfo();
		List<Node> nodes = new ArrayList<Node>();
		for(IotUserModuleResource resourceInfo : resourceInfos) {
			
			if(("-1").equals(resourceInfo.getParentId())) {
				Node node = new Node();
				node.setId(resourceInfo.getModId());
				node.setName(resourceInfo.getName());
				node.setSpread(false);
				node.setChildren(DataUtil.findChildNode(resourceInfo, resourceInfos));
				nodes.add(node);
			}
		}
		
		return nodes;
	}

}
