package cn.soa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.UserInfo;
import cn.soa.service.inter.EstimatedProcessServiceInter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EstimatedProcessServiceTest {

	@Autowired
	private EstimatedProcessServiceInter estimatedProcessServiceInter;
	
	@Test
	public void getUserByRoleNameTest() {
		List<UserInfo> userInfos = estimatedProcessServiceInter.getUserByRoleName("3591A0F744F49EFBABA6959917139CE");
		System.err.println(userInfos);
	}
}
