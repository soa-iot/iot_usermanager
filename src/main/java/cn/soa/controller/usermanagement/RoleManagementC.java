package cn.soa.controller.usermanagement;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleVO;
import cn.soa.entity.headResult.ResultJson;
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
			@ApiImplicitParam(name="roleName", value="角色名称", type="string"),
			@ApiImplicitParam(name="state", value="角色状态", type="int")
	})
	@GetMapping("/role/list")
	public ResponseEntity<List<UserRoleVO>> getUserRoles(String roleName, String state){
		log.info("------进入接口RoleManagementC...getUserRoles------");
		log.info("------角色名称 roleName: {}", roleName);
		log.info("------角色状态 state: {}", state);
		
		List<UserRoleVO> result = roleManagementS.getUserRoles(roleName, state);
		
		if(result == null) {
			return new ResponseEntity<>(1, "查询角色列表信息失败");
		}
		return new ResponseEntity<>(0, "查询角色列表信息成功", result.size(), result);
	}
	
	/**
	 * 更新角色的状态
	 * @param rolid - 角色id
	 * @param state - 角色状态
	 */
	@ApiOperation(value = "更新角色状态")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="rolid", value="角色ID",  required=true, type="string"),
			@ApiImplicitParam(name="state", value="角色状态", type="int", allowableValues="0,1"),
			@ApiImplicitParam(name="name", value="角色名称", type="string")
	})
	@PostMapping("/role/state/update")
	public ResultJson<Boolean> modifyRoleState(@RequestParam String rolid, Integer state, String name){
		log.info("------进入接口RoleManagementC...modifyRoleState------");
		log.info("------角色ID rolid： {}", rolid);
		log.info("------状态  state： {}", state);
		log.info("------角色名称  name： {}", name);
		
		Boolean result = roleManagementS.setRoleState(rolid, state, name);
		
		if(result) {
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "更新角色状态成功", result);
		}
		return new ResultJson<Boolean>(ResultJson.ERROR, "更新角色状态失败", result);

	}
	
	/**
	 * 添加新角色类型
	 * @param role - 角色信息对象
	 */
	@ApiOperation(value = "添加新角色")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="rolid", value="角色ID", type="string"),
			@ApiImplicitParam(name="name", value="角色名称",  required=true, type="string"),
			@ApiImplicitParam(name="state", value="角色状态", required=true, type="int", allowableValues="0,1"),
			@ApiImplicitParam(name="note", value="备注", type="String"),
			@ApiImplicitParam(name="remark1", value="备用字段1", type="String"),
			@ApiImplicitParam(name="remark2", value="备用字段2", type="String"),
	})
	@PostMapping("/role/add")
	public ResultJson<Boolean> addNewRole(UserRole role){
		log.info("------进入接口RoleManagementC...addNewRole------");
		log.info("------新增角色信息 role： {}", role);
		
		Boolean result = roleManagementS.addNewRole(role);
		
		if(result) {
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "添加新角色成功", result);
		}
		return new ResultJson<Boolean>(ResultJson.ERROR, "添加新角色失败", result);

	}
	
	/**
	 * 删除角色类型
	 * @param role - 角色信息对象
	 */
	@ApiOperation(value = "删除角色")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="rolid", value="角色ID列表",  required=true, type="string[]")
	})
	@PostMapping("/role/delete")
	public ResultJson<Boolean> removeRoleType(@RequestBody String[] rolid){
		log.info("------进入接口RoleManagementC...removeRoleType------");
		log.info("------角色ID rolid： {}", Arrays.toString(rolid));
		
		try {
			Boolean result = roleManagementS.removeRoleType(rolid);
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "删除角色成功", result);
		}catch (Exception e) {
			log.info("--{}", e);
			return new ResultJson<Boolean>(ResultJson.ERROR, "删除角色失败", false);
		}

	}
	
	
	/**
	 * 给角色添加资源
	 * @param rolid - 角色id
	 * @param resourceIds - 资源id列表
	 * @return
	 */
	@ApiOperation(value = "给角色添加资源")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="rolid", value="角色ID",  required=true, type="string"),
			@ApiImplicitParam(name="authIds", value="权限id数组",  required=true, type="string[]")
	})
	@PostMapping("/role/add/resource")
	public ResultJson<Boolean> addRoleResource(String rolid, @RequestParam("authIds[]") String[] authIds) {
		log.info("------进入接口RoleManagementC...addRoleResource------");
		log.info("------角色ID rolid： {}", rolid);
		log.info("------权限ID authIds： {}", rolid);
		
		try {
			Boolean result = roleManagementS.insertRoleResource(rolid, authIds);
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "给角色添加资源成功", result);
		}catch (Exception e) {
			log.info("--{}", e);
			return new ResultJson<Boolean>(ResultJson.ERROR, "给角色添加资源失败", false);
		}
	}
	
	/**
	 * 角色关联人员组织
	 * @param rolid - 角色id
	 * @param userids - 人员id
	 * @return
	 */
	@ApiOperation(value = "角色关联人员组织")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="rolid", value="角色ID",  required=true, type="string"),
			@ApiImplicitParam(name="userids", value="人员id数组",  required=true, type="string[]")
	})
	@PostMapping("/role/add/organ")
	public ResultJson<Boolean> addUserRole(String rolid, @RequestParam("userids[]") String[] userids) {
		log.info("------进入接口RoleManagementC...addUserRole------");
		log.info("------角色ID rolid： {}", rolid);
		log.info("------权限ID userids： {}", rolid);
		
		try {
			Boolean result = roleManagementS.insertUserRole(rolid, userids);
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "角色关联人员组织成功", result);
		}catch (Exception e) {
			log.info("--{}", e);
			return new ResultJson<Boolean>(ResultJson.ERROR, "角色关联人员组织失败", false);
		}
	}
}
