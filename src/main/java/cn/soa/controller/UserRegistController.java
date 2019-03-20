
	/**  
     * @Title: UserController.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月17日
 	 * @version V1.0  
 	 */

        
package cn.soa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRegister;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.service.impl.UserRegistService;
import cn.soa.service.inter.UserServiceInter;


/**
  * @ClassName: UserController
  * @Description: 人员管理 - 控制层
  * @author zhugang
  * @date 2019年1月17日
  */
@RestController
@RequestMapping("/register")
public class UserRegistController {
	private static Logger logger = LoggerFactory.getLogger( UserRegistController.class );
	
	@Autowired
	private UserRegistService userRegistService;
	
	@Autowired
	private UserServiceInter userService;
	
	
	 /**   
	  * @Title: saveUserRegister   
	  * @Description:        保存用户注册信息
	  * @return: ResultJson<String>        
	  */  
	@PostMapping("")
	public ResultJson<String> saveUserRegister( @RequestBody @Valid UserRegister userRegister){
		logger.debug("--C----------保存用户注册信息-----------");
		int i = userRegistService.saveUserRegistServ(userRegister);
		if( i > 0  ) {
			logger.debug("--C----------保存用户注册信息成功-----------");
			return new ResultJson<String>( 0, "保存用户成功", i+"" );
		}else if( i == 0 ){
			logger.debug("--C----------保存用户注册信息失败-----------i:" + i);
			return new ResultJson<String>( 1, "保存用户失败，插入0条数据", i+"" );
		}else {
			logger.debug("--C----------保存用户注册信息失败-----------i:" + i);
			return new ResultJson<String>( 1, "保存用户失败,未知错误", i+"" );
		}
	}
	
	 /**   
	  * @Title: existsUsernum   0
	  * @Description: 检查用户表和注册表中用户编码是否存在     
	  * @return: ResultJson<String>        
	  */  
	@GetMapping("/user/{num}")
	public ResultJson<String> existsUsernum( @PathVariable("num") @NotBlank String usernum ){
		logger.debug("--C----------检查用户表的用户编码是否存在-----------");
		logger.debug("--C----------usernum:" + usernum);
		/*
		 * 检查用户表用户是否存在
		 */
		UserOrganization user = userService.getUserOrganByUsernum(usernum);
		if( user != null ) {						
			return new ResultJson<String>( 0, "用户表用户存在", "用户存在" );
		}else {
			logger.debug("--C----------检查用户表的用户编码是不存在-----------");
			
			/*
			 * 检查用户表用户是否存在
			 */
			logger.debug("--C----------检查注册表的用户编码是否存在-----------");
			UserRegister register = userRegistService.findRegisterByNumServ(usernum);
			if( register != null ) {
				return new ResultJson<String>( 0, "注册表用户存在", "用户存在" );
			}
			return new ResultJson<String>( 1, "注册表和用户表用户都不存在", "用户不存在" );
		}
	}

	
	 /**   
	  * @Title: getRegistersContr   
	  * @Description:  查询所有注册用户            
	  * @return: ResultJson<List<UserRegister>>        
	  */  
	@GetMapping("/list")
	public ResultJson<List<UserRegister>> getRegistersContr(){
		logger.debug("--C----------查询所有注册用户-----------");
		List<UserRegister> registers = userRegistService.findRegistersServ();
		logger.debug("--C----------registers-----------" + registers );
		if( registers != null ) {
			return new ResultJson<List<UserRegister>>(0, "有注册用户", registers );
		}
		return new ResultJson<List<UserRegister>>(0, "没有注册用户", null );
	}
	
	
	 /**   
	  * @Title: modifyRegStateContr   
	  * @Description:  根据注册用户num修改注册用户状态      
	  * @return: ResultJson<Integer>        
	  */
	@PutMapping("/state")
	public ResultJson<Integer> modifyRegStateContr( @RequestParam("num") @NotBlank String num ){
		logger.debug("--C----------根据注册用户num修改注册用户状态     -----------");
		logger.debug("--C---------- num -----------" + num );
		int i = userRegistService.modifyRegStateServ(num);
		logger.debug("--C---------- i -----------" + i );
		if( i > 0 ) {
			return new ResultJson<Integer>(0, "修改成功", i );
		}else if( i == -1) {
			return new ResultJson<Integer>(0, "修改失败,数据库出错", -1 );
		}else {
			return new ResultJson<Integer>(0, "修改失败，未知错误", -1 );
		}
	}
	
}
