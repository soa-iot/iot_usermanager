package cn.soa.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.UserOrganization;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EstimatedProcessMapperTest {

	@Autowired
	private EstimatedProcessMapper estimatedProcessMapper;
	
	@Test
	public void findUserByRoleNameTest() {
		List<UserOrganization> userInfos = estimatedProcessMapper.findUserByRoleName("3591A0F744F49EFBABA6959917139CE");
		System.err.println(userInfos);
	}
}
