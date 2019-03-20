
	/**  
     * @Title: LoginController.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.soa.controller;

import java.util.ArrayList;
import java.util.HashMap;


import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.controller.ws.WebSocketServerService;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.util.SpringUtil;


/**
  * @ClassName: LoginController
  * @Description: 通知 - 控制层
  * @author zhugang
  * @date 2019年1月12日
  */

@RestController
@RequestMapping("/ststem")
public class NoticeController{
	private static Logger logger = LoggerFactory.getLogger( NoticeController.class );
	
	@Autowired
	private WebSocketServerService webSocketService;
	
	@PostMapping("/notice/temp")
	public ResultJson<String> sentSystemNotice(
			@RequestParam("notice") @NotBlank String notice,
			@RequestParam("number") @NotBlank String number){
		logger.info( "-------C----------临时通知-----------");
		logger.info( "-------C----------webSocketService-----------" + webSocketService );
		logger.info( "-------C----------number-----------" + number );
		try {
			//临时系统通知加入单例容器
			ArrayList<HashMap<String,Object>> tempNoticeList = SpringUtil.getBean( 
					"tempNoticeList", new ArrayList<HashMap<String,Object>>().getClass());
			logger.info( "-------C----------tempNoticeList-----------" + tempNoticeList );
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put( "message", notice);
			map.put( "number", Long.parseLong(number) * 1000 + System.currentTimeMillis() );
			tempNoticeList.add(map);
			logger.info( "-------C----------tempNoticeList-----------" + tempNoticeList );
			
			//临时系统通知已在线用户
			webSocketService.sendInfo(notice);
		} catch ( Exception e) {
			e.printStackTrace();
			return new ResultJson<String>( 1, "发送临时通知失败", "发送临时通知失败");
		}
		return new ResultJson<String>( 0, "发送临时通知成功", "发送临时通知成功");
	}
}
