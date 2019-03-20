
	/**  
     * @Title: LoginController.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleRelation;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.entity.headResult.UserTableJson;
import cn.soa.service.impl.RoleService;
import cn.soa.service.inter.RoleServiceInter;
import cn.soa.service.inter.UserServiceInter;
import cn.soa.util.GlobalUtil;

/**
  * @ClassName: LoginController
  * @Description: 角色 - 控制层
  * @author zhugang
  * @date 2019年1月12日
  */

@RestController
@RequestMapping("/role")
public class RoleController{
	@Autowired
	private RoleService roleService;
	private static Logger logger = LoggerFactory.getLogger( RoleController.class );
	
	@RequestMapping("/roles")
	public UserTableJson<List<UserRole>> queryAllroles(@RequestParam(value="page",required = false) Integer page ,@RequestParam(value="limit",required = false) Integer limit) {
		return new UserTableJson<List<UserRole>>("",0,"",roleService.queryAllroles(page, limit),roleService.countRoles(),true);
	}
	@RequestMapping("/addOrUpdateRole")
	public ResultJson addOrUpdateRoles(UserRole userRole) {
		String rid=userRole.getRolid();
		int modifyCount=-1;
		if(rid==null||rid.equals("")) {
			modifyCount=roleService.saveUserRole(userRole);
		}else {
			modifyCount=roleService.modifyUserRoleById(userRole);
		}
		if(modifyCount>0) {
			return new ResultJson(0,"角色操作成功");
		}
		return new ResultJson(1,"角色操作失败");
		
	}
	/**
	 * 批量删除角色
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteRoles")
	public ResultJson deleteRoles(@RequestParam("ids")String  ids) {
		List<String> lists=new ArrayList<String>();
		String[] role_ids=ids.split(",");
		int count=roleService.deleteRolesInIds(role_ids);
		if(count>0) {
			return new ResultJson(0);
		}
		return new ResultJson(1);
	}

	@RequestMapping("/queryUsersByRold")
	public ResultJson queryUsersByRold(String rolid) {
		List<Map<String, Object>> list = roleService.queryUsersByRold(rolid);
		logger.debug("---C-----queryUsersByRold----------:" + list );
		return new ResultJson(list);
		
	}
	/**
	 * 管理用户和角色的关系
	 * @param ids
	 * @return
	 */
	@RequestMapping("/addOrUpdateUserRole")
	@Transactional
	public ResultJson<Integer> addOrUpdateUserRole( @RequestParam("list[]") List<String> list ,String rolid ) {
		List<UserRoleRelation> lists =new ArrayList<UserRoleRelation>();
		int delte=roleService.deleteUserUserAndRolebyId(rolid);
		if(list.size()>1) {
			for(int i=1;i<list.size();i++) {
				lists.add(new UserRoleRelation(list.get(i),rolid));
			}
			int i=roleService.saveUserUserRoleInBatch(lists);
		}
		//批量插入用户
		
		if(delte>0) {
			return  new ResultJson(1);
		}
		return  new ResultJson(0);
	}
}
