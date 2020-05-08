package cn.soa.controller.usermanagement;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.config.MyLog;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.ResourceTree;
import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.service.inter.usermanagement.UserManagementSI;
import cn.soa.service.inter.usermanagement.UserModuleResourceSI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.extern.slf4j.Slf4j;

/**
 * 菜单资源权限管理控制层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
@RestController
@Slf4j
@Api(value = "菜单资源权限信息管理", tags="菜单资源权限信息管理")
public class UserModuleResourceC {
	
	@Autowired
	private UserModuleResourceSI userModuleResourceS;
	
	/**
	 * 查询所有的权限资源信息
	 */
	//@MyLog(value = "查询所有的权限资源信息")
	@ApiOperation(value = "查询所有的权限资源信息")
	@GetMapping("/resource/list/all")
	public ResponseEntity<List<IotUserModuleResource>> getAllResources(){
		log.info("------进入接口UserModuleResourceC...getAllResources------");
		
		List<IotUserModuleResource> result = userModuleResourceS.getAllResources();
		
		if(result == null) {
			return new ResponseEntity<>(1, "查询权限资源信息失败", 0, null);
		}
		return new ResponseEntity<>(0, "查询权限资源信息成功", result.size(), result);
	}
	
	/**
	 * 获取菜单资源信息树
	 */
	//@MyLog(value = "查询所有的权限资源信息")
	@ApiOperation(value = "获取菜单资源信息树")
	@GetMapping("/resource/tree")
	public ResponseEntity<List<ResourceTree>> getResourceTree(){
		log.info("------进入接口UserModuleResourceC...getResourceTree------");
		
		List<ResourceTree> result = userModuleResourceS.getResourceTree();
		
		if(result.size() != 0) {
			return new ResponseEntity<>(0, "获取菜单资源信息成功", result.size(), result);
		}
		return new ResponseEntity<>(1, "获取菜单资源信息失败", 0, null);
	}
	
	/**
	 * 添加菜单资源信息
	 */
	//@MyLog(value = "添加菜单资源信息")
	@ApiOperation(value = "添加菜单资源信息")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="name", value="资源名称", required=true, type="string"),
			@ApiImplicitParam(name="url", value="资源URL", type="string"),
			@ApiImplicitParam(name="describe", value="资源描述", type="string"),
			@ApiImplicitParam(name="type", value="资源类型", allowableValues="1, 2, 3", required=true, type="int"),
			@ApiImplicitParam(name="remark1", value="资源排序号", required=true, type="int"),
			@ApiImplicitParam(name="parentId", value="资源父ID", required=true, type="string"),
			@ApiImplicitParam(name="isParent", value="是否是父资源", allowableValues="0, 1", required=true, type="int"),
			@ApiImplicitParam(name="menuIcon", value="资源图标", required=true, type="string")
	})
	@PostMapping("/resource/add")
	public ResultJson<Boolean> addModuleResource(IotUserModuleResource resource){
		log.info("------进入接口UserModuleResourceC...addModuleResource------");
		log.info("------菜单资源信息 resource: {}", resource);
		
		try {
			Boolean result = userModuleResourceS.addModuleResource(resource);
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "添加菜单资源信息成功", result);
		}catch (Exception e) {
			log.info("--{}", e);
			return new ResultJson<Boolean>(ResultJson.ERROR, "添加菜单资源信息失败", false);
		}
		
	}
	
	/**
	 * 修改菜单资源信息
	 */
	//@MyLog(value = "修改菜单资源信息")
	@ApiOperation(value = "修改菜单资源信息")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="modId", value="资源主键ID", required=true, type="string"),
			@ApiImplicitParam(name="name", value="资源名称", type="string"),
			@ApiImplicitParam(name="url", value="资源URL", type="string"),
			@ApiImplicitParam(name="describe", value="资源描述", type="string"),
			@ApiImplicitParam(name="type", value="资源类型", allowableValues="1, 2, 3", type="int"),
			@ApiImplicitParam(name="remark1", value="资源排序号",  type="int"),
			@ApiImplicitParam(name="parentId", value="资源父ID", type="string"),
			@ApiImplicitParam(name="isParent", value="是否是父资源", allowableValues="0, 1", type="int"),
			@ApiImplicitParam(name="menuIcon", value="资源图标", type="string")
	})
	@PostMapping("/resource/edit")
	public ResultJson<Boolean> modifyModuleResource(IotUserModuleResource resource){
		log.info("------进入接口UserModuleResourceC...modifyModuleResource------");
		log.info("------菜单资源信息 resource: {}", resource);
		
		Boolean result = userModuleResourceS.setModuleResource(resource);
		
		if(result) {
			return new ResultJson<Boolean>(ResultJson.SUCCESS, "修改菜单资源信息成功", result);
		}
		return new ResultJson<Boolean>(ResultJson.ERROR, "修改菜单资源信息失败", result);
	}
	
	/**
	 * 删除菜单资源信息
	 */
	//@MyLog(value = "删除菜单资源信息")
	@ApiOperation(value = "删除菜单资源信息")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="modId", value="资源ID", required=true, type="string"),
			@ApiImplicitParam(name="parentId", value="父资源ID", required=true, type="string")
	})
	@PostMapping("/resource/remove")
	public ResultJson<Boolean> deleteModuleResource(@RequestParam String modId, @RequestParam String parentId){
		log.info("------进入接口UserModuleResourceC...deleteModuleResource------");
		log.info("------菜单资源ID modId: {}", modId);
		log.info("------父资源ID parentId: {}", parentId);
		
		try {
			Boolean result = userModuleResourceS.removeModuleResource(modId, parentId);
			if(result){
				return new ResultJson<Boolean>(ResultJson.SUCCESS, "删除资源信息成功", result);
			}
			return new ResultJson<Boolean>(ResultJson.ERROR, "该资源是父级资源，无法删除", result);
		}catch (Exception e) {
			return new ResultJson<Boolean>(ResultJson.ERROR, "删除资源信息失败", false);
		}
	}
	
	/**
	 * 通过角色ID查询其拥有的菜单资源ID
	 */
	//@MyLog(value = "查询所有的权限资源信息")
	@ApiOperation(value = "查询角色拥有的菜单资源ID")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="rolid", value="角色ID", required=true, type="string")
	})
	@GetMapping("/resource/role/ids")
	public ResponseEntity<List<String>> getRoleResourceId(String rolid){
		log.info("------进入接口UserModuleResourceC...getRoleResourceId------");
		log.info("------角色ID rolid: {}", rolid);
		
		List<IotUserModuleResource> result = userModuleResourceS.getResources(rolid);
		
		if(result != null) {
			List<String> resourceIds = new LinkedList<String>();
			for(IotUserModuleResource resource : result) {
				resourceIds.add(resource.getAuthId());
			}
			return new ResponseEntity<>(0, "获取角色拥有的菜单资源成功", resourceIds.size(), resourceIds);
		}
		
		return new ResponseEntity<>(1, "获取角色拥有的菜单资源失败", 0, null);
	}
}
