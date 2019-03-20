package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.IotUserAuthority;

@Mapper
public interface IotUserAuthorityMapper {
	int deleteByPrimaryKey(String autid);

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