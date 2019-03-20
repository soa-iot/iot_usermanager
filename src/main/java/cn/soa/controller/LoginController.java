
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.service.inter.RoleServiceInter;
import cn.soa.service.inter.UserServiceInter;
import cn.soa.util.GlobalUtil;

/**
  * @ClassName: LoginController
  * @Description: 登录 - 控制层
  * @author zhugang
  * @date 2019年1月12日
  */

@RestController
@RequestMapping("/user")
public class LoginController{
	private static Logger logger = LoggerFactory.getLogger( LoginController.class );

	@Autowired
	private UserServiceInter userService;
	
	@Autowired
	private RoleServiceInter roleService;
	
	
	 /**   
	  * @Title: loginContr   
	  * @Description: 登录验证       
	  * @return: ResultJson<String>        
	  */  
	@GetMapping( "/{userName}/{userPassword}")
	public ResultJson<String> loginContr(@PathVariable("userName") @NotBlank String userName,
			@PathVariable("userPassword") @NotBlank String userPassword){
		logger.debug("-------C----------开始登陆-----------");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), userPassword.trim());
		ResultJson<String> resultJson = null;
		try {
			subject.login(token);
			/*
			 * 设置cookie
			 */
			//设置用户			
			GlobalUtil.addCookie( "num", userName );
			//设置角色
			List<UserRole> userRoles = new ArrayList<UserRole>();
			userRoles = roleService.getUserRoleByNum(userName.trim());
			String roles = "";
			logger.debug("-------userRoles:-----------" + userRoles );
			if( userRoles != null && userRoles.get(0) != null ) {
				for( UserRole u : userRoles) {
					if( roles != null && roles.isEmpty() ) {
						roles = u.getName();
					}
					roles = roles + "," + u.getName();
				}
				GlobalUtil.addCookie( "role", roles );
			}		
			
			//设置组织			
			UserOrganization user = userService.getUserOrganByUsernum( userName.trim() );
			if( user != null ) {
				GlobalUtil.addCookie( "organ", user.getParent_id() );
			}
			
			resultJson = new ResultJson<String>(0, "登录成功", subject.getSession().getId() + "");
		} catch (IncorrectCredentialsException e) {
			resultJson = new ResultJson<String>(0, "密码错误", null);
		} catch (DisabledAccountException e) {
			resultJson = new ResultJson<String>(0, "登录失败，该用户已被冻结", null);
		} catch (UnknownAccountException e) {
			resultJson = new ResultJson<String>(0, "该用户不存在", null);
		} catch (AuthenticationException e) {
			resultJson = new ResultJson<String>(0, "登录认证失败，错误信息", null);
		} catch (Exception e) {
			e.printStackTrace();
			resultJson = new ResultJson<String>(0, "登录失败，未知错误" , null );
		}
		return resultJson;
	}
	
	
	@PostMapping("/logout")
	public ResultJson<String> logoutContr( HttpSession session ){
		logger.info("-------C----------退出登陆-----------");
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.logout();
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("-------C----------退出登陆错误-----------");
			return new ResultJson<String>( 1, "退出失败", null );
		}	    
	    return new ResultJson<String>( 302, "退出成功", "/html/userCenter/login.html" );
	}

}
