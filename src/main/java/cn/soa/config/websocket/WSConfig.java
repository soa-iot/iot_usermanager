/**  
 * @Title: WSConfig.java
 * @Package cn.userCenter.config.shiro
 * @Description: )
 * @author zhugang
 * @date 2019年1月24日
 * @version V1.0  
 */

        
package cn.soa.config.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
  * @ClassName: WSConfig
  * @Description: WS服务配置类
  * @author zhugang
  * @date 2019年1月24日
  */

@Configuration
public class WSConfig {
	
	 /**   
	  * @Title: getNoticeList   
	  * @Description:  “通知”对象的容器      
	  * @return: HashMap<String,LinkedList<String>>        
	  */  
	@Bean("tempNoticeList") 
	public ArrayList<HashMap<String,Object>> getNoticeList(){
		ArrayList<HashMap<String,Object>> tempNoticeList = new ArrayList<HashMap<String,Object>>();
		return tempNoticeList;
	}
	
	
	 /**   
	  * @Title: getNumber   
	  * @Description:  “时间次数”对象的容器         
	  * @return: HashMap<String,LinkedList<Long>>        
	  */  
//	@Bean("numberMap") 
//	public HashMap<String,LinkedList<Long>> getNumber(){
//		LinkedList<Long> linkedList = new LinkedList<Long>();
//		HashMap<String, LinkedList<Long>> numberMap = new HashMap<String,LinkedList<Long>>();
//		return numberMap;
//	}

	@Bean 
	public ServerEndpointExporter serverEndpointExporter() {		
		return new ServerEndpointExporter();		
	}  
}
