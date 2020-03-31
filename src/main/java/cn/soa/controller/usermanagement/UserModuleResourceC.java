package cn.soa.controller.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.config.MyLog;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.service.inter.usermanagement.UserManagementSI;
import cn.soa.service.inter.usermanagement.UserModuleResourceSI;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.extern.slf4j.Slf4j;

/**
 * 菜单管理控制层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
@RestController
@Slf4j
public class UserModuleResourceC {
	
	@Autowired
	private UserModuleResourceSI userModuleResourceS;
	
	/**
	 * 查询所有的权限资源信息
	 */
	@MyLog(value = "查询所有的权限资源信息")
	@ApiOperation(value = "查询所有的权限资源信息")
	@ApiResponse(code = 200, response=IotUserModuleResource.class,  message = "success", 
				 examples = @Example(
						 value = { @ExampleProperty(value = "code", mediaType = "int"),
								   @ExampleProperty(value = "msg", mediaType = "string"),
								   @ExampleProperty(value = "code", mediaType = "int"),
								   @ExampleProperty(value = "count", mediaType = "list")}))
	@RequestMapping("/resource/list/all")
	public ResponseEntity<List<IotUserModuleResource>> getAllResources(){
		log.info("------进入接口UserModuleResourceC...getAllResources------");
		
		List<IotUserModuleResource> result = userModuleResourceS.getAllResources();
		
		if(result == null) {
			return new ResponseEntity<>(1, "查询权限资源信息失败");
		}
		return new ResponseEntity<>(0, "查询权限资源信息成功", result.size(), result);
	}
	
}
