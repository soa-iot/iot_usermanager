package cn.soa.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.soa.IotUsermanagerApplication;
import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRegister;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { IotUsermanagerApplication.class })
@WebAppConfiguration
public class UserInfoTest {
	@Autowired
	public UserRegistMapper userRegistMapper;
	
	//增加用户注册信息
	@Test
	public void saveRegister() {
		UserRegister u1 = new UserRegister( "123", "test", 0, "note");
		int i = userRegistMapper.saveUserRegis(u1);
		System.out.println(i);
	}
}
