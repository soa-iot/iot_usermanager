
/**
 * <一句话功能描述>
 * <p>
 * @author 陈宇林
 * @version [版本号, 2019年1月31日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.IotUserAuthority;
import cn.soa.entity.RoleAuthority;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.entity.headResult.UserTableJson;
import cn.soa.service.inter.RoleAuthorityServiceInter;

@RestController
@RequestMapping("/roleAuthority")
public class RoleAuthorityControl {

	@Autowired
	private RoleAuthorityServiceInter authorityService;

	/**
	 * 获取权限数据
	 * 
	 * @return
	 */
	@RequestMapping("/getAuthotityInfo")
	public UserTableJson<List<RoleAuthority>> getAuthorityInfo() {
		List<RoleAuthority> authorityInfo = authorityService.getAuthorityInfo();
		// List<RoleAuthority> authorityInfo = new ArrayList<RoleAuthority>();
		UserTableJson<List<RoleAuthority>> reObj = new UserTableJson<List<RoleAuthority>>("success", 0, "查询成功",
				authorityInfo, authorityInfo.size(), true);
		return reObj;
	}

	/**
	 * 增加权限数据
	 * 
	 * @param authority
	 * @return
	 */
	@RequestMapping("/addAuthority")
	public ResultJson<Integer> addAuthorityInfo(IotUserAuthority authority) {
		List<IotUserAuthority> authorityInfo = new ArrayList<IotUserAuthority>();
		authorityInfo.add(authority);
		Integer result = authorityService.addAuthorityInfo(authorityInfo);
		ResultJson<Integer> reObj = new ResultJson<Integer>(0, "添加数据成功", result);

		return reObj;

	}

	/**
	 * 删除权限数据
	 * 
	 * @param autid
	 * @return
	 */
	@RequestMapping("/delAuthority")
	public ResultJson<Integer> delAuthorityInfo(String autid) {
		List<String> ids = new ArrayList<String>();
		ids.add(autid);
		Integer result = authorityService.deleteAuthorityInfo(ids);
		ResultJson<Integer> reObj = new ResultJson<Integer>(0, "删除数据成功", result);
		return reObj;
	}

	/**
	 * 更改数据
	 * 
	 * @param authorityInfo
	 * @return
	 */
	@RequestMapping("/updateAuthority")
	public ResultJson<Integer> updateAuthority(IotUserAuthority authorityInfo) {
		List<IotUserAuthority> authorityInfos = new ArrayList<IotUserAuthority>();
		authorityInfos.add(authorityInfo);
		Integer result = authorityService.updateAuthorityInfo(authorityInfos);
		ResultJson<Integer> reObj = new ResultJson<Integer>(0, "添加数据成功", result);
		return reObj;

	}

	/**
	 * 根据权限id查询对应的角色
	 * 
	 * @param authorityId
	 * @return
	 */
	@RequestMapping("/getRoleIdByAuthorityId")
	public ResultJson<List<String>> getRoleIdByAuthorityId(String authorityId) {

		List<String> roleIds = authorityService.getRoleIdByAuthorityId(authorityId);
		ResultJson<List<String>> reObj = new ResultJson<List<String>>(0, "查询数据成功", roleIds);
		return reObj;
	}

	/**
	 * 根据authirityId 添加或删除角色权限
	 * 
	 * @param rolids
	 *            角色id
	 * @param authorityId
	 *            权限id
	 * @return 影响数据条数
	 */
	@RequestMapping("/changeToAuthority")
	public ResultJson<Integer> changeToAuthority(
			@RequestParam(value = "rolids[]", required = false) ArrayList<String> rolids, String authorityId) {

		Integer result = authorityService.changeToAuthority(rolids, authorityId);

		ResultJson<Integer> reObj = new ResultJson<Integer>(0, "修改角色权限成功", result);
		return reObj;
	}

}
