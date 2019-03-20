
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
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import cn.soa.dao.UserInfoMapper;
import cn.soa.dao.UserMapper;
import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;
import cn.soa.service.inter.UserServiceInter;
import cn.soa.util.GlobalUtil;
import cn.soa.dao.UserRoleMapper;



	/**
 	 * @ClassName: userService
 	 * @Description: 用户信息服务  - 业务层
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */
@Service
public class UserService implements UserServiceInter{
	private static Logger logger = LoggerFactory.getLogger( UserService.class );

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	
	/**   
	 * @Title: getUsersByNum   
	 * @Description:  根据用户唯一标识查询用户 
	 * @return: UserOrganization        
	 */  
	@Override
	public UserOrganization getUsersByNum( String usernum ) {
		UserOrganization u = null;
		try {
			u = userMapper.findUsersByNum(usernum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return u;
	}
	
	 /**   
	  * @Title: getUserOrganById   
	  * @Description: 根据用户id查询用户信息       
	  * @return: UserOrganization        
	  */ 
	@Override
	public UserOrganization getUserOrganById( String userid ) {
		UserOrganization user = userMapper.findUserById(userid);
		return user;
	}
	
	/**   
	 * @Title: findUsersAll   
	 * @Description:  查询所有用户非组织信息
	 * @param: @return      
	 * @return: List<UserOrganization>        
	 */  
	@Override
	public List<UserOrganization> findUsersAll(){
		List<UserOrganization> users = null;
		try {
			users = userMapper.findUsersAll();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("---S---------查询所有用户非组织信息报错--------users" + users);
			return users;
		}
	}
	
	
	 /**   
	  * @Title: getUserOrganByUsernum   
	  * @Description: 根据用户唯一标示num查询用户        
	  * @return:         
	  */  
	@Override
	public UserOrganization getUserOrganByUsernum( String usernum ) {
		UserOrganization user = userMapper.findUserByUsernum(usernum);
		return user;
	}
	
	
	
	 /**   
	  * @Title: getUserInfoByUserId   
	  * @Description: 根据用户唯一标示userid查询用户信息             
	  * @return: UserInfo        
	  */  
	@Override
	public UserInfo getUserInfoByUserId( String userid ) {
		UserInfo userInfo = userInfoMapper.findUserInfoById(userid);
		return userInfo;
	}
	
	
	/**   
	  * @Title: getUserInfoByUserId   
	  * @Description: 根据用户唯一标示usernum查询用户信息             
	  * @return: UserInfo        
	  */  
	@Override
	public UserInfo getUserInfoByNum( String usernum ) {
		UserInfo userInfo = userInfoMapper.findUserInfoByUsernum(usernum);
		return userInfo;
	}
	
	
	
	
	 /**   
	  * @Title: saveUserServ   
	  * @Description: 新增用户       
	  * @return: int  返回新增用户主键      
	  */  
	@Override
	public String saveOrganServ(UserOrganization user) {
		try {
			int i = userMapper.saveOrganBackId(user);
			//检查插入条数
			if( i < 0 ) {
				return "-1";
			}else if(i == 0){
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "-1";
		}
		
		logger.debug("---S----新增用户---" + user);
		//检查是否返回主键
		if(user.getOrgid() == null || user.getOrgid().toString().isEmpty()) {
			//重新查询
			UserOrganization newUser = userMapper.findUserByUsernum(user.getUsernum());
			//结果判定
			if( newUser.getOrgid() == null || newUser.getOrgid().toString().isEmpty() ) {
				return "0";
			}else {
				return newUser.getOrgid();
			}
		}
		return user.getOrgid();
	}
	
	
	 /**   
	  * @Title: saveUserInfoServ   
	  * @Description: 新增用户信息       
	  * @return: int 返回数据库受影响的条目       
	  */
	@Override
	public int saveUserInfoServ( UserInfo userInfo ) {
		logger.debug("---S----新增用户信息------");
		int i ;
		try {
			i = userInfoMapper.saveUserInfo(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return i;
	}
	
	
	 /**   
	  * @Title: getUserAllListServ   
	  * @Description: 查询所有用户       
	  * @return: UserOrganization        
	  */  
	@Override
	public List<UserOrganization> getUserAllListServ() {
		logger.debug("---S----查询所有 用户------");
		List<UserOrganization> userAll = null;
		try {
			userAll = userMapper.findUserAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userAll;
	}
	
	/**   
	 * @Title: deleteUserAndInfoByNum   
	 * @Description: 根据usernum删除用户
	 * @param: @return      
	 * @return: int        
	 */  
	@Transactional
	@Override
	public int deleteUserByNum( String usernum ) {
		/*
		 * 删除用户
		 */
		int i = deleteUserByNumServ(usernum);
		if( i < 0 ) {
			return -1;
		}else if( i == 0 ){
			return 0;
		}
		return i;
	}
	
	/**   
	 * @Title: deleteUserAndInfoByNum   
	 * @Description: 根据usernum删除用户和用户信息
	 * @param: @return      
	 * @return: int        
	 */  
	@Transactional
	@Override
	public int deleteUserAndInfoByNum( String usernum ) {
		/*
		 * 删除用户
		 */
		int i = deleteUserByNumServ(usernum);
		if( i < 0 ) {
			return -1;
		}else if( i == 0 ){
			return 0;
		}else {
			
		}
		
		/*
		 * 删除用户信息
		 */
		int j = deleteUserInfoByNumServ(usernum);
		
		if( j < 0 ) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}else if( j == 0 ){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}else {
			return j;
		}
	}
	
	 /**   
	  * @Title: deleteUserByNumServ   
	  * @Description:根据usernum删除用户        
	  * @return: int        
	  */  
	@Override
	public int deleteUserByNumServ( String usernum) {
		logger.debug("---S------根据usernum删除用户 ------");
		int i ;
		try {
			i = userMapper.deleteUserByUsernum(usernum);			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return i;
	}

	/**   
	 * @Title: deleteUserInfoByNumServ   
	 * @Description: 根据num删除用户信息 
	 * @param: @param usernum
	 * @param: @return      
	 * @return: int        
	 */  
	@Override
	public int deleteUserInfoByNumServ( String usernum) {
		logger.debug("---S------根据num删除用户信息 ------");
		int i ;
		try {
			i = userInfoMapper.deleteUserInfoByNum(usernum);			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return i;
	}
	
	/**   
	 * @Title: saveUserBackId   
	 * @Description: 根据id增加用户 ，返回id     
	 * @return: int        
	 */  
	@Override
	@Transactional
	public UserOrganization saveUserBackId( String usernum, String name ) {
		int i = 0;
		try {
			/*
			 * 增加用户
			 */
			UserOrganization u = new UserOrganization();
			u.setName(name);
			u.setUsernum(usernum);
			u.setIs_parent(1);
			i = userMapper.saveUserBackId(u);
			if( i > 0) {
				return u;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**   
	 * @Title: getInitOrganServ   
	 * @Description:  获取全部组织数据，并根据用户usernum初始化 数据 
	 * @return: List<UserOrganization>        
	 */  
	@Transactional
	@Override
	public List<Map<String, Object>> getInitOrganServ( String usernum ){
		logger.debug("---S------获取全部组织数据，并根据用户usernum初始化 数据  ------");
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		try {
			//根据usernum用户查询parentid
			UserOrganization currentUser = userMapper.findUserByUsernum(usernum);
			String parentId = currentUser.getParent_id();
			
			//查询组织列表，并赋值
			List<UserOrganization>  organs = userMapper.findUserAll();
			for( UserOrganization u : organs ) {
				Map<String, Object> currentMap = GlobalUtil.changePOJOIntoMap( u );
				logger.debug( currentMap.toString() );
				if( parentId != null && parentId.equals( u.getUsernum() ) ) {
					currentMap.put( "lay_is_radio", true );
					currentMap.put( "lay_is_open", true);
				}
				lists.add(currentMap);
			}
			return lists; 
		} catch (Exception e) {
			e.printStackTrace();	
			return null;
		}
	}
	
	/**   
	 * @Title: modifyUserParentidServ   
	 * @Description: 修改usernum用户 的parentid  
	 * @return: int        
	 */ 
	@Override
	public int modifyUserParentidServ( String usernum, String parentId ) {
		int i = -1;
		try {
			UserOrganization u = new UserOrganization();
			u.setUsernum(usernum);
			u.setParent_id(parentId);
			i = userMapper.modifyUserBynum(u);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**   
	 * @Title: modifyUserByIdServ   
	 * @Description: 根据用户id修改用户信息  
	 * @return: int        
	 */ 
	@Override
	public int modifyUserByIdServ( String orgid, String usernum, String name  ) {
		int i = -1;
		try {
			UserOrganization u = new UserOrganization();
			u.setOrgid(orgid);
			u.setUsernum(usernum);
			u.setName(name);
			i = userMapper.modifyUserById(u);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return i;
	}
}
