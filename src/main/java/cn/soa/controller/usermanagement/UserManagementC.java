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
}
