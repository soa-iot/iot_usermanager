package cn.soa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.dao.UserInfoMapper;
import cn.soa.dao.UserMapper;
import cn.soa.dao.UserRoleMapper;
import cn.soa.entity.AuthInfo;
import cn.soa.service.inter.RoleServiceInter;
import cn.soa.service.inter.UserServiceInter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserTest {

	@Autowired
	private UserServiceInter userService;
	
	
	@Test
	public void getInitOrganServ() {
		 String usernum = "11";
		 List<Map<String, Object>> initOrganServ = userService.getInitOrganServ(usernum);
		 System.out.println(initOrganServ);
	}
		
}
