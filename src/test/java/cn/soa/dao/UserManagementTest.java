package cn.soa.dao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.dao.usermanagement.UserManagementMapper;
import cn.soa.entity.UserInfoVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserManagementTest {
	@Autowired
	public UserManagementMapper mapper;
	
	@Test
	public void findusers() {
		List<UserInfoVO> list = mapper.findUsersByCondition(null);
		System.out.println("-------------------");
		System.out.println(list.size());
		System.out.println(list);
	}
	
	@Test
	public void adduser() {
		UserInfoVO user = new UserInfoVO();
		user.setUsernum("王一一");
		user.setNname("王一一");
		user.setTelephone("1234567890");
		user.setPassword("123456");
		user.setSex(1);
		user.setNote("备注");
		user.setCreate_time(new Date());
		user.setLast_modify_time(new Date());
		mapper.insertUserInfo(user);
		
	}
}
