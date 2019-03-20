/**  
 * @Title: userMapper.java
 * @Package cn.userCenter.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月9日
 * @version V1.0  
 */

        
package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.UserAuthority;


/**
 * @ClassName: userMapper
 * @Description: 用户权限数据dao层
 * @author zhugang
 * @date 2019年1月9日
 *
 */

@Mapper
public interface UserAuthMapper {
	
	 /**   
	  * @Title: findUserAuths   
	  * @Description: 查询所有的权限信息    
	  * @return: List<UserAuthority>        
	  */  
	public List<UserAuthority> findUserAuths();
	
	
	 /**   
	  * @Title: findUserAuthById   
	  * @Description: 根据权限id查询权限信息       
	  * @return: UserAuthority        
	  */  
	public UserAuthority findUserAuthById(@Param("autid") String autid);
	
	
	 /**   
	  * @Title: findUserAuthByRolid   
	  * @Description:  根据角色id查询权限信息        
	  * @return: UserAuthority        
	  */  
	public UserAuthority findUserAuthByRolid(@Param("rolid") String rolid);
	
	
	 /**   
	  * @Title: findUserAuthByUserid   
	  * @Description: 根据用户id查询用户权限信息       
	  * @return: UserAuthority        
	  */  
	public UserAuthority findUserAuthByUserid(@Param("orgid") String orgid);
	
		
	 /**   
	  * @Title: saveUserAuth   
	  * @Description: 增加单个用户权限信息       
	  * @return: int        
	  */  
	public int saveUserAuth(@Param("userAuth") UserAuthority userAuth);
	
	
	 /**   
	  * @Title: saveUserAuthInBatch   
	  * @Description: 批量增加用户权限信息<对象以下属性值不能为null>     
	  * @return: int        
	  */  
	public int saveUserAuthInBatch(@Param("userAuths") List<UserAuthority> userAuths);
	
	
	 /**   
	  * @Title: modifyUserAuthByObj   
	  * @Description:  根据权限id修改用户权限信息      
	  * @return: int        
	  */  
	public int modifyUserAuthByObj(@Param("userAuth") UserAuthority userAuth);
	
	
	 /**   
	  * @Title: deleteUserAuthById   
	  * @Description: 根据角色id删除用户角色信息       
	  * @return: int        
	  */  
	public int deleteUserAuthById(@Param("autid") String autid);
}
