
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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.AuthInfo;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.UserInfo;
import cn.soa.entity.UserOrganization;
import cn.soa.entity.UserRole;
import cn.soa.entity.UserTest;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.entity.headResult.UserTableJson;
import cn.soa.service.inter.EstimatedProcessServiceInter;
import cn.soa.service.inter.RoleServiceInter;
import cn.soa.service.inter.UserServiceInter;
import cn.soa.util.GlobalUtil;


/**
  * @ClassName: UserController
  * @Description: 人员管理 - 控制层
  * @author zhugang
  * @date 2019年1月17日
  */
@RestController
@RequestMapping("/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger( UserController.class );
	
	@Autowired
	private UserServiceInter userService;
	
	@Autowired
	private RoleServiceInter roleService;
	
	@Autowired
	private EstimatedProcessServiceInter estimatedProcessServiceInter;
	
	/**   
	 * @Title: getUserByNum   
	 * @Description:  根据用户usernum查询用户
	 * @param: @param usernum      
	 * @return: void        
	 */  
	@GetMapping("/users/{usernum}")
	public ResultJson<UserOrganization> getUserByNum( @PathVariable("usernum") String usernum ) {
		logger.debug("-----C------- 根据用户usernum查询用户   ---- usernum： " + usernum);
		UserOrganization u = userService.getUsersByNum(usernum);
		if( u != null ) {
			logger.debug( "---C---- 根据用户usernum查询用户成功------u：" + u );
			return new ResultJson<UserOrganization>( 0, "查询用户成功", u ); 
		}
		logger.debug( "---C---- 根据用户usernum查询用户失败------u：" + u );
		return new ResultJson<UserOrganization>( 1, "查询用户失败", null ); 
	}
	
	
	 /**   
	  * @Title: existsUsernum   
	  * @Description: 根据用户编码检查用户表是否存在     
	  * @return: ResultJson<String>        
	  */  
	@GetMapping("/usernum/{num}")
	public ResultJson<String> existsUsernum( @PathVariable("num") @NotBlank String usernum ){
		logger.debug("--C----------检查用户编码是否存在-----------");
		logger.debug("--C----------usernum:" + usernum);
		UserOrganization user = userService.getUserOrganByUsernum(usernum);
		if( user != null ) {
			return new ResultJson<String>( 0, "用户存在", "用户存在" );
		}else {
			return new ResultJson<String>( 1, "用户不存在", "用户不存在" );
		}
	}
	
	/**   
	 * @Title: findUserFirstParentByNumC   
	 * @Description:  根据用户唯一标识查询用户上一级父组织 
	 * @return: void        
	 */  
	@GetMapping("/organ/1/usernum/{usernum}")
	public UserOrganization findFirstOrganByUsernumC(@PathVariable("usernum")  String usernum ) {
		logger.debug( "--C----------根据用户唯一标识查询用户上一级父组织 -----------" );
		logger.debug( usernum );
		UserOrganization organ = userService.findUserFirstParentByNum( usernum );
		return organ;
	}
	
	/**   
	 * @Title: findUserSecondParentByNumC   
	 * @Description: 根据用户唯一标识查询用户上两级父组织   
	 * @return: void        
	 */  
	@GetMapping("/organ/2/usernum/{usernum}")
	public ResultJson<UserOrganization> findSecondOrganByUsernumC( @PathVariable("usernum") String usernum ) {
		logger.debug( "--C----------根据用户唯一标识查询用户上两级父组织   -----------" );
		logger.debug( usernum );
		UserOrganization organ = userService.findUserSecondParentByNum( usernum );
		if( organ != null ) {
			return new ResultJson<UserOrganization>( 0, "组织存在", organ );
		}else {
			return new ResultJson<UserOrganization>( 1, "组织不存在或访问出错", organ );
		}
	}
	
	/**   
	 * @Title: findUserThirdParentByNumC   
	 * @Description: 根据用户唯一标识查询用户上三级父组织     
	 * @return: ResultJson<UserOrganization>        
	 */  
	@GetMapping("/organ/3/usernum/{usernum}")
	public ResultJson<UserOrganization> findThirdOrganByUsernumC( @PathVariable("usernum") String usernum ) {
		logger.debug( "--C----------根据用户唯一标识查询用户上三级父组织   -----------" );
		logger.debug( usernum );
		UserOrganization organ = userService.findUserThirdParentByNum( usernum );
		if( organ != null ) {
			return new ResultJson<UserOrganization>( 0, "组织存在", organ );
		}else {
			return new ResultJson<UserOrganization>( 1, "组织不存在或访问出错", organ );
		}
	}
	
	/**   
	 * @Title: findUserFirstParentByNameC   
	 * @Description: 根据用户姓名查询用户上一级父组织  
	 * @return: ResultJson<UserOrganization>        
	 */  
	@GetMapping("/organ/1/name/{name}")
	public ResultJson<UserOrganization> findFirstOrganByUsernameC( @PathVariable("name") String name ) {
		logger.debug( "--C----------根据用户姓名查询用户上一级父组织   -----------" );
		logger.debug( name );
		UserOrganization organ = userService.findUserFirstParentByName( name );
		if( organ != null ) {
			return new ResultJson<UserOrganization>( 0, "组织存在", organ );
		}else {
			return new ResultJson<UserOrganization>( 1, "组织不存在或访问出错", organ );
		}
	}
	
	/**   
	 * @Title: findUserSecondParentByNameC   
	 * @Description:  根据用户姓名查询用户上两级父组织 
	 * @return: ResultJson<UserOrganization>        
	 */ 
	@GetMapping("/organ/2/name/{name}")
	public ResultJson<UserOrganization> findSecondOrganByUsernameC( @PathVariable("name") String name ) {
		logger.debug( "--C----------根据用户姓名查询用户上两级父组织   -----------" );
		logger.debug( name );
		UserOrganization organ = userService.findUserSecondParentByName( name );
		if( organ != null ) {
			return new ResultJson<UserOrganization>( 0, "组织存在", organ );
		}else {
			return new ResultJson<UserOrganization>( 1, "组织不存在或访问出错", organ );
		}
	}
	
	/**   
	 * @Title: findUserThirdParentByNameC   
	 * @Description:  根据用户姓名查询用户上三级父组织  
	 * @return: ResultJson<UserOrganization>        
	 */  
	@GetMapping("/organ/3/name/{name}")
	public ResultJson<UserOrganization> findThirdOrganByUsernameC( @PathVariable("name") String name ) {
		logger.debug( "--C----------根据用户姓名查询用户上三级父组织   -----------" );
		logger.debug( name );
		UserOrganization organ = userService.findUserThirdParentByName( name );
		if( organ != null ) {
			return new ResultJson<UserOrganization>( 0, "组织存在", organ );
		}else {
			return new ResultJson<UserOrganization>( 1, "组织不存在或访问出错", organ );
		}
	}
	
	/**   
	 * @Title: getUsersAll   
	 * @Description:  
	 * @param: @return      
	 * @return: UserTableJson<List<UserOrganization>>        
	 */ 
	@GetMapping("/users")
	public ResultJson<List<UserOrganization>> getUsersAll(){
		List<UserOrganization> users = userService.findUsersAll();
		if( users != null ) {
			return new ResultJson<List<UserOrganization>>(  0, "查询成功", users);
		}
		return new ResultJson<List<UserOrganization>>(  1, "查询失败", users);
	}
	
	 /**   
	  * @Title: getUserAllList   
	  * @Description: 查询所有组织       
	  * @return: UserTableJson<List<UserOrganization>>        
	  */  
	@PostMapping("/list")
	public UserTableJson<List<UserOrganization>> getUserAllList() {
		logger.debug("--C----------开始获取所有用户-----------");
		List<UserOrganization> userAll = userService.getUserAllListServ();
		if( userAll != null ) {
			return new UserTableJson<List<UserOrganization>>( 
					"", 0,"成功", userAll, userAll.size(), true );
		}
		return new UserTableJson<List<UserOrganization>>( 
				"", 0, "失败", userAll, 0, true );
	}
	
	
	 /**   
	  * @Title: getUserAllListTest   
	  * @Description:  查询所有用户(测试)             
	  * @return: UserTableJson<List<UserOrganization>>        
	  */  
	@PostMapping("/list/test")
	public UserTableJson<List<UserTest>> getUserAllListTest() {
		logger.debug("--C----------开始获取所有用户-----------");
		UserTest userTest = new UserTest("王者", 0 , -1);
		UserTest userTest1 = new UserTest("射手", 1 ,0);
		UserTest userTest2 = new UserTest("辅助", 2 ,0);
		UserTest userTest3 = new UserTest("后裔", 11 ,1); 
		ArrayList<UserTest> arrayList = new ArrayList<UserTest>();
		arrayList.add(userTest);
		arrayList.add(userTest1);
		arrayList.add(userTest2);
		arrayList.add(userTest3);
		return new UserTableJson<List<UserTest>>( "", 1, "成功", arrayList, arrayList.size(),true );
	}
	
	
	 /**   
	  * @Title: registryUserContr   
	  * @Description: 新增组织    
	  * @return: ResultJson<String> 返回新增用户主键           
	  */  
	@PostMapping("")
	public ResultJson<String> registryUserContr(@RequestBody @Valid UserOrganization user){
		logger.debug("C----registryContr--- user ---" + user);
		String i = userService.saveOrganServ(user);
		logger.debug("C----新增组织返回值 ---" + i);
		if( "-1".equals(i) ) {
			return new ResultJson<String>(1, "未知错误", i + "" );
		}else if( "0".equals(i) ) {
			return new ResultJson<String>(1, "新增组织失败 ，插入数据为0", i + "" );
		}else {
			return new ResultJson<String>(0, "新增组织成功", i + "" );
		}
	}
	
	
	 /**   
	  * @Title: registryUserInfoContr   
	  * @Description: 新增用户信息       
	  * @return: ResultJson<String>    
	  */  
	@PostMapping("/userInfo")
	public ResultJson<String> registryUserInfoContr( @RequestBody @Valid UserInfo userInfo ){
		logger.debug("C---- 注册用户信息    ---" + userInfo);
		int i = userService.saveUserInfoServ(userInfo);
		logger.debug("C---- i    ---" + i);
		if( i < 0 ) {
			logger.debug("C---- 注册用户信息失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "未知错误", i + "" );
		}else if( i == 0) {
			logger.debug("C---- 注册用户信息失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "新增用户信息失败 ，插入数据为0", i + "" );
		}else {
			logger.debug("C---- 注册用户信息成功返回值 ---i---" + i);
			return new ResultJson<String>(0, "新增用户成功", i + "" );
		}
	}
	
	
	 /**   
	  * @Title: saveUserInfoById   
	  * @Description:  根据用户userid保存用户信息      
	  * @return: ResultJson<String>        
	  */  
	@PostMapping("/userInfo/{userid}")
	public ResultJson<String> saveUserInfoById( @PathVariable("userid")  @Valid String userid ){
		logger.debug("---C---------- 根据用户id（非num）注册用户信息    -------" + userid);
		//查询用户num，新建用户信息对象
		UserOrganization user = userService.getUserOrganById(userid);
		String usernum = user.getUsernum();
		logger.debug("---C---------- usernum    -------" + usernum);
		UserInfo userInfo = new UserInfo();
		userInfo.setUsernum(usernum);
		userInfo.setNname(user.getName());
		
		//保存用户信息
		int i = userService.saveUserInfoServ(userInfo);
		logger.debug("C---- i    ---" + i);
		if( i < 0 ) {
			logger.debug("C---- 注册用户信息失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "未知错误", i + "" );
		}else if( i == 0) {
			logger.debug("C---- 注册用户信息失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "新增用户信息失败 ，插入数据为0", i + "" );
		}else {
			logger.debug("C---- 注册用户信息成功返回值 ---i---" + i);
			return new ResultJson<String>(0, "新增用户成功", i + "" );
		}
	}
	
	
	 /**   
	  * @Title: deleteUserContro   
	  * @Description: 根据usernum删除用户        
	  * @return: ResultJson<String>        
	  */  
	@DeleteMapping("/{usernum}")
	public ResultJson<String> deleteUserContro(@PathVariable("usernum") @NotBlank String usernum) {
		logger.debug("-----C------- 删除用户   ---- usernum： " + usernum);
		int i = userService.deleteUserByNum(usernum);
		if( i < 0 ) {
			logger.debug("C---- 删除用户 失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "未知错误，删除失败", i + "" );
		}else if( i == 0) {
			logger.debug("C---- 删除用户失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "删除用户失败 ，删除数据为0", i + "" );
		}else {
			logger.debug("C---- 删除用户成功返回值 ---i---" + i);
			return new ResultJson<String>(0, "删除用户成功", i + "" );
		}
	}
	
	/**   
	 * @Title: deleteOrganContro   
	 * @Description:   根据num删除组织   
	 * @return: ResultJson<String>        
	 */  
	@DeleteMapping("/organ/{num}")
	public ResultJson<String> deleteOrganContro(@PathVariable("num") @NotBlank String num) {
		logger.debug("-----C------- 删除组织   ---- num： " + num);
		int i = userService.deleteUserByNum(num);
		if( i < 0 ) {
			logger.debug("C---- 删除组织失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "未知错误，删除失败", i + "" );
		}else if( i == 0) {
			logger.debug("C---- 删除组织失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "删除组织失败 ，删除数据为0", i + "" );
		}else {
			logger.debug("C---- 删除组织成功返回值 ---i---" + i);
			return new ResultJson<String>(0, "删除组织成功", i + "" );
		}
	}
	
	
	 /**   
	  * @Title: modifyUserState   
	  * @Description: 修改用户状态       
	  * @return: ResultJson<String>        
	  */  
	@PutMapping("/{usernum}")
	public ResultJson<String> modifyUserState(@PathVariable("usernum") @NotNull int usernum){
		logger.debug("-----C------- 修改用户状态   ---- usernum： " + usernum);
		return null;
	}
	
	/**   
	 * @Title: getAuthByRolid   
	 * @Description: 查询用户的模块菜单权限  
	 * @param: @return      
	 * @return: ResultJson<List<AuthInfo>>        
	 */  
	@GetMapping("/role/auths")
	public ResultJson<List<AuthInfo>> getAuthByRolid(){
		logger.debug("-----C------- 查询用户的模块菜单权限     ---- usernum： ");
		/*
		 * 获取角色 
		 */
		String rolid = null;
		String usernum =  GlobalUtil.getCookie("num");
		logger.debug("--C-----查询用户的模块菜单权限  :-----------usernum:" + usernum.substring( 1, usernum.length()-1 ));
		List<UserRole> userRoles = roleService.getUserRoleByNum(usernum.substring( 1, usernum.length()-1 ));		
		logger.debug("--C-----查询用户的模块菜单权限  :-----------userRoles:" + userRoles );
		//暂假定一个用户一个角色
		if( userRoles != null && userRoles.get(0) != null ) {
			rolid = userRoles.get(0).getRolid();
		}
		logger.debug("--C-----查询用户的模块菜单权限  :-----------rolid:" + rolid );
		if( rolid == null ) {
			logger.debug( "---C---- 用户角色不存在 ------" );
			return new ResultJson<List<AuthInfo>>( 1, "用户角色不存在", null );
		}
		
		/*
		 * 查询 
		 */
		ArrayList<AuthInfo> authInfos = roleService.findAuthByRolidServ(rolid);
		if( authInfos != null ) {
			logger.debug( "---C---- 用户权限查询成功 ------authInfos：" + authInfos );
			return new ResultJson<List<AuthInfo>>( 0, "用户角色权限查询成功", authInfos );
		}else {
			logger.debug( "---C---- 用户角色查询失败或无任何权限 ------authInfos：" + authInfos );
			return new ResultJson<List<AuthInfo>>( 1, "用户角色权限查询失败或无任何权限", null );
		}
	}
	
	
	/**   
	 * @Title: getAuthByRolid   
	 * @Description: 查询用户的模块菜单权限  
	 * @param: @return      
	 * @return: ResultJson<List<AuthInfo>>        
	 */  
	@GetMapping("/auths")
	public ResultJson<List<IotUserModuleResource>> getAuthJsonByRolid(){
		logger.debug("-----C------- 查询用户的模块菜单权限     ---- usernum： ");
		/*
		 * 获取角色 
		 */
		String rolid = null;
		String usernum =  GlobalUtil.getCookie("num");
		System.out.println(usernum);
		logger.debug("--C-----查询用户的模块菜单权限  :-----------usernum:" + usernum.substring( 1, usernum.length()-1 ));
		List<UserRole> userRoles = roleService.getUserMenoRoleByNum(usernum.substring( 1, usernum.length()-1 ));		
		logger.debug("--C-----查询用户的模块菜单权限  :-----------userRoles:" + userRoles );
		//暂假定一个用户一个角色
		if( userRoles != null && userRoles.get(0) != null ) {
			rolid = userRoles.get(0).getRolid();
		}
		logger.debug("--C-----查询用户的模块菜单权限 :-----------rolid:" + rolid );
		if( rolid == null ) {
			logger.debug( "---C---- 用户角色不存在 ------" );
			return new ResultJson<List<IotUserModuleResource>>( 1, "用户角色不存在", null );
		}
		
		/*
		 * 查询 
		 */
		ArrayList<IotUserModuleResource> auths = roleService.findAuthJsonServ(rolid);
		if( auths != null ) {
			logger.debug( "---C---- 用户权限查询成功 ------authInfos：" + auths );
			return new ResultJson<List<IotUserModuleResource>>( 0, "用户角色权限查询成功", auths );
		}else {
			logger.debug( "---C---- 用户角色查询失败或无任何权限 ------authInfos：" + auths );
			return new ResultJson<List<IotUserModuleResource>>( 1, "用户角色权限查询失败或无任何权限", null );
		}
	}
	
	
	
	/**   
	 * @Title: saveUserBackIdContr   
	 * @Description:   增加用户
	 * @return: ResultJson<UserOrganization>        
	 */  
	@PostMapping("/users")
	public ResultJson<UserOrganization> saveUserBackIdContr(
			@RequestParam("usernum") String usernum, 
			@RequestParam("name") String name,
			@RequestParam("password") String password){
		logger.debug("-----C------- 增加用户   ---- usernum： " + usernum);
		UserOrganization u = userService.saveUserBackId(usernum, name, password);
		if( u != null ) {
			logger.debug("-----C------- 增加用户成功   ----  " + u);
			return new ResultJson<UserOrganization>( 0, "增加用户成功 ", u );
		}else {
			logger.debug("-----C------- 增加用户失败   ----  " + u);
			return new ResultJson<UserOrganization>( 0, "增加用户失败 ", u );
		}
	}
	
	/**   
	 * @Title: getInitOrgan   
	 * @Description: 获取全部组织数据，并根据用户usernum初始化 数据
	 * @return: UserTableJson<List<UserOrganization>>        
	 */  
	@GetMapping("/organ/{usernum}")
	public UserTableJson<List<Map<String, Object>>> getInitOrgan(
			@PathVariable("usernum") @NotBlank String usernum) {
		logger.debug("--C---------- 获取全部组织数据，并根据用户usernum初始化 数据-----------");
		logger.debug("--C----------usernum-----------" + usernum );
		List<Map<String, Object>> lists = userService.getInitOrganServ(usernum);
		logger.debug("--C----------lists-----------" + lists );
		if( lists != null ) {
			return new UserTableJson<List<Map<String, Object>>>( 
					"", 0,"成功", lists, lists.size(), true );
		}
		return new UserTableJson<List<Map<String, Object>>>( 
				"", 0, "失败", lists, 0, true );
	}
	
	/**   
	 * @Title: modifyUserParentId   
	 * @Description:  修改usernum用户 的parentid
	 * @return: UserTableJson<List<Map<String,Object>>>        
	 */  
	@PostMapping("/organ")
	public ResultJson<String> modifyUserParentId(
			@RequestParam("usernum") @NotBlank String usernum,
			@RequestParam("parentid") @NotBlank String parentid){
		logger.debug( "--C---------- 修改usernum用户 的parentid-----------" );
		logger.debug( "usernum:" + usernum );
		logger.debug( "parentid:" + parentid );
		int i = userService.modifyUserParentidServ(usernum, parentid);
		if( i > 0 ) {
			logger.debug("-----C------- 修改usernum用户 的parentid成功  ----  " + i);
			return new ResultJson<String>( 0, "修改成功 ", i + "" );
		}else {
			logger.debug("-----C------- 修改usernum用户 的parentid失败 ----  " + i);
			return new ResultJson<String>( 0, "修改失败 ", "" );
		}
	}
	
	/**   
	 * @Title: modifyUserById   
	 * @Description: 根据用户id修改用户信息   
	 * @return: ResultJson<String>        
	 */ 
	@PutMapping("/user")
	public ResultJson<String> modifyUserById(
			@RequestParam("orgid") @NotBlank String orgid,
			@RequestParam("usernum") @NotBlank String usernum,
			@RequestParam("name") @NotBlank String name,
			@RequestParam("password") @NotBlank String password){
		logger.debug( "--C---------- 根据用户id修改用户信息  -----------" );
		int i = userService.modifyUserByIdServ(orgid, usernum, name, password);
		if( i > 0 ) {
			logger.debug("-----C------- 根据用户id修改用户信息   成功  ----  " + i);
			return new ResultJson<String>( 0, "修改成功 ", i + "" );
		}else {
			logger.debug("-----C------- 根据用户id修改用户信息   失败 ----  " + i);
			return new ResultJson<String>( 0, "修改失败 ", "" );
		}
	}
	
	/**   
	 * @Title: getButtonAuthorityC   
	 * @Description:  获取用户模块对应的按钮权限 
	 * @return: ResultJson<String>        
	 */  
	@GetMapping("/authority/{userid}/{modId}")
	public List<IotUserModuleResource> getButtonAuthorityC( 
			@PathVariable("userid") @NotBlank String userid,
			@PathVariable("modId") @NotBlank String modId,
			HttpServletRequest req){
		String callback=req.getParameter("callback");
		logger.debug("-----C------- getButtonAuthorityC ----  " + modId );
		logger.debug("-----C------- getButtonAuthorityC ----  " + userid );
		if( userid == null || userid.isEmpty() ) {
			return null;
		}
		List<IotUserModuleResource> resources = userService.getButtonAuthorityS(userid, modId);
		if( resources.size() > 0 ) {
			return resources;
		}else {
			return null;
		}
	}		
	
	/**
	 * 通过当前用户角色获取对应的下级的用户信息信息控制层方法
	 * @param roleName 当前用户 的角色名称
	 * @return 返回当前用户 的使用下级用户的json数据
	 */	
	@GetMapping("/roleName")
	public ResultJson<List<UserOrganization>> getUserByRoleName(String roleName) {
		logger.debug( "--------通过当前用户角色获取对应的下级的用户信息信息控制层方法-----------" + roleName );
		List<UserOrganization> users = estimatedProcessServiceInter.getUserByRoleName(roleName);
		if (users != null) {
			/*
			 * for (int i = 0; i < 10; i++) { users.add(users.get(0)); } users.get(0);
			 */
			return new ResultJson<List<UserOrganization>>(0, "数据获取成功", users);
		}else {
			return new ResultJson<List<UserOrganization>>(1, "数据获取失败", users);
		}
	}
	
}
