
/**
 * <一句话功能描述>
 * <p>角色权限服务接口
 * @author 陈宇林
 * @version [版本号, 2019年1月31日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service.inter;

import java.util.List;

import cn.soa.entity.IotUserAuthority;
import cn.soa.entity.RoleAuthority;

public interface RoleAuthorityServiceInter {

	/**
	 * 获取所有权限表数据
	 * 
	 * @return
	 */
	List<RoleAuthority> getAuthorityInfo();

	/**
	 * 增加权限(支持批量增加)
	 * 
	 * @param authorityInfo
	 * @return 影响数据条数
	 */
	int addAuthorityInfo(List<IotUserAuthority> authorityInfo);

	/**
	 * 修改权限（支持批量修改）
	 * 
	 * @param authorityInfo
	 * @return 影响数据条数
	 */
	int updateAuthorityInfo(List<IotUserAuthority> authorityInfo);

	/**
	 * 删除权限（支持批量删除）
	 * 
	 * @param authorityInfo
	 * @return 影响数据条数
	 */
	int deleteAuthorityInfo(List<String> ids);

	List<String> getRoleIdByAuthorityId(String authorityId);

	/**
	 * 根据权限id删除或添加角色到权限
	 * 
	 * @param rolids
	 *            角色id
	 * @param authorityId
	 *            权限id
	 * @return 影响数据条数
	 */
	Integer changeToAuthority(List<String> rolids, String authorityId);

}
