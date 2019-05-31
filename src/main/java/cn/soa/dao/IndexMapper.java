
/**
 * <一句话功能描述>
 * <p>
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.soa.entity.NoticeInfo;
import cn.soa.entity.TodoTask;

@Mapper
public interface IndexMapper {
	/**
	 * 查询代办数量
	 */
	public Map<String, String> getTodoCount(String userName);
	
	/**
	 * 统计设备异常数量
	 * @return
	 */
	public Map<String, String> getEquExceptionCount();
	
	/**
	 * 查询隐患问题数量
	 * @return
	 */
	public Map<String,String> getProblemWarnCount();
	
	/**
	 * 查询警告数量
	 * @return
	 */
	public Map<String, String> getWarnInfoCount();
	
	/**
	 * 统计任务完成率
	 * @return
	 */
	public Map<String,String> getTaskFinishedRate();
	
	/**
	 * 统计问题整改率
	 * @return
	 */
	public Map<String, String> getProblemRectifyRate();
	
	/**
	 * 查询待办任务详细数据
	 * @return
	 */
	public List<TodoTask> getTodoTaskList(String userName);
	
	/**
	 * 查询消息提醒详细数据
	 * @return
	 */
	public List<NoticeInfo> getNoticeInfo();
	
	
}
