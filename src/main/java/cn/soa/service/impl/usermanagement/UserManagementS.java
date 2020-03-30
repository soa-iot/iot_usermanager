package cn.soa.service.impl.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.soa.dao.usermanagement.UserManagementMapper;
import cn.soa.entity.UserInfoVO;
import cn.soa.entity.UserQueryCondition;
import cn.soa.service.inter.usermanagement.UserManagementSI;
import cn.soa.entity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户信息管理业务层实现类
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */
@Service
@Slf4j
public class UserManagementS implements UserManagementSI {
	
	@Autowired
	private UserManagementMapper umMapper;
	
	/**
	 * 根据条件获取用户信息列表
	 * @param query - 查询的条件
	 * @return List<UserInfoVO> - 用户信息列表
	 */
	@Override
	public ResponseEntity<List<UserInfoVO>> getUsersByCondition(UserQueryCondition query){
		log.info("-----开始条件查询用户信息列表-----");
		try {
			ResponseEntity<List<UserInfoVO>> info = new ResponseEntity<List<UserInfoVO>>();
			info.setCode(0);
			info.setMsg("条件查询用户信息列表成功");
			//统计用户信息条数
			Integer count = umMapper.countUsersByCondition(query);
			if(count == 0) {
				log.info("-----条件查询用户信息数量为0-----");
				return info;
			}
			//查询用户信息列表
			List<UserInfoVO> list = umMapper.findUsersByCondition(query);
			log.info("--{}", list);
			log.info("-----条件查询用户信息列表成功-----");
			info.setCount(count);
			info.setData(list);
			return info;
			
		}catch (Exception e) {
			log.info("-----条件查询用户信息列表发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 设置用户状态
	 * @param usernum - 用户账号
	 * @param state - 用户状态码： 1-正常，2-禁用
	 */
	@Override
	@Transactional
	public Boolean setUserState(String usernum, Integer state) {
		log.info("-----开始设置用户状态-----");
		try {
			umMapper.updateUserState(usernum, state);
			umMapper.updateOrganState(usernum, state);
			
			log.info("-----设置用户状态成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----设置用户状态发生错误-----");
			log.info("--{}", e);
			throw new RuntimeException("设置用户状态发生异常");
		}
	};
}
