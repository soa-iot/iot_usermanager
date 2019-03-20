package cn.soa.dao;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.UserRole;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { IotUsermanagerApplication.class })
@WebAppConfiguration
public class UserAuthMapperTest {
	@Autowired
	public UserRoleMapper userRoleMapper;
	
	//@Test
	public void findUserById() {
		//String userId
	}
	
	
	 /**   
	  * @Title: saveUserRole   
	  * @Description: 单个增加用户角色       
	  * @return: void        
	  */  
	//@Test
	public void saveUserRole() {
		UserRole u = new UserRole();
		u.setName("射手");
		u.setState(1);
		u.setNote("射手");
		u.setRemark1(1);
		u.setRemark2("");
		int i = userRoleMapper.saveUserRole(u);
		System.out.println(i);
	}
	
	
	 /**   
	  * @Title: saveUserRoleInBatch   
	  * @Description:  批量增加用户角色信息 （对象以下属性值不能为null）       
	  * @return: void        
	  */  
	//@Test
	public void saveUserRoleInBatch() {
		UserRole u1 = new UserRole( "法师", 1, "法师", 0, "法师");
		UserRole u2 = new UserRole( "辅助", 1, "辅助", 0, "辅助");
		UserRole u3 = new UserRole( "坦克", 1, "坦克", 0, "坦克");
		ArrayList<UserRole> list = new ArrayList<UserRole>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		int i = userRoleMapper.saveUserRoleInBatch(list);
		System.out.println(i);
	}
	
	
	 /**   
	  * @Title: modifyUserRoleById   
	  * @Description:  根据角色id修改用户角色信息      
	  * @return: void        
	  */  
	//@Test
	public void modifyUserRoleById() {
		UserRole u1 = new UserRole( "射手", 1, "射手", 0, "射手");
		u1.setRolid("1");
		int i = userRoleMapper.modifyUserRoleById(u1);
		System.out.println(i);
	}
	
	
	 /**   
	  * @Title: saveUserAndRoleById   
	  * @Description:  根据用户id、用户角色id，增加关联关系         
	  * @return: void        
	  */  
	@Test
	public void saveUserAndRoleById() {
		int userid = 12;
		int rolid = 1;
		int i = userRoleMapper.saveUserAndRoleById(userid, rolid);
		System.out.println(i);		
	}
}
