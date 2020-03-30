
	/**  
     * @Title: userService.java
 	 * @Package cn.userCenter.service.impl
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.UserLogMapper;
import cn.soa.dao.UserRoleMapper;
import cn.soa.entity.AuthInfo;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.UserLog;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleRelation;
import cn.soa.service.inter.RoleServiceInter;
import cn.soa.service.inter.UserLogService;


	/**
 	 * @ClassName: userService
 	 * @Description: 用户信息服务  - 业务层
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */
@Service
public class UserLogServiceImpl implements UserLogService{
	private static Logger logger = LoggerFactory.getLogger( UserLogServiceImpl.class );	
	
	@Autowired
	private UserLogMapper logMapper;

	@Override
	public int save(UserLog userLog) {
		// TODO Auto-generated method stub
		return logMapper.insert(userLog);
	}
	
	@Override
	public List<UserLog> getUserLogList(String username,String dateTime) {
		// TODO Auto-generated method stub
		List<UserLog> ligList=logMapper.getUserLogList(username,dateTime);
		return ligList;
	}

	@Override
	public List<Map<String, Object>> getLogCount(String username, String dateTime) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> ligList=logMapper.getLogCount(username,dateTime);
		logger.info("=="+ligList.toString());
		return ligList;
	}

	@Override
	public List<Map<String, Object>> getLogCountAsc(String username, String dateTime) {
		List<Map<String, Object>> ligList=logMapper.getLogCountAsc(username, dateTime);
		logger.info("=="+ligList.toString());
		return ligList;
	}

	@Override
	public List<Map<String, Object>> getLogCountDesc(String username, String dateTime) {
		List<Map<String, Object>> ligList=logMapper.getLogCountDesc(username, dateTime);
		logger.info("=="+ligList.toString());
		return ligList;
	}
	
}
