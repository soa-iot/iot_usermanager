package cn.soa.service.impl.usermanagement;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.soa.dao.usermanagement.OrganManagementMapper;
import cn.soa.dao.usermanagement.RoleManagementMapper;
import cn.soa.dao.usermanagement.UserManagementMapper;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserQueryCondition;
import cn.soa.service.inter.usermanagement.UserManagementSI;
import cn.soa.entity.OrganTree;
import cn.soa.entity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户信息管理业务层实现类
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
@Service
@Slf4j
public class UserManagementS implements UserManagementSI {
	
	@Autowired
	private UserManagementMapper umMapper;
	@Autowired
	private RoleManagementMapper rmMapper;
	@Autowired
	private OrganManagementMapper omMapper;
	
	/**
	 * 根据条件获取用户信息列表
	 * @param query - 查询的条件
	 * @return List<UserInfoVO> - 用户信息列表
	 */
	@Override
	public ResponseEntity<List<UserInfoVO>> getUsersByCondition(UserQueryCondition query){
		log.info("-----开始条件查询用户信息列表-----");
		try {
			ResponseEntity<List<UserInfoVO>> info = new ResponseEntity<List<UserInfoVO>>();
			info.setCode(0);
			info.setMsg("条件查询用户信息列表成功");
			//统计用户信息条数
			Integer count = umMapper.countUsersByCondition(query);
			if(count == 0) {
				log.info("-----条件查询用户信息数量为0-----");
				return info;
			}
			//查询用户信息列表
			List<UserInfoVO> list = umMapper.findUsersByCondition(query);
			//log.info("--{}", list);
			log.info("-----条件查询用户信息列表成功-----");
			info.setCount(count);
			info.setData(list);
			return info;
			
		}catch (Exception e) {
			log.info("-----条件查询用户信息列表发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 设置用户状态
	 * @param usernum - 用户账号
	 * @param state - 用户状态码： 1-正常，2-禁用
	 */
	@Override
	@Transactional
	public Boolean setUserState(String usernum, Integer state) {
		log.info("-----开始设置用户状态-----");
		try {
			
			String[] usernums = usernum.split(",");
			for(String user : usernums) {
				umMapper.updateUserState(user, state);
				umMapper.updateOrganState(user, state);
			}

			log.info("-----设置用户状态成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----设置用户状态发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("设置用户状态发生异常");
		}
	}
	
	/**
	 * 更新用户密码
	 * @param usernum - 用户账号
	 * @param password - 用户密码
	 */
	@Override
	public Boolean setUserPassword(String usernum, String password) {
		log.info("-----开始更新用户密码-----");
		try {
			
			umMapper.updateUserPassword(usernum, password);
			omMapper.updateUserOrga(usernum, null, null, password);
			
			log.info("-----更新用户密码成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----更新用户密码发生错误-----");
			log.info("--{}", e);
			return false;
		}
	}
	
	/**
	 * 检测用户账号是否已存在
	 * @param usernum - 用户账号
	 */
	@Override
	public Boolean checkUserExist(String usernum) {
		log.info("-----开始检测用户账号是否已存在-----");
		try {
			Integer rows = umMapper.findUserByUsernum(usernum);
			if(rows == 0) {
				log.info("------用户账号不存在------");
				return false;
			}
			log.info("------用户账号已存在------");
			return true;
			
		}catch (Exception e) {
			log.info("-----检测用户账号是否已存在发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 新增用户信息
	 * @param user - 用户信息对象
	 */
	@Override
	@Transactional
	public Boolean addUserInfo(UserInfoVO user, String rolid, String parentId) {
		log.info("-----开始新增用户信息-----");
		try {
			user.setCreate_time(new Date());
			user.setLast_modify_time(new Date());
			umMapper.insertUserInfo(user);
			rmMapper.insertUserRole(user.getUsernum(), rolid);
			omMapper.insertUserOrgan(user.getUsernum(), user.getNname(), parentId, user.getPassword());

			log.info("-----新增用户信息成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----新增用户信息发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("新增用户信息发生错误");
		}
	}
	
	/**
	 * 更新用户信息
	 * @param user - 用户信息对象
	 */
	@Override
	@Transactional
	public Boolean setUserInfo(UserInfoVO user, String parentId) {
		log.info("-----开始更新用户信息-----");
		try {
			user.setLast_modify_time(new Date());
			umMapper.updatetUserInfo(user); 
			omMapper.updateUserOrga(user.getUsernum(), user.getNname(), parentId, null);

			log.info("-----更新用户信息成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----更新用户信息发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("更新用户信息发生错误");
		}
	}
	
	/**
	 * 获取人员组织信息树
	 * 
	 * @return List<ResourceTree> - 人员组织信息树
	 */
	@Override
	public List<OrganTree> getOrganTree() {
		log.info("-----开始获取人员组织信息树-----");
		try {
			//1.获取所有人员组织信息列表
			List<UserOrganization> list = umMapper.findAllOrgans();
			
			//2. 列表转换成树
			List<OrganTree> tree = new LinkedList<OrganTree>();
			for(UserOrganization organ : list) {
				if(organ.getParent_id() == null || organ.getName().contains("净化厂")) {
					//一级组织
					OrganTree head = new OrganTree();
					head.setId(organ.getUsernum());
					head.setIsParent(organ.getIs_parent());
					head.setTitle(organ.getName());
					//递归转换树
					listParseTree(list, head);
					
					tree.add(head);
				}
			}
			
			log.info("-----获取人员组织信息树成功-----");
			return tree;
			
		}catch (Exception e) {
			log.info("-----获取人员组织信息树发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 递归将列表转换成树
	 * @param list - 人员组织列表
	 * @param parent - 人员组织父节点对象
	 */
	private void listParseTree(List<UserOrganization> list, OrganTree parent) {
		for(UserOrganization organ : list) {
			if(parent.getId().equals(organ.getParent_id())) {
				OrganTree sub = new OrganTree();
				sub.setId(organ.getUsernum());
				sub.setIsParent(organ.getIs_parent());
				sub.setTitle(organ.getName());
				//添加子节点
				parent.getChildren().add(sub);
				//递归调用
				listParseTree(list, sub);
			}
		}
	}
}
