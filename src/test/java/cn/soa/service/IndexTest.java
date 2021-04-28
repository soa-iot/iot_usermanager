
/**
 * <一句话功能描述>
 * <p>
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.soa.IotUsermanagerApplication;
import cn.soa.service.inter.IndexServiceInter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotUsermanagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IndexTest {
	
	@Autowired
	private IndexServiceInter service;
	
	@Test
	public void test() {
		service.getIndexData("admin");
		System.out.println("??????????");
	}

}
