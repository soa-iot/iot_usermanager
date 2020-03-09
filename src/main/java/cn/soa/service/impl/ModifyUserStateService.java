package cn.soa.service.impl;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.soa.dao.UserMapper;
import cn.soa.entity.UserOrganization;
import cn.soa.service.inter.ModifyUserStateInter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ModifyUserStateService implements ModifyUserStateInter{
	
	@Autowired
	private RocketMQTemplate rocketMQTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
	/**   
	 * @Title: modifyUserStateById   
	 * @Description: 向MQ预发消息
	 * @return: int        
	 */  
	@Override
	public boolean sendUserToMQ( UserOrganization user) {
		log.info("---sendUserToMQ------向MQ预发消息 ------");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user", user);
		Message<String> message = MessageBuilder.withPayload(jsonObject.toJSONString()).build();
		TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction("process-back-send", "process-back", message, null);
		if( "SEND_OK".equals(sendResult.getSendStatus().toString())) {
			log.info("send transcation message body={},result={}",message.getPayload(),sendResult.getSendStatus());
			return true;
		}
		return false;
	}
	
	/**   
	 * @Title: modifyUserStateById   
	 * @Description: 根据用户id修改用户状态   - 本地事务 
	 * @return: int        
	 */  
	@Override
	public void modifyUserStateById( UserOrganization user) {
		log.info("---modifyUserStateById------开始执行本地事务 - 根据用户id修改用户状态 ------");
		log.info("事务号：" + user.getRemark2());
		userMapper.updateStateAndRemark2ById(user.getOrgid(),user.getRemark2());			
		log.info("本地事务执行完成，事务号：" + user.getRemark2());
	}

}
