package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.IotUserRoleAuth;

@Mapper
public interface IotUserRoleAuthMapper {
    int deleteByPrimaryKey(String rolAutId);
    
    /**
     *  根据IOT_USER_MODULE_RESOURCE的id关联删除权限表IOT_USER_ROLE_AUTH的数据
     * @param modid
     * @return
     */
    int deleteByModid(String modid);
    

    int insert(IotUserRoleAuth record);

    int insertSelective(IotUserRoleAuth record);

    IotUserRoleAuth selectByPrimaryKey(String rolAutId);

    int updateByPrimaryKeySelective(IotUserRoleAuth record);

    int updateByPrimaryKey(IotUserRoleAuth record);
    
    List<String> selectByAutid(String authorityId);
    
    /**
	 * 根据权限id删除数据
	 * 
	 * @param Autid
	 *            权限id
	 * @return 影响数据条数
	 */
	int deleteByAutid(String autid);
}