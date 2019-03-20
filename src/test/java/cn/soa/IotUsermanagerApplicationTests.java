package cn.soa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.service.impl.RoleAuthorityService;
import cn.soa.service.inter.RoleAuthorityServiceInter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IotUsermanagerApplicationTests {
	
	@Autowired
	private RoleAuthorityServiceInter service;

	
	
	@Test
	public void testAuthorityService() {
		service.getAuthorityInfo();
	}

}

