
/**
 * <一句话功能描述>
 * <p>
 * @author liuhai
 * @version [版本号, 2020年2月26日]
 * @see [相关类/方法]
 * @since [日志/模块版本]
 */
package cn.soa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.UserLog;

@Mapper
public interface UserLogMapper {

	/**
	 * 日志写入
	 */
	int insert(UserLog userLog);

	/**
	 * 日志查询
	 */
	List<UserLog> getUserLogList(String username,String dateTime);
	/**
	 * 日志统计登录次数最多的
	 */
	List<Map<String,Object>> getLogCount(String username,String dateTime);
	/**
	 * 日志统计登录次数最多的
	 */
	List<Map<String,Object>> getLogCountAsc(String username,String dateTime);
	/**
	 * 日志统计登录次数最少的
	 */
	List<Map<String,Object>> getLogCountDesc(String username,String dateTime);
}
