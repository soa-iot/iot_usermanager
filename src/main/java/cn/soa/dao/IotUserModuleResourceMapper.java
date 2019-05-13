package cn.soa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.IotUserModuleResource;

@Mapper
public interface IotUserModuleResourceMapper {
	int deleteByPrimaryKey(String modid);

	int deleteByParentId(String parentId);

	int insert(IotUserModuleResource record);

	int insertSelective(IotUserModuleResource record);

	IotUserModuleResource selectByPrimaryKey(String modid);

	int updateByPrimaryKeySelective(IotUserModuleResource record);

	int updateByPrimaryKey(IotUserModuleResource record);

	/**
	 * 查询所有的权限资源信息
	 * 
	 * @return
	 */
	List<IotUserModuleResource> findAllResourceInfo();

	/**
	 * 查询父级资源id和名称
	 * 
	 * @return
	 */
	List<Map<String, String>> findParentResource();
	
	/**   
     * @Title: findAuthResourceByRoleid   
     * @Description: 根据用户角色id和菜单id，查询按钮id  
     * @return: List<IotUserModuleResource>        
     */  
    List<IotUserModuleResource> findAuthResourceByRoleid( String rolid,String modId);
}