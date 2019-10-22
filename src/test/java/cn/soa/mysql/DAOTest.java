package cn.soa.mysql;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.dao.UserRoleMapper;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DAOTest {
	
	@Autowired
	private UserRoleMapper mapper;
	
	
	@Test
	public void UserRoleMapperTest() {
		List<UserRole> queryAllroles = mapper.queryAllroles(0, 10);
		System.err.println("-----------------");
		System.out.println(queryAllroles.size());
	}
	
	@Test
	public void test() {
		
		
		
		System.err.println("-----------------");
		System.out.println();
	}
}
