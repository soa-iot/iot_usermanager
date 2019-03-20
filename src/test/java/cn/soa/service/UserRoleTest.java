package cn.soa.service;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.dao.UserRoleMapper;
import cn.soa.entity.AuthInfo;
import cn.soa.service.inter.RoleServiceInter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserRoleTest {

	@Autowired
	public RoleServiceInter roleServiceInter;
	
	@Test
	public void findAuthByRolidServ() {
//		String rolid = "77A987B996C744EFAEC54B5855F7C98E";
		String rolid = "42ba62c1a1414d7491eb05338d14c1c3";
		ArrayList<AuthInfo> findAuthByRolidServ = roleServiceInter.findAuthByRolidServ(rolid);
		System.out.println(findAuthByRolidServ);
	}
		
}
