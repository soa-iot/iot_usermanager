/**  
 * @Title: RoleServiceInter.java
 * @Package cn.userCenter.service.inter
 * @Description: )
 * @author zhugang
 * @date 2019年1月24日
 * @version V1.0  
 */

        
package cn.soa.service.inter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.soa.entity.AuthInfo;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleRelation;


/**
  * @ClassName: RoleServiceInter
  * @Description: 
  * @author zhugang
  * @date 2019年1月24日
  */

public interface RoleServiceInter {

	 /**   
	  * @Title: getUserRoleByUserid   
	  * @Description: 根据用户id查询用户具有的角色                 
	  * @return: List<UserRole>        
	  */  
	List<UserRole> getUserRoleByNum(String usernum);
	
    List<UserRole> queryAllroles(Integer page, Integer pageSize);
    
    /**
	 * @Title: queryRolesByName 
	 * @Description: 根据角色名称的角色信息分页查询  
	 * @return List<UserRole>
	 */
    List<UserRole> queryRolesByName(Integer page, Integer pageSize,String roleName );
    
    int countRoles();
    int countRolesByName(String roleName);
    public int saveUserRole( UserRole userRole);
    public int modifyUserRoleById(UserRole userRole);
    public int deleteRolesInIds(String[] ids );
    /**
	 * @Title: queryUsersByRold 
	 * @Description: 根据角色id，查询对应角色下的用户
	 * @return List
	 */
	public List<Map<String ,Object>> queryUsersByRold(@Param("ROLID") String ROLID );

	/**   
	 * @Title: findAuthByRolidServ   
	 * @Description: 根据用户角色id查询用户具有的权限      
	 * @param: @param rolid
	 * @param: @return      
	 * @return: ArrayList<AuthInfo>        
	 */  
	ArrayList<AuthInfo> findAuthByRolidServ(String rolid);

    /**
	 * @Title: queryUsersByRold 
	 * @Description: 批量删除用户角色关系
	 * @return List
	 */
	  public int deleteUserUserAndRolebyId(String rolid );
	   /**
		 * @Title: queryUsersByRold 
		 * @Description: 批量增加用户角色关系
		 * @return List
		 */
	
	public int saveUserUserRoleInBatch(List<UserRoleRelation> lists);

	/**   
	 * @Title: findAuthJsonServ   
	 * @Description:  根据用户角色id查询用户具有的权限  
	 * @return: ArrayList<IotUserModuleResource>        
	 */  
	ArrayList<IotUserModuleResource> findAuthJsonServ(String rolid);

	/**   
	 * @Title: findUsersById   
	 * @Description: 根据角色id查询对应的所有用户   
	 * @return: List<UserOrganization>        
	 */  
	List<UserOrganization> findUsersById(String roleid);

	/**   
	 * @Title: findUsersByName   
	 * @Description: 根据角色名称查询对应的所有用户       
	 * @return: List<UserOrganization>        
	 */  
	List<UserOrganization> findUsersByName(String rolename);
	
	/** 
	  * @Title: findUserRoleByRoleName 
	  * @Description: 根据用户角色id查找角色名称
	  */
	public UserRole getUserRoleByRoleName(String rolid);

	/**   
	 * @Title: getUserMenoRoleByNum   
	 * @Description:  根据用户id查询用户具有的菜单角色            
	 * @return: List<UserRole>        
	 */  
	List<UserRole> getUserMenoRoleByNum(String usernum);
}
