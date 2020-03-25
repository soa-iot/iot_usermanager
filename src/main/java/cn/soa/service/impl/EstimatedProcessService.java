package cn.soa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.EstimatedProcessMapper;
import cn.soa.entity.UserOrganization;
import cn.soa.service.inter.EstimatedProcessServiceInter;

/**
 * 问题评估组内处理业务层属性方法
 * 
 * @author Bru.Lo
 *
 */

@Service
public class EstimatedProcessService implements EstimatedProcessServiceInter {

	@Autowired
	private EstimatedProcessMapper estimatedProcessMapper;
	
	/**
	 * 通过当前用户角色获取对应的下级信息业务层实现方法
	 * @param roleName 当前用户 的就是名称
	 * @return 返回当前用户 的使用下级用户
	 */	
	@Override
	public List<UserOrganization> getUserByRoleName(String roleName) {
		
		return findUserByRoleName(roleName);
	}

	/**
	 * 通过当前用户角色获取对应的下级信息持久层实现方法
	 * @param roleName 当前用户 的就是名称
	 * @return 返回当前用户 的使用下级用户
	 */
	private List<UserOrganization> findUserByRoleName(String roleName){
		try {
			return estimatedProcessMapper.findUserByRoleName(roleName);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
