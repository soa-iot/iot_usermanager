
        
package cn.soa.service.inter;

import java.util.List;
import java.util.Map;

import cn.soa.entity.UserLog;


/**
 	 * @ClassName: UserLogService
 	 * @Description: 
 	 * @author liuhai
 	 * @date 2020年2月26日
 	 */
public interface UserLogService {
	/**
	 * 添加日志
	 */
	public int save(UserLog userLog);
	/**
	 * 查询日志列表
	 * @return
	 */
	public List<UserLog> getUserLogList(String username,String dateTime);
	
	
	public List<Map<String, Object>> getLogCount(String username,String dateTime);
	
	public List<Map<String, Object>> getLogCountAsc(String username,String dateTime);
	
	
	public List<Map<String, Object>> getLogCountDesc(String username,String dateTime);
	
}
