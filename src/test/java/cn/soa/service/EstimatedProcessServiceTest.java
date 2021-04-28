package cn.soa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.UserOrganization;
import cn.soa.service.inter.EstimatedProcessServiceInter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EstimatedProcessServiceTest {

	@Autowired
	private EstimatedProcessServiceInter estimatedProcessServiceInter;
	
	@Test
	public void getUserByRoleNameTest() {
		List<UserOrganization> userInfos = estimatedProcessServiceInter.getUserByRoleName("HSE办公室");
		System.err.println(userInfos);
	}
}
