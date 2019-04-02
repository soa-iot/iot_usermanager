package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.IotUserAuthority;

@Mapper
public interface IotUserAuthorityMapper {
	int deleteByPrimaryKey(String autid);

	/**
	 * 根据IOT_USER_MODULE_RESOURCE的id关联删除权限表IOT_USER_AUTHORITY的数据
	 * 
	 * @return
	 */
	int deleteAuthByModid(String modid);

	/**
	 * 根据权限id 删除权限及子权限
	 * 
	 * @param autid
	 * @return
	 */
	int deleteByAutid(String autid);

	int insert(IotUserAuthority record);

	int insertSelective(IotUserAuthority record);

	IotUserAuthority selectByPrimaryKey(String autid);

	int updateByPrimaryKeySelective(IotUserAuthority record);

	int updateByPrimaryKey(IotUserAuthority record);

	/**
	 * 查询所有权限信息
	 * 
	 * @return
	 */
	List<IotUserAuthority> findAllAuthorityInfo();

}