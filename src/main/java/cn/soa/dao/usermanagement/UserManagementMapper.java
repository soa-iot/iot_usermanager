package cn.soa.dao.usermanagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;

/**
 * 用户管理持久层
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
@Mapper
public interface UserManagementMapper {
	
	/**
	 * 条件查询用户信息列表
	 * @param query - 查询的条件
	 * @return List<UserInfoVO> - 用户信息列表
	 */
	List<UserInfoVO> findUsersByCondition(@Param("query") UserQueryCondition query);
	
	/**
	 * 统计条件查询的用户信息数量
	 * @param query - 查询的条件
	 * @return Integer - 用户信息数量
	 */
	Integer countUsersByCondition(@Param("query") UserQueryCondition query);
	
	/**
	 * 更新用户在用户表状态
	 * @param usernum - 用户账号
	 * @param state - 用户状态码： 1-正常，2-禁用
	 * @return Integer - 受影响的行数
	 */
	Integer updateUserState(@Param("usernum") String usernum, @Param("state") Integer state);
	
	/**
	 * 更新用户在组织表状态
	 * @param usernum - 用户账号
	 * @param state - 用户状态码： 1-正常，2-禁用
	 * @return Integer - 受影响的行数
	 */
	Integer updateOrganState(@Param("usernum") String usernum, @Param("state") Integer state);
}
