package cn.soa.service.impl.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.usermanagement.RoleManagementMapper;
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

}
