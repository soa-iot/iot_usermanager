
/**
 * <一句话功能描述>
 * <p>主页获取数据接口
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.IotIndexInfo;
import cn.soa.entity.ResponseEntity;
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
	 * 
	 * @return
	 */
	@RequestMapping("/getIndexData")
	public UserTableJson<Map<String, Object>> getIndexData() {

		String userName = GlobalUtil.getCookie("name").replaceAll("\"", "");
		System.out.println("登录用户为：" + userName);

		Map<String, Object> result = indexService.getIndexData(userName);
		UserTableJson<Map<String, Object>> resObj = new UserTableJson<Map<String, Object>>("success", 1, "", result, 1,
				true);

		return resObj;
	}

	/**
	 * 保存首页编辑信息
	 * 
	 * @param datas
	 * @return
	 */
	@RequestMapping(value = "/saveIndexEditData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<Integer> saveIndexEditData(@RequestBody List<IotIndexInfo> datas) {
		int result = indexService.saveIndexEditData(datas);
		ResponseEntity<Integer> resObj = new ResponseEntity<Integer>(0, "success", 0, result);

		return resObj;
	}
	
	/**
	 * 获取当前用户角色的首页编辑信息
	 * @return
	 */
	@RequestMapping("/getIndexEditData")
	public ResponseEntity<List<IotIndexInfo>> getIndexEditData(){
		
		List<IotIndexInfo> result = indexService.getIndexEditData();
		ResponseEntity<List<IotIndexInfo>> resObj = new ResponseEntity<List<IotIndexInfo>>(0, "success", result.size(), result);
		
		return resObj;
		
	}

}
