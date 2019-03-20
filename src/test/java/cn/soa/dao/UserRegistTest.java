package cn.soa.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.UserRegister;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@WebAppConfiguration
public class UserRegistTest {
	@Autowired
	public UserRegistMapper userRegistMapper;
	
	//根据注册usernum查询注册用户
	//@Test
	public void findRegisterByNum() {
		String i = "123";
		UserRegister findRegisterByNum = userRegistMapper.findRegisterByNum(i);
		System.out.println(findRegisterByNum);
	}
	
	//查询所有注册用户
	//@Test
	public void findRegisters() {
		List<UserRegister> findRegisters = userRegistMapper.findRegisters();
		System.out.println(findRegisters);
	}
	
	//增加用户注册信息
	//@Test
	public void saveRegister() {
		UserRegister u1 = new UserRegister( "123", "test", 0, "note");
		int i = userRegistMapper.saveUserRegis(u1);
		System.out.println(i);
	}
	
	//根据num修改注册用户编号
	//@Test
	public void modifyRegisteState() {
		String num = "444";
		int modifyRegisteState = userRegistMapper.modifyRegisteState(num );
		System.out.println(modifyRegisteState);
	}
}
