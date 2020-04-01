package cn.soa.dao.usermanagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleVO;


/**
 * 角色管理持久层
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
@Mapper
public interface RoleManagementMapper {
	
	/**
	 * 添加用户角色关系
	 * @param usernum - 用户账号
	 * @param rolid - 角色ID
	 */
	Integer insertUserRole(@Param("usernum") String usernum, @Param("rolid") String rolid);
	
	/**
	 * 条件查询角色列表
	 * @param roleName - 角色名字
	 * @param List<UserRoleVO> - 角色列表
	 */
	List<UserRoleVO> findUserRoles(String roleName);
	
	/**
	 * 更新角色的状态
	 * @param rolid - 角色id
	 * @param state - 角色状态
	 */
	Integer updateRoleState(@Param("rolid")String rolid, @Param("state")Integer state);
	
	/**
	 * 添加新角色类型
	 * @param role - 角色信息对象
	 */
	Integer insertNewRole(@Param("role") UserRole role);
	
	/**
	 * 删除角色类型
	 * @param rolid - 角色id
	 */
	Integer deleteRoleType(String rolid);
}
