package cn.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.UserInfo;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.service.inter.EstimatedProcessServiceInter;

/**
 * 问题评估组内处理控制层方法
 * 
 * @author Bru.Lo
 *
 */
@RestController
@RequestMapping("/groupprocess")
public class EstimatedProcessController {

	@Autowired
	private EstimatedProcessServiceInter estimatedProcessServiceInter;

	@GetMapping("/")
	public ResultJson<List<UserInfo>> getUserByRoleName(String roleName) {

		List<UserInfo> users = estimatedProcessServiceInter.getUserByRoleName(roleName);
		if (users != null) {
			for (int i = 0; i < 10; i++) {
				users.add(users.get(0));
			}
			users.get(0);
			return new ResultJson<List<UserInfo>>(0, "数据获取成功", users);
		}else {
			return new ResultJson<List<UserInfo>>(1, "数据获取失败", users);
		}
	}

}
