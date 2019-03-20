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

import cn.soa.entity.UserRegister;


/**
 * @ClassName: userMapper
 * @Description: 用户数据dao层
 * @author zhugang
 * @date 2019年1月9日
 *
 */

@Mapper
public interface UserRegistMapper {
	
	/**   
	  * @Title: findRegisters   
	  * @Description:  查询所有注册用户      
	  * @return: List<UserRegister>        
	  */  
	List<UserRegister> findRegisters();
	
	
	 /**   
	  * @Title: findRegisterByNum   
	  * @Description: 根据注册usernum查询注册用户       
	  * @return: UserRegister        
	  */  
	UserRegister findRegisterByNum(String usernum);
	
	
	 /**   
	  * @Title: saveUserRegis   
	  * @Description: 保存用户注册信息
	  * @return: UserRegister        
	  */  
	int saveUserRegis( UserRegister userRegist ); 
	
	
	 /**   
	  * @Title: modifyRegisteState   
	  * @Description:  根据num修改注册用户编号      
	  * @return: int        
	  */  
	int modifyRegisteState( String num );
	
}
