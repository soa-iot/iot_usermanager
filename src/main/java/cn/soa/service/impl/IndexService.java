
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
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import cn.soa.dao.IndexInfoMapper;
import cn.soa.dao.IndexInfoRoleMapper;
import cn.soa.dao.IndexMapper;
import cn.soa.dao.IndexTempInfoMapper;
import cn.soa.dao.UserRoleMapper;
import cn.soa.entity.Condition;
import cn.soa.entity.IndexInfoRole;
import cn.soa.entity.IndexTempInfo;
import cn.soa.entity.IotIndexInfo;
import cn.soa.entity.NoticeInfo;
import cn.soa.entity.TodoTask;
import cn.soa.entity.UserRole;
import cn.soa.service.inter.IndexServiceInter;
import cn.soa.util.GlobalUtil;
import cn.soa.util.ZipUtils;

@Service
public class IndexService implements IndexServiceInter {

	@Autowired
	private IndexMapper indexMapper;

	@Autowired
	private IndexInfoMapper indexInfoMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private IndexInfoRoleMapper indexInfoRoleMapper;
	
	@Autowired
	private IndexTempInfoMapper indexTempInfoMapper;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.soa.service.inter.IndexServiceInter#saveIndexEditData(java.util.List)
	 */
	@Override
	public int saveIndexEditData(List<IotIndexInfo> datas) {

		/**
		 * 获取当前用户的roleId
		 */
		String userNum = GlobalUtil.getCookie("num").replaceAll("\"", "");
		List<UserRole> userRoles = userRoleMapper.findUserRoleByNum(userNum);

		/**
		 * 先删除当前roleid所对应的数据
		 */
		indexInfoMapper.deleteByRoleId(userRoles);
		indexInfoRoleMapper.deleteRecords(userRoles);


		int num = 0;
		String pageId = UUID.randomUUID().toString().replaceAll("-", "");

		for (IotIndexInfo data : datas) {
			data.setPageId(pageId);
			try {
				int result = indexInfoMapper.insertSelective(data);
				if (result > 0) {
					num++;
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		/**
		 * 保存首页信息  角色关系
		 */
		for(UserRole role :userRoles) {
			IndexInfoRole indexInfoRole = new IndexInfoRole();
			indexInfoRole.setPageId(pageId);
			indexInfoRole.setRoleId(role.getRolid());
			indexInfoRoleMapper.insertSelective(indexInfoRole);
		}
		

		return num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.soa.service.inter.IndexServiceInter#getIndexEditData(java.lang.String)
	 */
	@Override
	public List<IotIndexInfo> getIndexEditData() {
		/**
		 * 获取当前用户的roleId
		 */
		String userNum = GlobalUtil.getCookie("num").replaceAll("\"", "");
		List<UserRole> userRoles = userRoleMapper.findUserRoleByNum(userNum);
		List<IotIndexInfo> result = indexInfoMapper.findIndexInfoByRoleId(userRoles);
		return result;
	}

	/* (non-Javadoc)
	 * @see cn.soa.service.inter.IndexServiceInter#getIndexTempIndfo()
	 */
	@Override
	public List<IndexTempInfo> getIndexTempIndfo() {
		
		List<IndexTempInfo> result = indexTempInfoMapper.findAll();
		return result;
	}

	/* (non-Javadoc)
	 * @see cn.soa.service.inter.IndexServiceInter#getRoleIndexInfo(cn.soa.entity.Condition)
	 */
	@Override
	public List<IndexInfoRole> getRoleIndexInfo(Condition condition) {
		List<IndexInfoRole> result = indexInfoRoleMapper.selectByCondition(condition);
		return result;
	}

}
