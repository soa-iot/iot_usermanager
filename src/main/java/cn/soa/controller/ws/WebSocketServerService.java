/**  
 * @Title: WebSocketServerService.java
 * @Package cn.userCenter.controller.ws
 * @Description: )
 * @author zhugang
 * @date 2019年1月24日
 * @version V1.0  
 */

        
package cn.soa.controller.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.soa.util.SpringUtil;


/**
  * @ClassName: WebSocketServerService
  * @Description: ws服务
  * @author zhugang
  * @date 2019年1月24日
  */

@Component
@ServerEndpoint(value="/push/pushVideoListToWeb")
public class WebSocketServerService {
	private static Logger logger = LoggerFactory.getLogger( WebSocketServerService.class );
	
	private static int onlineCount = 0;
	//concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	private static CopyOnWriteArraySet<WebSocketServerService> webSocketSet = new CopyOnWriteArraySet<WebSocketServerService>();
	
	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	
	@OnOpen
	public void onOpen(Session session) {
	    this.session = session;
	    webSocketSet.add(this);     //加入set中
	    addOnlineCount();           //在线数加1
	    logger.debug("-----------ws服务端通知连接成功-------");
	    logger.info("-----------有新连接加入！当前在线人数为--------" + getOnlineCount());
		try {		
//			 sendMessage("服务端通知连接成功");
			 /*
			  * 临时通知发送新用户
			  */
			//获取信息和检查(过期就不发并删除)
			@SuppressWarnings("unchecked")
			ArrayList<HashMap<String,Object>> tempNoticeList = SpringUtil.getBean( 
						"tempNoticeList", new ArrayList<HashMap<String,Object>>().getClass());
			 logger.info( tempNoticeList + "" );
			 ArrayList<Integer> removeList = new ArrayList<Integer>();
			 for( int i = 0; i < tempNoticeList.size(); i++ ) {	
				HashMap<String,Object> m = tempNoticeList.get(i);
				for( String s : m.keySet()) {
					Long time = System.currentTimeMillis();
					if( Long.parseLong(m.get("number").toString()) < time ) {
						//过期标记
						removeList.add(i);
					}else {
						sendMessage( m.get("message").toString() );
						logger.info("已发送：" + m.get("message").toString());
					}
				}
			 }
			 //过期删除
			 for( int i : removeList ) {
				 removeNotice(tempNoticeList, i);
			 }			 
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose() {
	    webSocketSet.remove(this);  //从set中删除
		subOnlineCount();           //在线数减1
		logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
	}
	 
	/**
	 * 收到客户端消息后调用的方法
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		logger.debug("---- 来自客户端的消息: ----" + message );
		String s=session.getProtocolVersion();
		//群发消息
//        for (WebSocketServerService item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
	 
	/**
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		logger.debug("-------------ws发生错误-------------------");
        error.printStackTrace();
    }	 
	 
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
 

    /**   
     * @Title: sendInfo   
     * @Description: 群发自定义消息  
     * @param: @param message      
     * @return: void        
     */  
    public static void sendInfo(String message) {
    	logger.debug( "------------群发自定义消息-----------message:" + message );
        for (WebSocketServerService item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }
 
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
 
    public static synchronized void addOnlineCount() {
    	WebSocketServerService.onlineCount++;
    }
 
    public static synchronized void subOnlineCount() {
    	WebSocketServerService.onlineCount--;
    }
    
    
     /**   
      * @Title: removeNotice   
      * @Description: 删除"通知"对象中容器中的元素       
      * @return: void        
      */  
    public static synchronized void removeNotice(
    		ArrayList<HashMap<String,Object>> tempNoticeList, int i) {
    	tempNoticeList.remove(i);
    }
}
