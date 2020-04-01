package cn.soa.service.impl.usermanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.usermanagement.RoleManagementMapper;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleVO;
import cn.soa.service.inter.usermanagement.RoleManagementSI;
import lombok.extern.slf4j.Slf4j;

/**
 * 角色管理业务层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
@Service
@Slf4j
public class RoleManagementS implements RoleManagementSI {
	
	@Autowired
	private RoleManagementMapper roleManagementMapper;
	
	/**
	 * 条件查询角色列表
	 * @param roleName - 角色名字
	 * @param List<UserRoleVO> - 角色列表
	 */
	@Override
	public List<UserRoleVO> getUserRoles(String roleName) {
		log.info("-----开始条件查询角色列表-----");
		try {
			
			List<UserRoleVO> list = roleManagementMapper.findUserRoles(roleName);
			
			log.info("-----条件查询角色列表信息成功-----");
			return list;
			
		}catch (Exception e) {
			log.info("-----条件查询角色列表信息发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 更新角色的状态
	 * @param rolid - 角色id
	 * @param state - 角色状态
	 */
	@Override
	public Boolean setRoleState(String rolid, Integer state) {
		log.info("-----开始更新角色的状态-----");
		try {
			
			roleManagementMapper.updateRoleState(rolid, state);
			
			log.info("-----更新角色的状态成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----更新角色的状态发生错误-----");
			log.info("--{}", e);
			return false;
		}
	}
	
	/**
	 * 添加新角色类型
	 * @param role - 角色信息对象
	 */
	@Override
	public Boolean addNewRole(UserRole role) {
		log.info("-----开始添加新角色类型-----");
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-DD HH:MM:SS");
			String dateStr = sdf.format(new Date());
			
			role.setCreate_time(dateStr);
			role.setLast_modify_time(dateStr);
			roleManagementMapper.insertNewRole(role);
			
			log.info("-----添加新角色类型成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----添加新角色类型发生错误-----");
			log.info("--{}", e);
			return false;
		}
	}
	
	/**
	 * 删除角色类型
	 * @param rolid - 角色id
	 */
	@Override
	public Boolean removeRoleType(String rolid) {
		log.info("-----开始删除角色类型-----");
		try {
			
			roleManagementMapper.deleteRoleType(rolid);
			
			log.info("-----删除角色类型成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----删除角色类型发生错误-----");
			log.info("--{}", e);
			return false;
		}
	}

}
