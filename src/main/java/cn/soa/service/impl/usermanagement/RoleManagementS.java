package cn.soa.service.impl.usermanagement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.soa.dao.IotUserRoleAuthMapper;
import cn.soa.dao.UserRoleMapper;
import cn.soa.dao.usermanagement.RoleManagementMapper;
import cn.soa.entity.IotUserRoleAuth;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleRelation;
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
	@Autowired
	private IotUserRoleAuthMapper authMapper;
	@Autowired
	private UserRoleMapper roleMapper;
	
	/**
	 * 条件查询角色列表
	 * @param roleName - 角色名字
	 * @param state - 角色状态
	 * @param List<UserRoleVO> - 角色列表
	 */
	@Override
	public List<UserRoleVO> getUserRoles(String roleName, String state) {
		log.info("-----开始条件查询角色列表-----");
		try {
			
			List<UserRoleVO> list = roleManagementMapper.findUserRoles(roleName, state);
			
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
	 * @param name - 角色名称
	 */
	@Override
	public Boolean setRoleState(String rolid, Integer state, String name) {
		log.info("-----开始更新角色的状态-----");
		try {
			
			roleManagementMapper.updateRoleState(rolid, state, name);
			
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
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//String dateStr = sdf.format(new Date());
			//role.setCreate_time(dateStr);
			//role.setLast_modify_time(dateStr);
			//查询角色名是否已存在
			Integer count = roleManagementMapper.findRoleByName(role.getName());
			if(count != 0) {
				log.info("-----该角色名已存在------");
				return null;
			}
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
	public Boolean removeRoleType(String[] rolid) {
		log.info("-----开始删除角色类型-----");
		try {
			
			for(String id : rolid) {
				roleManagementMapper.deleteRoleType(id);
				roleManagementMapper.deleteRoleAuth(id);
			}
			
			log.info("-----删除角色类型成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----删除角色类型发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("删除角色类型发生错误");
		}
	}
	
	/**
	 * 给角色添加资源
	 * @param rolid - 角色id
	 * @param resourceIds - 资源id列表
	 * @return
	 */
	@Override
	@Transactional
	public Boolean insertRoleResource(String rolid, String[] authIds) {
		log.info("-----开始给角色添加资源-----");
		try {
			//先清除角色的权限
			roleManagementMapper.deleteRoleAuth(rolid);
			
			//再插入新角色的权限
			for(String id : authIds) {
				IotUserRoleAuth roleAuth = new IotUserRoleAuth();
				roleAuth.setRolAutId(UUID.randomUUID().toString().replace("-", ""));
				
				roleAuth.setRolid(rolid);
				roleAuth.setAutid(id);
				authMapper.insert(roleAuth);
			}
			
			log.info("-----给角色添加资源成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----给角色添加资源发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("给角色添加资源发生错误");
		}
	}
	
	/**
	 * 角色关联人员组织
	 * @param rolid - 角色id
	 * @param userids - 人员id
	 * @return
	 */
	@Override
	@Transactional
	public Boolean insertUserRole(String rolid, String[] userids) {
		log.info("-----开始角色关联人员组织-----");
		try {
			//先清除角色和人员的关系
			roleMapper.deleteUserUserAndRolebyId(rolid);
			
			//再插入角色人员组织关联
			List<UserRoleRelation> list = new LinkedList<>();
			for(String id : userids) {
				UserRoleRelation relation = new UserRoleRelation();
				relation.setRolid(rolid);
				relation.setUserid(id);
				list.add(relation);
			}
			roleMapper.saveUserUserRoleInBatch(list);
			
			log.info("-----角色关联人员组织成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----角色关联人员组织发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("角色关联人员组织发生错误");
		}
	}
	
	/**
	 * 根据角色ID查询人员列表
	 * @param rolid - 角色id
	 */
	@Override
	public List<String> getUserByRolid(String rolid) {
		log.info("-----开始根据角色ID查询人员列表-----");
		try {
			
			List<String> list = roleManagementMapper.findUserByRolid(rolid);
			if(list == null) {
				list = new ArrayList<String>();
			}
			
			log.info("-----根据角色ID查询人员列表成功-----");
			return list;
			
		}catch (Exception e) {
			log.info("-----根据角色ID查询人员列表发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 查询角色类型是否存在
	 * @param roleName - 角色名称
	 */
	@Override
	public Boolean isExistRoleName(String roleName) {
		log.info("-----开始查询角色类型是否存在-----");
		try {
			
			Integer count = roleManagementMapper.findRoleByName(roleName);
			log.info("-----查询角色类型是否存在成功-----");
			if(count == 0) {
				return false;
			}

			return true;
		}catch (Exception e) {
			log.info("-----查询角色类型是否存在发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}

}
