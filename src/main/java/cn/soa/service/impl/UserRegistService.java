
	/**  
     * @Title: userService.java
 	 * @Package cn.userCenter.service.impl
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.UserRegistMapper;
import cn.soa.entity.UserRegister;
import cn.soa.service.inter.UserRegistServiceInter;


	/**
 	 * @ClassName: userService
 	 * @Description: 用户信息服务  - 业务层
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */
@Service
public class UserRegistService implements UserRegistServiceInter{
	private static Logger logger = LoggerFactory.getLogger( UserRegistService.class );
	
	
	@Autowired
	private UserRegistMapper userRegistMapper;

	
	
	 /**   
	  * @Title: findRegistersServ   
	  * @Description:  查询所有注册用户      
	  * @return: List<UserRegister>        
	  */ 
	@Override
	public List<UserRegister> findRegistersServ(){
		try {
			List<UserRegister> registers = userRegistMapper.findRegisters();
			return registers;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}				
	}
	
	 /**   
	  * @Title: saveUserRegistServ   
	  * @Description:  保存用户注册信息      
	  * @return: int        
	  */  
	@Override
	public int saveUserRegistServ( UserRegister userRegist ) {
		//logger.debug("---S----新增用户---" + user);
		try {
			int i = userRegistMapper.saveUserRegis(userRegist);
			if( i > 0 ) {
				return i;
			}else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	 /**   
	  * @Title: findRegisterByNumServ   
	  * @Description: 根据注册usernum查询注册用户        
	  * @return: UserRegister        
	  */  
	@Override
	public UserRegister findRegisterByNumServ( String i) {
		try {
			UserRegister register = userRegistMapper.findRegisterByNum(i);
			if(register != null ) {
				return register;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	
	 /**   
	  * @Title: modifyRegStateServ   
	  * @Description:  根据num修改注册用户编号      
	  * @return: int        
	  */  
	@Override
	public int modifyRegStateServ( String num ) {
		try {
			int i = userRegistMapper.modifyRegisteState(num);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
