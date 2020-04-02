package cn.soa.service.impl.usermanagement;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.soa.dao.IotUserAuthorityMapper;
import cn.soa.dao.usermanagement.UserModuleResourceMapper;
import cn.soa.entity.IotUserAuthority;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.ResourceTree;
import cn.soa.service.inter.usermanagement.UserModuleResourceSI;
import lombok.extern.slf4j.Slf4j;
/**
 * 菜单管理业务层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
@Service
@Slf4j
public class UserModuleResourceS implements UserModuleResourceSI {
	
	@Autowired
	private UserModuleResourceMapper umrMapper;
	@Autowired
	private IotUserAuthorityMapper authMapper;
	
	/**
	 * 查询所有的权限资源信息
	 * 
	 * @return List<IotUserModuleResource> - 权限资源信息列表
	 */
	
	@Override
	public List<IotUserModuleResource> getAllResources() {
		log.info("-----开始查询所有的权限资源信息-----");
		try {
			
			List<IotUserModuleResource> list = umrMapper.findAllResources();
			
			log.info("-----查询所有的权限资源信息成功-----");
			return list;
			
		}catch (Exception e) {
			log.info("-----查询所有的权限资源信息发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 添加菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	@Override
	@Transactional
	public Boolean addModuleResource(IotUserModuleResource resource) {
		log.info("-----开始添加菜单资源信息-----");
		try {
			resource.setCreateTime(new Date());
			resource.setLastModifyTime(new Date());
			String modId = UUID.randomUUID().toString().replace("-", "");
			resource.setModId(modId);
			umrMapper.insertModuleResource(resource);
			
			//插入权限与资源关系记录
			IotUserAuthority auth = new IotUserAuthority();
			auth.setAutid(UUID.randomUUID().toString().replace("-", ""));
			auth.setResourceid(modId);
			auth.setType((short) 1);
			auth.setName(resource.getName());
			auth.setNote(resource.getName());
			
			authMapper.insert(auth);
			
			log.info("-----添加菜单资源信息成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----添加菜单资源信息发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("添加菜单资源信息发生错误");
		}
	}
	
	/**
	 * 更新菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	@Override
	public Boolean setModuleResource(IotUserModuleResource resource) {
		log.info("-----开始更新菜单资源信息-----");
		try {
			resource.setLastModifyTime(new Date());
			umrMapper.updateModuleResource(resource);
			
			log.info("-----更新菜单资源信息成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----更新菜单资源信息发生错误-----");
			log.info("--{}", e);
			return false;
		}
	}
	
	/**
	 * 删除菜单资源信息
	 * @param modId - 菜单资源id
	 * 
	 */
	@Override
	public Boolean removeModuleResource(String modId) {
		log.info("-----开始删除菜单资源信息-----");
		try {
			//1.检查是否是父资源
			List<IotUserModuleResource> list = umrMapper.findAllResources();
			for(IotUserModuleResource resource : list) {
				if(modId.equals(resource.getParentId())) {
					log.info("-----该菜单资源属于父级资源，不能删除-----");
					return false;
				}
			}
			
			//2. 不是父级资源，执行删除
			umrMapper.deleteModuleResource(modId);
			
			log.info("-----删除菜单资源信息成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----删除菜单资源信息发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 获取资源信息树
	 * 
	 * @return ResourceTree - 权限资源信息树
	 */
	@Override
	public List<ResourceTree> getResourceTree() {
		log.info("-----开始获取资源信息树-----");
		try {
			//1.获取所有资源信息列表
			List<IotUserModuleResource> list = umrMapper.findAllResources();
			
			//2. 列表转换成树
			List<ResourceTree> tree = new LinkedList<ResourceTree>();
			for(IotUserModuleResource resource : list) {
				if("-1".equals(resource.getParentId()) || "0".equals(resource.getParentId())) {
					//一级资源
					ResourceTree head = new ResourceTree();
					head.setId(resource.getAuthId());
					head.setTitle(resource.getName());
					//递归转换树
					listParseTree(list, head);
					
					tree.add(head);
				}
			}
			
			log.info("-----获取资源信息树成功-----");
			return tree;
			
		}catch (Exception e) {
			log.info("-----获取资源信息树发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}

	/**
	 * 递归将列表转换成树
	 * @param list - 资源列表
	 * @param parent - 资源父节点对象
	 */
	private void listParseTree(List<IotUserModuleResource> list, ResourceTree parent) {
		for(IotUserModuleResource resource : list) {
			if(parent.getId().equals(resource.getParentId())) {
				ResourceTree sub = new ResourceTree();
				sub.setId(resource.getAuthId());
				sub.setTitle(resource.getName());
				//添加子节点
				parent.getChildren().add(sub);
				//递归调用
				listParseTree(list, sub);
			}
		}
	}
	
	/**
	 * 通过角色ID查询其拥有的菜单资源
	 * @param rolid - 角色id
	 */
	@Override
	public List<IotUserModuleResource> getResources(String rolid) {
		log.info("-----开始通过角色ID查询其拥有的菜单资源-----");
		try {
			List<IotUserModuleResource> list = umrMapper.findResourcesByRolid(rolid);
			
			log.info("-----通过角色ID查询其拥有的菜单资源成功-----");
			return list;
			
		}catch (Exception e) {
			log.info("-----通过角色ID查询其拥有的菜单资源发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}

}
