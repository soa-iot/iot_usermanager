/**  
 * @Title: userMapper.java
 * @Package cn.userCenter.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月9日
 * @version V1.0  
 */

        
package cn.soa.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserRoleRelation;


/**
 * @ClassName: userMapper
 * @Description: 用户数据dao层
 * @author zhugang
 * @date 2019年1月9日
 *
 */

@Mapper
public interface UserRoleMapper {
	
	 /** 
	  * @Title: findUserRoleById 
	  * @Description: 根据用户角色id查找用户角色
	  */
	public UserRole findUserRoleById(@Param("rolid") int rolid);
	

	 /**   
	  * @Title: findUserRoleByUserId   
	  * @Description: 根据用户id查询用户具有的角色    
	  * @return: UserRole        
	  */  
	public List<UserRole> findUserRoleByNum(@Param("usernum") String usernum);
	
	
	 /**   
	  * @Title: saveUserRole   
	  * @Description: 增加用户角色信息       
	  * @return: int        
	  */  
	public int saveUserRole(@Param("userRole") UserRole userRole);
	
	
	 /**   
	  * @Title: saveUserRoleInBatch   
	  * @Description:  批量增加用户角色信息 （对象以下属性值不能为null）
	  * @return: int        
	  */  
	public int saveUserRoleInBatch(@Param("userRoles") List<UserRole> userRoles);
	 
	
	 /**   
	  * @Title: modifyUserRoleById   
	  * @Description: 根据角色id修改用户角色信息     
	  * @return: int        
	  */  
	public int modifyUserRoleById(@Param("userRole") UserRole userRole);
	
	
	 /**   
	  * @Title: deleteUserRoleById   
	  * @Description:  根据角色id删除用户角色信息      
	  * @return: int        
	  */  
	public int deleteUserRoleById(@Param("rolid") int rolid);
	
	
	 /**   
	  * @Title: saveUserAndRoleById   
	  * @Description: 根据用户id、用户角色id，增加关联关系       
	  * @return: int        
	  */  
	public int saveUserAndRoleById(@Param("userid") int userid, 
			@Param("rolid") int rolid);
	
	
	 /**   
	  * @Title: saveUserAndRoleByObjects   
	  * @Description: 根据用户对象、用户角色对象，增加关联关系       
	  * @return: int        
	  */  
	public int saveUserAndRoleByObjects(@Param("user") UserOrganization user, 
			@Param("userRole") UserRole userRole);
	
	
	 /**   
	  * @Title: deleteUserAndRoleById   
	  * @Description: 根据用户id、用户角色id，删除关联关系       
	  * @return: int        
	  */  
	public int deleteUserAndRoleById(@Param("userid") String userid, 
			@Param("rolid") String rolid);
	
	
	 /**   
	  * @Title: deleteUserAndRoleByObjects   
	  * @Description: 根据用户对象、用户角色对象，删除关联关系      
	  * @return: int        
	  */  
	public int deleteUserAndRoleByObjects(@Param("user") UserOrganization user, 
			@Param("userRole") UserRole userRole);
	
	/**
	 * @Title: queryAllroles 
	 * @Description: 角色信息分页查询  
	 * @return List<UserRole>
	 */
	public List<UserRole> queryAllroles(@Param("first")Integer page, @Param("last")Integer pageSize);
	/**
	 * @Title: countRoles 
	 * @Description: 角色数量统计
	 * @return int
	 */
	public int countRoles();
	/**
	 * @Title: countRoles 
	 * @Description: 角色数量统计
	 * @return int
	 */
	public int deleteRolesInIds(@Param("ids")String[] ids);
	/**
	 * @Title: queryUsersByRold 
	 * @Description: 根据角色id，查询对应角色下的用户
	 * @return List
	 */
	public List<UserOrganization> queryUsersByRold(@Param("ROLID") String ROLID );
	/**
	 * @Title: queryAllorgnInfo 
	 * @Description: 查询组织结构
	 * @return List
	 */
	public List<UserOrganization>queryAllorgnInfo();
	
	/**   
	 * @Title: findAuthByRolid   
	 * @Description: 根据用户角色id查询用户具有的权限 
	 * @param: @param rolid
	 * @param: @return      
	 * @return: ArrayList<IotUserModuleResource>        
	 */  
	public ArrayList<IotUserModuleResource> findAuthByRolid(String rolid);
	
	/**
	 * @Title: saveUserUserRoleInBatch 
	 * @Description: 批量添加用户角色关系
	 * @return int
	 */
	public int saveUserUserRoleInBatch(@Param("lists")List<UserRoleRelation> lists);
	/**
	 * @Title: saveUserUserRoleInBatch 
	 * @Description: 批量删除用户角色关系
	 * @return int
	 */
	public int deleteUserUserAndRolebyId(@Param("rolid")String rolid);
}
