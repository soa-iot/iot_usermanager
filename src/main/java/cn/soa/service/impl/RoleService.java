
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

import cn.soa.dao.UserRoleMapper;
import cn.soa.entity.AuthInfo;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleRelation;
import cn.soa.service.inter.RoleServiceInter;


	/**
 	 * @ClassName: userService
 	 * @Description: 用户信息服务  - 业务层
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */
@Service
public class RoleService implements RoleServiceInter{
	private static Logger logger = LoggerFactory.getLogger( RoleService.class );	
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	
	 /**   
	  * @Title: getUserRoleByUserid   
	  * @Description: 根据用户id查询用户具有的角色           
	  * @return: UserRole        
	  */  
	@Override
	public List<UserRole> getUserRoleByNum( String usernum ) {
		List<UserRole> userRoles = userRoleMapper.findUserRoleByNum(usernum);
		return userRoles;
	}	
	
	
	/**   
	 * @Title: findAuthJsonServ   
	 * @Description:  根据用户角色id查询用户具有的权限    
	 * @return: ArrayList<IotUserModuleResource>        
	 */  
	@Override
	public ArrayList<IotUserModuleResource> findAuthJsonServ( String rolid){
		/*
		 * 查询权限
		 */
		ArrayList<IotUserModuleResource> auths = null;
		try {
			auths = userRoleMapper.findAuthByRolid(rolid);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("--------根据用户角色id查询用户具有的权限  findAuthJsonServ--------出错");
			return null;
		}
		return auths;
	}

	
	/**   
	 * @Title: findAuthByRolidServ   
	 * @Description: 根据用户角色id查询用户具有的权限    
	 * @param: @param rolid
	 * @param: @return      
	 * @return: ArrayList<IotUserModuleResource>        
	 */ 
	@Override
	public ArrayList<AuthInfo> findAuthByRolidServ( String rolid){
		/*
		 * 查询权限
		 */
		ArrayList<IotUserModuleResource> auths = null;
		try {
			auths = userRoleMapper.findAuthByRolid(rolid);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("--------根据用户角色id查询用户具有的权限  findAuthByRolidServ--------出错");
			return null;
		}
		logger.debug( "--S--------根据用户角色id查询用户具有的权限   -----auths:" );
		logger.debug( auths.toString());
		 
		 /*
		  * 运算赋值
		  */
		ArrayList<IotUserModuleResource> tempAuths = new ArrayList<IotUserModuleResource>();
		ArrayList<AuthInfo> authInfos = new ArrayList<AuthInfo>();
		if( auths != null ) {
			for( IotUserModuleResource i : auths) {
				if( "-1".equals(i.getParentId())) {
					tempAuths.add(i);
					AuthInfo authInfo = new AuthInfo();
					authInfo.setId( i.getModId() );
					authInfo.setFirst(i.getName());
					authInfos.add(authInfo);
				}			
			}
			logger.debug( "--S--------根据用户角色id查询用户具有的权限   -----tempAuths:" );
			logger.debug( tempAuths.toString());
			
			for( IotUserModuleResource i : auths) {
				String pid = i.getParentId();
				if(  pid != null && pid != "-1" ) {
					for( int j = 0; j < tempAuths.size() ; j++ ) {
						if( pid.equals( tempAuths.get(j).getModId() ) ) {
							AuthInfo currentAuth = authInfos.get(j);
							String a = currentAuth.getSecond();
							//设置名称
							if( a == null ) {
								currentAuth.setSecond( i.getName() );
							}else {
								if( i.getName() == null  ) {
									currentAuth.setSecond( a + "," + " " );
								}else {
									currentAuth.setSecond( a + "," + i.getName() );
								}							 
							}
							
							//设置url
							String url = currentAuth.getUrl();
							//设置名称
							if( url == null ) {
								currentAuth.setUrl( i.getUrl() );
							}else {
								if( i.getUrl() == null  ) {
									currentAuth.setUrl( url + "," + " " );
								}else {
									currentAuth.setUrl( url + "," + i.getUrl() );
								}
							}
							
							break;
						}
					}			
				}
			}
			logger.debug( "--S--------根据用户角色id查询用户具有的权限   -----AuthInfo" );
			logger.debug( authInfos.toString());						
			return authInfos;
		}	
		return authInfos;
	}

	@Override
	public List<UserRole> queryAllroles(Integer page, Integer pageSize) {
		if(page==null || pageSize==null) {
			page=0;
			pageSize=0;
		}
		return userRoleMapper.queryAllroles((page-1)*pageSize,page*pageSize);
	}


	@Override
	public int countRoles() {
		// TODO A.uto-generated method stub
		return userRoleMapper.countRoles();
	}


	@Override
	public int saveUserRole(UserRole userRole) {
		
		return userRoleMapper.saveUserRole(userRole);
	}


	@Override
	public int modifyUserRoleById(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleMapper.modifyUserRoleById(userRole);
	}


	@Override
	public int deleteRolesInIds(String[] ids) {
		// TODO Auto-generated method stub
		return userRoleMapper.deleteRolesInIds(ids);
	}


	@Override
	public List<Map<String ,Object>> queryUsersByRold(String ROLID) {
		List<UserOrganization> orgs=userRoleMapper.queryAllorgnInfo();
		logger.debug("---S-----queryUsersByRold----------:" + orgs );
		List<UserOrganization> orgsByid=userRoleMapper.queryUsersByRold(ROLID);
		System.out.println(orgsByid.toString());
		List<Map<String ,Object>> lists=new ArrayList<Map<String ,Object>>();
		for( UserOrganization org:orgs) {
			Map<String,Object> map=new HashMap<>();
			map.put("name",org.getName());
			map.put("orgid",org.getOrgid());
			map.put("is_parent",org.getIs_parent());
			map.put("usernum",org.getUsernum());
			map.put("parent_id",org.getParent_id());
			if(org.getUsernum().equals("0")) {
				map.put("open", true);
			}
			if( !orgsByid.isEmpty() ) {
				for(int i=0;i<orgsByid.size();i++) {
					if(org.getName().equals(orgsByid.get(i).getName())) {
						map.put("checked", true);
					};						
				}
			}
			
			lists.add(map);
		}		
		return lists;
	}



	@Override
	public int deleteUserUserAndRolebyId(String rolid) {
		// TODO Auto-generated method stub
		return  userRoleMapper.deleteUserUserAndRolebyId(rolid);
	}


	@Override
	 public int saveUserUserRoleInBatch(List<UserRoleRelation> lists) {
		return userRoleMapper.saveUserUserRoleInBatch(lists);
		
	}


	
}
