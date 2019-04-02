
/**
 * <一句话功能描述>
 * <p>权限
 * @author 陈宇林
 * @version [版本号, 2019年1月31日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.IotUserAuthorityMapper;
import cn.soa.dao.IotUserRoleAuthMapper;
import cn.soa.dao.RoleAuthorityMapper;
import cn.soa.entity.IotUserAuthority;
import cn.soa.entity.IotUserRoleAuth;
import cn.soa.entity.RoleAuthority;
import cn.soa.service.inter.RoleAuthorityServiceInter;

@Service
public class RoleAuthorityService implements RoleAuthorityServiceInter {

	@Autowired
	private IotUserAuthorityMapper authorityMapper;

	@Autowired
	private RoleAuthorityMapper roleAuthorityMapper;

	@Autowired
	private IotUserRoleAuthMapper roleAuthMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.soa.service.inter.RoleAuthorityServiceInter#getAuthorityInfo()
	 */
	@Override
	public List<RoleAuthority> getAuthorityInfo() {

		List<RoleAuthority> authorityInfo = roleAuthorityMapper.findRoleAuthority();

		System.out.println(authorityInfo);

		return authorityInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.soa.service.inter.RoleAuthorityServiceInter#addAuthorityInfo(java.util.
	 * List)
	 */
	@Override
	public int addAuthorityInfo(List<IotUserAuthority> authorityInfo) {

		int num = 0;
		for (IotUserAuthority authority : authorityInfo) {
			num += authorityMapper.insertSelective(authority);
		}
		return num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.soa.service.inter.RoleAuthorityServiceInter#updateAuthorityInfo(java.util.
	 * List)
	 */
	@Override
	public int updateAuthorityInfo(List<IotUserAuthority> authorityInfo) {

		int result = 0;

		for (IotUserAuthority authority : authorityInfo) {
			result += authorityMapper.updateByPrimaryKeySelective(authority);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.soa.service.inter.RoleAuthorityServiceInter#deleteAuthorityInfo(java.util.
	 * List)
	 */
	@Override
	public int deleteAuthorityInfo(List<String> ids) {

		int result = 0;
		for (String autid : ids) {
			result += roleAuthMapper.deleteByAutid(autid);
			result += authorityMapper.deleteByAutid(autid);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.soa.service.inter.RoleAuthorityServiceInter#getRoleIdByAuthorityId(java.
	 * lang.String)
	 */
	@Override
	public List<String> getRoleIdByAuthorityId(String authorityId) {

		List<String> roleIds = roleAuthMapper.selectByAutid(authorityId);

		return roleIds;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.soa.service.inter.RoleAuthorityServiceInter#changeToAuthority(java.util.
	 * List, java.lang.String)
	 */
	@Override
	public Integer changeToAuthority(List<String> rolids, String authorityId) {

		Integer result = 0;

		/**
		 * 根据authorityId删除所有角色
		 */
		result += roleAuthMapper.deleteByAutid(authorityId);

		/**
		 * 插入权限对应的角色
		 */

		if(rolids == null || rolids.isEmpty()) {
			return result;
		}
		for (String rolid : rolids) {
			IotUserRoleAuth userRoleAuth = new IotUserRoleAuth();
			userRoleAuth.setAutid(authorityId);
			userRoleAuth.setRolid(rolid);
			result += roleAuthMapper.insertSelective(userRoleAuth);

		}

		return result;
	}

}
