/**  
 * @Title: UserRegistServiceInter.java
 * @Package cn.userCenter.service.inter
 * @Description: )
 * @author zhugang
 * @date 2019年1月23日
 * @version V1.0  
 */

        
package cn.soa.service.inter;

import java.util.List;

import cn.soa.entity.UserRegister;

/**
  * @ClassName: UserRegistServiceInter
  * @Description: 
  * @author zhugang
  * @date 2019年1月23日
  */

public interface UserRegistServiceInter {


	 /**   
	  * @Title: saveUserRegistServ   
	  * @Description:  保存用户注册信息          
	  * @return: int        
	  */  
	int saveUserRegistServ(UserRegister userRegist);

	
	 /**   
	  * @Title: findRegisterByNumServ   
	  * @Description: 根据注册usernum查询注册用户          
	  * @return: UserRegister        
	  */  
	UserRegister findRegisterByNumServ(String i);


	
	 /**   
	  * @Title: findRegistersServ   
	  * @Description:   查询所有注册用户        
	  * @return: List<UserRegister>        
	  */  
	List<UserRegister> findRegistersServ();


	
	 /**   
	  * @Title: modifyRegStateServ   
	  * @Description:  根据num修改注册用户编号            
	  * @return: int        
	  */  
	int modifyRegStateServ(String num);

}
