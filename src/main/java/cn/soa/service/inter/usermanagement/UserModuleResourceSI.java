package cn.soa.service.inter.usermanagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.ResourceTree;
import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;

/**
 * 菜单管理业务层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
public interface UserModuleResourceSI {
	
	/**
	 * 查询所有的权限资源信息
	 * 
	 * @return List<IotUserModuleResource> - 权限资源信息列表
	 */
	List<IotUserModuleResource> getAllResources();
	
	/**
	 * 获取资源信息树
	 * 
	 * @return List<ResourceTree> - 权限资源信息树
	 */
	List<ResourceTree> getResourceTree();
	
	/**
	 * 添加菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	Boolean addModuleResource(IotUserModuleResource resource);
	
	/**
	 * 更新菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	Boolean setModuleResource(IotUserModuleResource resource);
	
	/**
	 * 删除菜单资源信息
	 * @param modId - 菜单资源id
	 * 
	 */
	Boolean removeModuleResource(String modId);
}
