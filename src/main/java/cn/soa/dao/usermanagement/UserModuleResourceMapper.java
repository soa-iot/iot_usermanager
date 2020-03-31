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
}