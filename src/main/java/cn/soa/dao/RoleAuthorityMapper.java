
/**
 * <一句话功能描述>
 * <p>权限管理
 * @author 陈宇林
 * @version [版本号, 2019年2月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.RoleAuthority;

@Mapper
public interface RoleAuthorityMapper {
	
	/**
	 * 查询权限信息 
	 * @return
	 */
	List<RoleAuthority> findRoleAuthority();
	

}
