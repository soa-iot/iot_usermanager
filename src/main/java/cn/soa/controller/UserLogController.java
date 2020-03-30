
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
import java.util.Date;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.config.MyLog;
import cn.soa.entity.RoleAuthority;
import cn.soa.entity.UserLog;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.entity.headResult.UserTableJson;
import cn.soa.service.inter.RoleServiceInter;
import cn.soa.service.inter.UserLogService;
import cn.soa.service.inter.UserServiceInter;
import cn.soa.util.GlobalUtil;
import io.swagger.annotations.ApiOperation;

/**
  * @ClassName: LoginController
  * @Description: 登录 - 控制层
  * @author zhugang
  * @date 2019年1月12日
  */

@RestController
@RequestMapping("/userLog")
public class UserLogController{
	private static Logger logger = LoggerFactory.getLogger( UserLogController.class );

	
	@Autowired
	private UserLogService logService;
	
	@ApiOperation(value = "查询日志")
	@RequestMapping("/getUserLogList")
	public UserTableJson<List<UserLog>> getAuthorityInfo(HttpServletRequest request) {
		//用户名称
		String username=request.getParameter("username");
		//日期
		String dateTime=request.getParameter("dateTime");
		logger.info("username==="+username);
		logger.info("dateTime==="+dateTime);
		List<UserLog> authorityInfo = logService.getUserLogList(username,dateTime);
		logger.info(authorityInfo.toString());
		UserTableJson<List<UserLog>> reObj = new UserTableJson<List<UserLog>>("success", 0, "查询成功",
				authorityInfo, authorityInfo.size(), true);
		return reObj;
	}
/**
 * 人员登录统计
 * @param request
 * @return
 */
	@RequestMapping("/getLogCount")
	public UserTableJson<List<Map<String, Object>>> getLogCount(HttpServletRequest request) {
		//用户名称
		String username=request.getParameter("username");
		//日期
		String dateTime=request.getParameter("dateTime");
		
		logger.info("username==="+username);
		logger.info("dateTime==="+dateTime);
		List<Map<String, Object>> authorityInfo = logService.getLogCount(username,dateTime);
		logger.info(authorityInfo.toString());
		UserTableJson<List<Map<String, Object>>> reObj = new UserTableJson<List<Map<String, Object>>>("success", 0, "查询成功",
				authorityInfo, authorityInfo.size(), true);
		return reObj;
	}
	
	/**
	 * 人员登录统计
	 * @param request
	 * @return
	 */
		@RequestMapping("/getLogCountAsc")
		public UserTableJson<List<Map<String, Object>>> getLogCountAsc(HttpServletRequest request) {
			//用户名称
			String username=request.getParameter("username");
			//日期
			String dateTime=request.getParameter("dateTime");
			logger.info("username==="+username);
			logger.info("dateTime==="+dateTime);
			List<Map<String, Object>> authorityInfo = logService.getLogCountAsc(username,dateTime);
			logger.info(authorityInfo.toString());
			UserTableJson<List<Map<String, Object>>> reObj = new UserTableJson<List<Map<String, Object>>>("success", 0, "查询成功",
					authorityInfo, authorityInfo.size(), true);
			return reObj;
		}
	
		/**
		 * 人员登录统计
		 * @param request
		 * @return
		 */
			@RequestMapping("/getLogCountDesc")
			public UserTableJson<List<Map<String, Object>>> getLogCountDesc(HttpServletRequest request) {
				//用户名称
				String username=request.getParameter("username");
				//日期
				String dateTime=request.getParameter("dateTime");
				logger.info("username==="+username);
				logger.info("dateTime==="+dateTime);
				List<Map<String, Object>> authorityInfo = logService.getLogCountDesc(username,dateTime);
				logger.info(authorityInfo.toString());
				UserTableJson<List<Map<String, Object>>> reObj = new UserTableJson<List<Map<String, Object>>>("success", 0, "查询成功",
						authorityInfo, authorityInfo.size(), true);
				return reObj;
			}
	
}
