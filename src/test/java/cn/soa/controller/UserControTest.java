package cn.soa.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.entity.headResult.UserTableJson;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { IotUsermanagerApplication.class })
@WebAppConfiguration
public class UserControTest {
	@Autowired
	private UserController userController;
	
	
	 /**   
	  * @Title: getUserAllList   
	  * @Description:  获取所有用户      
	  * @return: UserTableJson<List<UserOrganization>>        
	  */  
	//@Test
	public void getUserAllList() {
		UserTableJson<List<UserOrganization>> userAllList = userController.getUserAllList();
		System.out.println(userAllList);
	}
	
	
	 /**   
	  * @Title: deleteUserContro   
	  * @Description:  根据usernum删除用户          
	  * @return: void        
	  */  
	@Test
	public void deleteUserContro(){
		String usernum = "134";
		ResultJson<String> deleteUserContro = userController.deleteUserContro(usernum);
		System.out.println(deleteUserContro);
	}
	
	
}
