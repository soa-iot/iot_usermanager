package cn.soa.dao.usermanagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.IotUserModuleResource;

/**
 * 菜单管理持久层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */

@Mapper
public interface UserModuleResourceMapper {
	
	/**
	 * 查询所有的权限资源信息
	 * 
	 * @return List<IotUserModuleResource> - 权限资源信息列表
	 */
	List<IotUserModuleResource> findAllResources();
	
	/**
	 * 添加菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	Integer insertModuleResource(@Param("resource") IotUserModuleResource resource);
	
	/**
	 * 通过资源ID查询权限ID
	 * @param resourceId - 资源ID
	 * @return 权限ID
	 */
	String findAuthorityId(String resourceId);
	
	/**
	 * 通过父id查询子资源列表
	 * @param parentId - 父id
	 * @return List<IotUserModuleResource> - 子资源列表
	 */
	List<IotUserModuleResource> findResourceByParentId(String parentId);
	
	
	/**
	 * 更新菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	Integer updateModuleResource(@Param("resource") IotUserModuleResource resource);
	
	/**
	 * 删除菜单资源信息
	 * @param modId - 菜单资源id
	 * 
	 */
	Integer deleteModuleResource(String modId);
	
	/**
	 * 通过角色ID查询其拥有的资源
	 * @param rolid - 角色id
	 * @param isParent - 状态 0-父节点 ， 1-子节点
	 */
	List<IotUserModuleResource> findResourcesByRolid(@Param("rolid")String rolid, @Param("isParent")Integer isParent);
	
	/**
	 * 更改菜单资源IS_PARENT状态
	 * @param modId - 菜单资源id
	 * @param state - 状态 0-父节点 ， 1-子节点
	 */
	Integer updateResourceState(@Param("modId") String modId, @Param("state") Integer state);
	
}