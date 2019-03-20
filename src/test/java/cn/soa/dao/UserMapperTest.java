package cn.soa.dao;

import java.util.ArrayList;
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
public class UserMapperTest {
	@Autowired
	public UserMapper userMapper;
	
	//@Test
	public void findUserById() {
		//String userI
	}
	
	//@Test
	public void findUsersAll() {
		List<UserOrganization> findUsersAll = userMapper.findUsersAll();
		System.out.println(findUsersAll);
	}
	
	//根据用户唯一标识num查询用户
	//@Test
	public void findUserByUsernum() {
		String userNum = "1";
		UserOrganization u = userMapper.findUserByUsernum(userNum);
		System.out.println(u);
	}
	
	//查询所有用户信息和对应的状态
//	@Test
	public void findUsersAndState() {
		List<UserOrganization> findUsersAndState = userMapper.findUserAll();
		System.out.println(findUsersAndState);
	}
		
	
	//单个增加用户
//	@Test
	public void saveUser() {		
		String name = "小小";
		String parent_id = "0";
		String usernum = "134";
		String user_password = "123";
		int is_parent = 1; 
		int state = 0; 
		String note = "dota";
		int remark1 = 0;
		String remark2 = "dota";
		UserOrganization u = new UserOrganization(
				name, parent_id, usernum, user_password, is_parent, state, note,remark1,remark2 );
		int i = userMapper.saveUser(u);
		System.out.println(i);
	}
	
	//@Test
	public void saveUserBackId() {
		UserOrganization u = new UserOrganization();
		u.setUsernum( "test" );
		u.setName( "name" );
		u.setIs_parent(1);
		int i = userMapper.saveUserBackId(u);
		System.out.println(u.getOrgid());
		System.out.println(i);
	}
	
	//单个增加用户,返回id
	//@Test
	public void saveOrganBackId() {		
		String name = "王者荣耀";
		String parent_id = "";
		String usernum = "-1";
		String user_password = "123";
		int is_parent = 0; 
		String note = "王者荣耀";
		UserOrganization u = new UserOrganization(
				name, parent_id, usernum, user_password, is_parent, note);
		//int saveUser = userMapper.saveUser(u);
//		UserOrganization u1 = new UserOrganization(
//				"射手", "0", "1", "123", 0, 0, "1", 1, "dota");
//		UserOrganization u2 = new UserOrganization(
//				"法师", "0", "2", "123", 0, 0, "1", 1, "dota");
//		UserOrganization u3 = new UserOrganization(
//				"辅助", "0", "3", "123", 0, 0, "1", 1, "dota");
//		UserOrganization u4 = new UserOrganization(
//				"坦克", "0", "4", "123", 0, 0, "1", 1, "dota");
		UserOrganization u5 = new UserOrganization(
				"后裔", "1", "11", "123", 0, 0, "1", 1, "dota");
		UserOrganization u6 = new UserOrganization(
				"伽罗", "1", "12", "123", 0, 0, "1", 1, "dota");
//		int saveUserBackId = userMapper.saveUserBackId(u);
//		System.out.println(saveUserBackId);
//		System.out.println(u.getOrgid());
		
		//批量
//		System.out.println(u1);
//		userMapper.saveUserBackId(u1);
//		userMapper.saveUserBackId(u2);
//		userMapper.saveUserBackId(u3);
//		userMapper.saveUserBackId(u4);
		userMapper.saveOrganBackId(u5);
		userMapper.saveOrganBackId(u6);
	}
	
//	@Test
	//批量增加用户
//	public void saveUserByBatch() {
//		UserOrganization u1 = new UserOrganization(
//				"射手", "0", "1", "", 0, 1, "dota");
//		UserOrganization u2 = new UserOrganization(
//				"法师", "0", "2", "", 0, 1, "dota");
//		UserOrganization u3 = new UserOrganization(
//				"辅助", "0", "3", "", 0, 1, "dota");
//		UserOrganization u4 = new UserOrganization(
//				"坦克", "0", "4", "", 0, 1, "dota");
//		ArrayList<UserOrganization> list = new ArrayList<UserOrganization>();
//		list.add(u1);
//		list.add(u2);
//		list.add(u3);
//		list.add(u4);
//		int i = userMapper.saveUserByBatch(list);
//		System.out.println(i);
//	}
	
	//修改用户
	@Test
	public void modifyUserById() {
		UserOrganization u = new UserOrganization();
		u.setOrgid("919B20B203E144CABF8B2C624A69C1A7");
		u.setUsernum("11");
		u.setName("后裔");
		int i = userMapper.modifyUserById(u);
		System.out.println(i);
	}
	
	
	
	//@Test
	public void modifyUserBynum() {
		UserOrganization u = new UserOrganization();
		u.setUsernum("11");
		u.setParent_id("1");
		int i = userMapper.modifyUserBynum(u);
		System.out.println(i);
	}
	
	//根据userId删除用户
	//@Test
	public void deleteUserById() {
		String userId = "99392DAEB9FE4A1BA0732D5BF63BDB18";
		int i = userMapper.deleteUserById(userId);
		System.out.println(i);
		
	}
	
	//根据usernum删除用户
	//@Test
	public void deleteUserByNum() {
		String usernum = "test11";
		int i = userMapper.deleteUserByUsernum(usernum);
		System.out.println(i);		
	}
	
}
