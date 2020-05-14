package cn.soa.dao.usermanagement;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.UserOrganization;


/**
 * 组织管理持久层
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
@Mapper
public interface OrganManagementMapper {
	
	/**
	 * 添加人员组织关系
	 * @param usernum - 用户账号
	 * @param orgid - 人员组织ID
	 */
	Integer insertUserOrgan(@Param("usernum") String usernum, @Param("name") String name, @Param("parentId") String parentId, @Param("password") String password);
	
	/**
	 * 更新人员组织关系
	 * @param usernum - 用户账号
	 * @param orgid - 人员组织ID
	 */
	Integer updateUserOrga(@Param("usernum") String usernum, @Param("name") String name,  @Param("parentId") String parentId,  @Param("password") String password);
	
	
	/**
	 * 查询所有人员组织信息
	 */
	List<UserOrganization> findAllOrgans();
}
