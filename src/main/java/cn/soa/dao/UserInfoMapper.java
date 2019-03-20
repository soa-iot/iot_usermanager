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

import cn.soa.entity.UserInfo;


/**
 * @ClassName: userMapper
 * @Description: 用户数据dao层
 * @author zhugang
 * @date 2019年1月9日
 *
 */

@Mapper
public interface UserInfoMapper {
	
	 /** 
		 * @Title: findUserById 
		 * @Description: 根据用户id查询用户信息
		 */
		public UserInfo findUserInfoById(@Param("userId") String userid);
		

		
		
		 /**   
		  * @Title: findUserInfoByUsernum   
		  * @Description: 根据用户唯一标识num查询用户信息       
		  * @return: UserInfo        
		  */  
		public UserInfo findUserInfoByUsernum(@Param("usernum") String usernum);
		
		
		 /** 
		 * @Title: saveUser 
		 * @Description: 根据用户对象保存用户信息 
		 */
		public int saveUserInfo(@Param("userInfo") UserInfo userInfo);
		
		
		
		 /** 
		 * @Title: modifyUserInfoById 
		 * @Description: 根据用户对象修改用户信息 
		 */
		public int modifyUserInfoById(@Param("userInfo") UserInfo userInfo);
		
		
		 /** 
		 * @Title: deleteUserInfoById 
		 * @Description: 根据用户id删除用户信息
		 */
		public int deleteUserInfoByNum(@Param("usernum") String usernum);
}
