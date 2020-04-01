package cn.soa.controller.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserRoleVO;
import cn.soa.service.inter.usermanagement.RoleManagementSI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 角色限管理控制层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
@RestController
@Slf4j
@Api(value = "角色信息管理", tags="角色信息管理")
public class RoleManagementC {
	
	@Autowired
	private RoleManagementSI roleManagementS;
	
	/**
	 * 查询角色列表信息
	 */
	//@MyLog(value = "查询所有的权限资源信息")
	@ApiOperation(value = "查询角色列表信息")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="roleName", value="角色名称", type="string")
	})
	@GetMapping("/role/list")
	public ResponseEntity<List<UserRoleVO>> getUserRoles(String roleName){
		log.info("------进入接口RoleManagementC...getUserRoles------");
		
		List<UserRoleVO> result = roleManagementS.getUserRoles(roleName);
		
		if(result == null) {
			return new ResponseEntity<>(1, "查询角色列表信息失败");
		}
		return new ResponseEntity<>(0, "查询角色列表信息成功", result.size(), result);
	}
}
