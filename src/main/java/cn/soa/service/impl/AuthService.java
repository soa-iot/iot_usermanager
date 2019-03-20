
	/**  
     * @Title: userService.java
 	 * @Package cn.userCenter.service.impl
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.UserRoleMapper;
import cn.soa.entity.UserRole;
import cn.soa.service.inter.AuthServiceInter;
import cn.soa.service.inter.RoleServiceInter;


	/**
 	 * @ClassName: userService
 	 * @Description: 权限信息服务  - 业务层
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */
@Service
public class AuthService implements AuthServiceInter{
	private static Logger logger = LoggerFactory.getLogger( AuthService.class );	
	
	
	
}
