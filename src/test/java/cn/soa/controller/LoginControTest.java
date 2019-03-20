package cn.soa.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.headResult.ResultJson;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { IotUsermanagerApplication.class })
@WebAppConfiguration
public class LoginControTest {
	@Autowired
	private LoginController loginController;
	
	@Test
	public void loginContrTest(){
		String userName = "亚瑟";
		String userPassword = "123";
		ResultJson<String> loginContr = loginController.loginContr(userName, userPassword);
		System.out.println(loginContr);			
	}
	
}
