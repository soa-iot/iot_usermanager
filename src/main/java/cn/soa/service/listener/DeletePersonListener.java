package cn.soa.service.listener;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;

import cn.soa.dao.UserMapper;
import cn.soa.entity.UserOrganization;
import cn.soa.service.inter.ModifyUserStateInter;
import io.netty.util.internal.StringUtil;

import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "process-back-send")
public class DeletePersonListener implements RocketMQLocalTransactionListener {

	@Autowired
	private ModifyUserStateInter modifyUserState;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
		RocketMQLocalTransactionState state;
		//解析消息
		try {
            String jsonString = new String((byte[]) message.getPayload());
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            UserOrganization user = JSONObject.parseObject(jsonObject.getString("user"), UserOrganization.class);
            //事务号           
            String tid = userMapper.findRemark2ById(user.getOrgid());
            if( tid == null || StringUtils.isEmpty(tid)) {
            	state=  RocketMQLocalTransactionState.UNKNOWN;
            }else {
            	state=  RocketMQLocalTransactionState.COMMIT;
            }
            return state;
        } catch (Exception e) {
            log.error("checkLocalTransaction 检查事务号是否存在失败",e);
            e.printStackTrace();
            return RocketMQLocalTransactionState.UNKNOWN;
        }
	}

	@Override
	public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg1) {
		//解析消息
		try {
            String jsonString = new String((byte[]) message.getPayload());
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            UserOrganization user = JSONObject.parseObject(jsonObject.getString("user"), UserOrganization.class);
            //执行本地删除
            modifyUserState.modifyUserStateById(user);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            log.error("executeLocalTransaction 事务执行失败",e);
            e.printStackTrace();
            return RocketMQLocalTransactionState.ROLLBACK;
        }
	}


}
