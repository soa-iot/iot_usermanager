package cn.soa.dao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.dao.usermanagement.RoleManagementMapper;
import cn.soa.dao.usermanagement.UserManagementMapper;
import cn.soa.dao.usermanagement.UserModuleResourceMapper;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserRoleVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserManagementTest {
	@Autowired
	public UserManagementMapper umapper;
	@Autowired
	public UserModuleResourceMapper rmapper;
	@Autowired
	public RoleManagementMapper rmMapper;
	
	@Test
	public void findusers() {
		List<UserInfoVO> list = umapper.findUsersByCondition(null);
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
		umapper.insertUserInfo(user);
		
	}
	
	@Test
	public void addResources() {
		
		IotUserModuleResource resource = new IotUserModuleResource();
		resource.setName("1");
		resource.setUrl("/1/1/1/1");
		resource.setDescribe("2");
		resource.setType(3);
		resource.setCreateTime(new Date());
		resource.setLastModifyTime(new Date());
		resource.setRemark1("4");
		resource.setParentId("111");
		resource.setIsParent("0");
		resource.setMenuIcon("icon");
		
		rmapper.insertModuleResource(resource);
	}
	
	@Test
	public void findRoles() {
		List<UserRoleVO> list = rmMapper.findUserRoles(null);
		System.out.println("-------------------");
		System.out.println(list.size());
		System.out.println(list);
	}
}
