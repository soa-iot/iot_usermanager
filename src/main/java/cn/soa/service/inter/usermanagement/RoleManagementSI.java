package cn.soa.service.inter.usermanagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleVO;

/**
 * 角色管理业务层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
public interface RoleManagementSI {
	
	/**
	 * 条件查询角色列表
	 * @param roleName - 角色名字
	 * @param List<UserRoleVO> - 角色列表
	 */
	List<UserRoleVO> getUserRoles(String roleName);
	
	/**
	 * 更新角色的状态
	 * @param rolid - 角色id
	 * @param state - 角色状态
	 */
	Boolean setRoleState(String rolid, Integer state);
	
	/**
	 * 添加新角色类型
	 * @param role - 角色信息对象
	 */
	Boolean addNewRole(UserRole role);
	
	/**
	 * 删除角色类型
	 * @param rolid - 角色id
	 */
	Boolean removeRoleType(String rolid);
}
