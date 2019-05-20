
/**
 * <一句话功能描述>
 * <p>
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.IndexMapper;
import cn.soa.entity.NoticeInfo;
import cn.soa.entity.TodoTask;
import cn.soa.service.inter.IndexServiceInter;

@Service
public class IndexService implements IndexServiceInter {

	@Autowired
	private IndexMapper indexMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.soa.service.inter.IndexServiceInter#getIndexData(java.lang.String)
	 */
	@Override
	public Map<String, Object> getIndexData(String userName) {

		Map<String, Object> result = new HashMap<String, Object>();

		// 待办数量
		Map<String, String> todoCount = indexMapper.getTodoCount(userName);
		System.out.println(todoCount);
		result.put("total_TODO", todoCount.get("TOTAL"));

		// 设备异常数量
		Map<String, String> equExceptionCount = indexMapper.getEquExceptionCount();
		System.out.println(equExceptionCount);
		result.put("total_PROBLEM", equExceptionCount.get("TOTAL"));

		// 查询警告数量
		Map<String, String> warnCount = indexMapper.getWarnInfoCount();
		System.out.println(warnCount);
		result.put("total_WARN", warnCount.get("TOTAL"));

		// 任务完成率
		Map<String, String> taskFinishedRate = indexMapper.getTaskFinishedRate();
		System.out.println(taskFinishedRate);
		result.put("total_TASK_RATE", taskFinishedRate.get("ONEVAL"));

		// 问题整改率
		Map<String, String> problemRectifyRate = indexMapper.getProblemRectifyRate();
		System.out.println(problemRectifyRate);
		result.put("total_PROBLEMRECTIFYRATE", problemRectifyRate.get("RATE"));

		// 隐患问题数量
		Map<String, String> problemWarnCount = indexMapper.getProblemWarnCount();
		System.out.println(problemWarnCount);
		result.put("total_PROBLEM_WARN", problemWarnCount.get("TOTAL"));

		// 待办任务详细数据
		List<TodoTask> todoTaskList = indexMapper.getTodoTaskList(userName);
		System.out.println(todoTaskList);
		result.put("todoListMap", todoTaskList);

		// 消息提醒详细数据
		List<NoticeInfo> noticeInfos = indexMapper.getNoticeInfo();
		System.out.println(noticeInfos);
		result.put("noticeListMap", noticeInfos);

		return result;
	}

}
