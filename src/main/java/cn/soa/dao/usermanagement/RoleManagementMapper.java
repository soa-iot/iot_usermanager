package cn.soa.dao.usermanagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 角色管理持久层
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
@Mapper
public interface RoleManagementMapper {
	
	/**
	 * 添加用户角色
	 * @param usernum - 用户账号
	 * @param rolid - 角色ID
	 */
	Integer insertUserRole(@Param("usernum") String usernum, @Param("rolid") String rolid);
	
}
