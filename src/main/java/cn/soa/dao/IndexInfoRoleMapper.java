package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.Condition;
import cn.soa.entity.IndexInfoRole;
import cn.soa.entity.UserRole;

@Mapper
public interface IndexInfoRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(IndexInfoRole record);

    int insertSelective(IndexInfoRole record);

    IndexInfoRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IndexInfoRole record);

    int updateByPrimaryKey(IndexInfoRole record);

	/**
	 * @param userRoles
	 */
	int deleteRecords(List<UserRole> userRoles);

	/**
	 * @param condition
	 * @return
	 */
	List<IndexInfoRole> selectByCondition(Condition condition);
}