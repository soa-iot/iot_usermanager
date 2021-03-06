
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

import cn.soa.dao.IotUserModuleResourceMapper;
import cn.soa.dao.UserInfoMapper;
import cn.soa.dao.UserMapper;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
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
	
	@Autowired
	private IotUserModuleResourceMapper iotUserModuleResourceMapper;
	
	
	/**   
	 * @Title: getUsersByNum   
	 * @Description:  根据用户唯一标识查询用户 
	 * @return: UserOrganization        
	 */  
	@Override
	public List<UserOrganization> getUsersByNum( String usernum ) {
		List<UserOrganization> u = null;
		try {
			u = userMapper.findUsersByNum(usernum);
			logger.debug("---S---------查询所有用户非组织信息报错--------users" + u.toString());
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
	 * @Title: getUserFirstParentByNum   
	 * @Description:  根据用户唯一标识查询用户上一级父组织  
	 * @return: UserOrganization        
	 */  
	@Override
	public UserOrganization findUserFirstParentByNum( String usernum ) {
		try {
			UserOrganization organ = userMapper.findUserFirstParentByNum( usernum );
			return organ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**   
	 * @Title: findUserSecondParentByNum   
	 * @Description:  根据用户唯一标识查询用户上两级父组织 
	 * @return: UserOrganization        
	 */  
	@Override
	public UserOrganization findUserSecondParentByNum( String usernum ) {
		try {
			UserOrganization organ = userMapper.findUserSecondParentByNum( usernum );
			return organ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**   
	 * @Title: findUserThirdParentByNum   
	 * @Description:  根据用户唯一标识查询用户上三级父组织     
	 * @return: UserOrganization        
	 */ 
	@Override
	public UserOrganization findUserThirdParentByNum( String usernum ) {
		try {
			UserOrganization organ = userMapper.findUserThirdParentByNum( usernum );
			return organ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**   
	 * @Title: getUserFirstParentByNum   
	 * @Description:  根据用户姓名查询用户上一级父组织  
	 * @return: UserOrganization        
	 */  
	@Override
	public UserOrganization findUserFirstParentByName( String usernum ) {
		try {
			UserOrganization organ = userMapper.findUserFirstParentByName( usernum );
			return organ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**   
	 * @Title: findUserSecondParentByNum   
	 * @Description:  根据用户姓名查询用户上两级父组织 
	 * @return: UserOrganization        
	 */  
	@Override
	public UserOrganization findUserSecondParentByName( String usernum ) {
		try {
			UserOrganization organ = userMapper.findUserSecondParentByName( usernum );
			return organ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**   
	 * @Title: findUserThirdParentByNum   
	 * @Description:  根据用户姓名查询用户上三级父组织     
	 * @return: UserOrganization        
	 */ 
	@Override
	public UserOrganization findUserThirdParentByName( String usernum ) {
		try {
			UserOrganization organ = userMapper.findUserThirdParentByName( usernum );
			return organ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	 /**   
	  * @Title: saveUserServ   
	  * @Description: 新增用户       
	  * @return: int  返回新增用户主键      
	  */  
	@Override
	public String saveOrganServ(UserOrganization user) {
		user.setState(1);
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
	 * @Title: modifyUserStateById   
	 * @Description: 根据用户id修改用户状态  
	 * @return: int        
	 */  
	@Override
	public int modifyUserStateById( String id) {
		logger.debug("---S------根据id修改用户状态 ------");
		int i ;
		try {
			i = userMapper.updateUserStateById(id);			
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
	public UserOrganization saveUserBackId( String usernum, String name, String password ) {
		int i = 0;
		try {
			/*
			 * 增加用户
			 */
			UserOrganization u = new UserOrganization();
			u.setName(name);
			u.setState(1);
			u.setUsernum(usernum);
			u.setUser_password(password);
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
			u.setState(1);
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
	public int modifyUserByIdServ( String orgid, String usernum, String name ,String password ) {
		int i = -1;
		try {
			UserOrganization u = new UserOrganization();
			u.setOrgid(orgid);
			u.setUsernum(usernum);
			u.setName(name);
			u.setState(1);
			u.setUser_password(password);
			i = userMapper.modifyUserById(u);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return i;
	}
	
	/**   
	 * @Title: getButtonAuthorityS   
	 * @Description: 获取用户模块对应的按钮权限  
	 * @return: AuthInfo        
	 */  
	@Transactional
	@Override
	public List<IotUserModuleResource> getButtonAuthorityS( String userid, String modId ) {
		List<IotUserModuleResource> authResources = new ArrayList<IotUserModuleResource>();
		try {
			//查找用户角色
			List<UserRole> roles = userRoleMapper.findUserRoleByNum(userid);
			if( roles.size() == 0 ) {
				return null;
			}
			logger.debug("---S------getButtonAuthorityS------" + roles);
			//查找用户权限			
			for( UserRole u : roles ) {
				List<IotUserModuleResource> authResourcesTemp = iotUserModuleResourceMapper.findAuthResourceByRoleid(u.getRolid(), modId);
				authResources.addAll(authResourcesTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		logger.debug("---S------getButtonAuthorityS------" + authResources);
		return authResources;
	}
}
