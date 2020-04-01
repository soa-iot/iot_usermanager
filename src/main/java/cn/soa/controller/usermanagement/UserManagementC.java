package cn.soa.controller.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.service.inter.usermanagement.UserManagementSI;
import lombok.extern.slf4j.Slf4j;

/**
 * 人员管理控制层
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
@RestController
@Slf4j
public class UserManagementC {
	
	@Autowired
	private UserManagementSI userManagementS;
	
	/**
	 * 根据条件获取用户信息列表
	 * @param query - 查询的条件
	 * @return ResponseEntity<List<UserInfoVO>> - 用户信息列表
	 */
	@RequestMapping("/user/management/query")
	public ResponseEntity<List<UserInfoVO>> findUserInfos(UserQueryCondition query){
		log.info("------进入接口UserManagementC...findUserInfos------");
		log.info("------查询条件为：condition= {}", query);
		
		ResponseEntity<List<UserInfoVO>> result = userManagementS.getUsersByCondition(query);
		if(result == null) {
			return new ResponseEntity<>(1, "查询用户信息失败");
		}
		return result;
	}
	
	/**
	 * 禁用或恢复用户账号
	 * @param usernum - 用户账号
	 * @param state - 账号状态
	 * @return ResponseEntity<List<UserInfoVO>> - 用户信息列表
	 */
	@RequestMapping("/user/management/state")
	public ResultJson<Boolean> lockOrUnlockUser(@RequestParam String usernum, @RequestParam Integer state){
		log.info("------进入接口UserManagementC...lockOrUnlockUser------");
		log.info("------用户账号 usernum= {}", usernum);
		log.info("------账号状态 state= {}", state);
		
		try {
			userManagementS.setUserState(usernum, state);
			
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "用户账号状态更新成功", true);
		}catch (Exception e) {
			log.info("--{}", e);
			return new ResultJson<Boolean>(ResultJson.ERROR, "用户账号状态更新失败", false);
		}

	}
	
	/**
	 * 添加用户账号信息
	 * @param user - 用户账号信息
	 */
	@RequestMapping("/user/management/create")
	public ResultJson<Boolean> addUserInfo(UserInfoVO user, String rolid, String parentId){
		log.info("------进入接口UserManagementC...addUserInfo------");
		log.info("------用户信息： {}", user);
		log.info("------角色ID rolid= {}", rolid);
		log.info("------父ID parentId= {}", parentId);
		
		//检查用户账号是否已存在
		Boolean result = userManagementS.checkUserExist(user.getUsernum());
		if(result) {
			return new ResultJson<Boolean>(ResultJson.ERROR, "用户账号已存在", false);
		}
		
		try {
			userManagementS.addUserInfo(user, rolid, parentId);
			
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "添加用户账号信息成功", true);
		}catch (Exception e) {
			log.info("--{}", e);
			return new ResultJson<Boolean>(ResultJson.ERROR, "添加用户账号信息失败", false);
		}

	}
	
	/**
	 * 修改用户账号信息
	 * @param user - 用户账号信息
	 */
	@RequestMapping("/user/management/edit")
	public ResultJson<Boolean> modifyUserInfo(UserInfoVO user, @RequestParam String parentId){
		log.info("------进入接口UserManagementC...modifyUserInfo------");
		log.info("------用户信息： {}", user);
		log.info("------父ID parentId= {}", parentId);
		
		try {
			userManagementS.setUserInfo(user, parentId);
			
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "修改用户账号信息成功", true);
		}catch (Exception e) {
			log.info("--{}", e);
			return new ResultJson<Boolean>(ResultJson.ERROR, "修改用户账号信息失败", false);
		}

	}
	
	/**
	 * 重置账号密码
	 * @param usernum - 用户账号
	 * @param password - 账号密码
	 */
	@RequestMapping("/user/password/reset")
	public ResultJson<Boolean> resetPassword(@RequestParam String usernum, @RequestParam String password){
		log.info("------进入接口UserManagementC...resetPassword------");
		log.info("------用户账号 usernum= {}", usernum);
		log.info("------账号密码 password= {}", password);
		
		Boolean result = userManagementS.setUserPassword(usernum, password);
		
		if(result) {
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "重置账号密码成功", result);
		}
		return new ResultJson<Boolean>(ResultJson.ERROR, "重置账号密码失败", result);

	}
}
