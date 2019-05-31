package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.IotIndexInfo;
import cn.soa.entity.UserRole;

@Mapper
public interface IndexInfoMapper {
	int deleteByPrimaryKey(String id);

	int insert(IotIndexInfo record);

	int insertSelective(IotIndexInfo record);

	IotIndexInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(IotIndexInfo record);

	int updateByPrimaryKey(IotIndexInfo record);

	List<IotIndexInfo> findIndexInfoByRoleId(List<UserRole> userRoles);

	/**
	 * 根据roleid删除数据
	 * 
	 * @param role
	 * @return
	 */
	int deleteByRoleId(List<UserRole> roles);
}