
/**
 * <一句话功能描述>
 * <p>主页获取数据接口
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.headResult.UserTableJson;
import cn.soa.service.inter.IndexServiceInter;
import cn.soa.util.GlobalUtil;

@RestController
@RequestMapping("/index")
public class IndexController {
	
	
	@Autowired
	private IndexServiceInter indexService;
	/**
	 * 获取首页初始化数据
	 * @return
	 */
	@RequestMapping("/getIndexData")
	public UserTableJson<Map<String,Object>> getIndexData(){
		
		String userName =  GlobalUtil.getCookie("name").replaceAll("\"", "");
		System.out.println("登录用户为："+userName);
		
		Map<String,Object> result = indexService.getIndexData(userName);
		UserTableJson<Map<String,Object>> resObj = new UserTableJson<Map<String,Object>>("success", 1, "", result, 1, true);
		
		return resObj;
	}
	

}
