
	/**  
     * @Title: userServiceInter.java
 	 * @Package cn.userCenter.service.inter
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.service.inter;

import java.util.List;
import java.util.Map;

import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;


/**
 	 * @ClassName: userServiceInter
 	 * @Description: 
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */

public interface UserServiceInter {
	/**   
	  * @Title: getUserOrganById   
	  * @Description: 根据用户id查询用户信息       
	  * @return: UserOrganization        
	  */
	public UserOrganization getUserOrganById( String userid );

	
	 /**   
	  * @Title: getUserInfoByUserId   
	  * @Description: 根据用户唯一标示userid查询用户信息        
	  * @return: UserInfo        
	  */  
	public UserInfo getUserInfoByUserId( String userid);

	
	 /**   
	  * @Title: getUserInfoByNum   
	  * @Description:  根据用户唯一标示usernum查询用户信息         
	  * @return: UserInfo        
	  */  
	UserInfo getUserInfoByNum( String usernum);
	
	
	 /**   
	  * @Title: getUserOrganByUsernum   
	  * @Description:   根据用户唯一标示num查询用户          
	  * @return: UserOrganization        
	  */  
	UserOrganization getUserOrganByUsernum( String usernum);


	
	 /**   
	  * @Title: saveUserServ   
	  * @Description:  新增用户      
	  * @return: String        
	  */  
	String saveOrganServ(UserOrganization user);


	
	 /**   
	  * @Title: saveUserInfoServ   
	  * @Description:  新增用户信息              
	  * @return: int   返回数据库受影响的条目            
	  */  
	int saveUserInfoServ(UserInfo userInfo);


	
	 /**   
	  * @Title: getUserAllListServ   
	  * @Description: 查询所有用户       
	  * @return: UserOrganization        
	  */  
	List<UserOrganization> getUserAllListServ();


	
	 /**   
	  * @Title: deleteUserByNumServ   
	  * @Description: 根据usernum删除用户            
	  * @return: int        
	  */  
	int deleteUserByNumServ(String usernum);


	/**   
	 * @Title: deleteUserInfoByNumServ   
	 * @Description: 根据num删除用户信息  
	 * @param: @param usernum
	 * @param: @return      
	 * @return: int        
	 */  
	int deleteUserInfoByNumServ(String usernum);


	/**   
	 * @Title: deleteUserAndInfoByNum   
	 * @Description: 根据usernum删除用户和用户信息 
	 * @param: @param usernum
	 * @param: @return      
	 * @return: int        
	 */  
	int deleteUserAndInfoByNum(String usernum);


	/**   
	 * @Title: findUsersAll   
	 * @Description: 查询所有用户非组织信息
	 * @param: @return      
	 * @return: List<UserOrganization>        
	 */  
	List<UserOrganization> findUsersAll();


	/**   
	 * @Title: getUsersByNum   
	 * @Description: 根据用户唯一标识查询用户    
	 * @return: UserOrganization        
	 */  
	UserOrganization getUsersByNum(String usernum);


	/**   
	 * @Title: saveUserBackId   
	 * @Description:  根据id增加用户 ，返回id   
	 * @return: int        
	 */  
	UserOrganization saveUserBackId(  String usernum, String name  );


	/**   
	 * @Title: getInitOrganServ   
	 * @Description: 获取全部组织数据，并根据用户usernum初始化 数据   
	 * @return: List<Map<String,Object>>        
	 */  
	List<Map<String, Object>> getInitOrganServ(String usernum);


	/**   
	 * @Title: modifyUserParentidServ   
	 * @Description: 修改usernum用户 的parentid  
	 * @return: int        
	 */  
	int modifyUserParentidServ(String usernum, String parentId);


	/**   
	 * @Title: modifyUserByIdServ   
	 * @Description: 根据用户id修改用户信息    
	 * @return: int        
	 */  
	int modifyUserByIdServ(String orgid, String usernum, String name);


	/**   
	 * @Title: deleteUserByNum   
	 * @Description:根据usernum删除用户   
	 * @return: int        
	 */  
	int deleteUserByNum(String usernum);		


}
