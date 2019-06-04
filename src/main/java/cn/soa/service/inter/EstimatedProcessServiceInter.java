package cn.soa.service.inter;

import java.util.List;

import cn.soa.entity.UserOrganization;

/**
 * 问题评估组内处理业务层接口
 * @author Bru.Lo
 *
 */
public interface EstimatedProcessServiceInter {

	/**
	 * 通过当前用户角色获取对应的下级信息
	 * @param roleName 当前用户 的就是名称
	 * @return 返回当前用户 的使用下级用户
	 */
	List<UserOrganization> getUserByRoleName(String roleName);
}
