package cn.soa.service.inter.usermanagement;

import java.util.List;
import cn.soa.entity.OrganTree;
import cn.soa.entity.ResponseEntity;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;

/**
 * 用户信息管理业务层接口
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
public interface UserManagementSI {
	
	/**
	 * 根据条件获取用户信息列表
	 * @param query - 查询的条件
	 * @return List<UserInfoVO> - 用户信息列表
	 */
	ResponseEntity<List<UserInfoVO>> getUsersByCondition(UserQueryCondition query);
	
	/**
	 * 设置用户状态
	 * @param usernum - 用户账号
	 * @param state - 用户状态码： 1-正常，2-禁用
	 */
	Boolean setUserState(String usernum, Integer state);
	
	/**
	 * 更新用户密码
	 * @param usernum - 用户账号
	 * @param password - 用户密码
	 */
	Boolean setUserPassword(String usernum, String password);
	
	/**
	 * 新增用户信息
	 * @param user - 用户信息对象
	 */
	Boolean addUserInfo(UserInfoVO user, String rolid, String parentId);
	
	/**
	 * 更新用户信息
	 * @param user - 用户信息对象
	 */
	Boolean setUserInfo(UserInfoVO user, String parentId);
	
	/**
	 * 检测用户账号是否已存在
	 * @param usernum - 用户账号
	 */
	Boolean checkUserExist(String usernum);
	
	/**
	 * 获取人员组织信息树
	 * 
	 * @return List<OrganTree> - 人员组织信息树
	 */
	List<OrganTree> getOrganTree();
}
