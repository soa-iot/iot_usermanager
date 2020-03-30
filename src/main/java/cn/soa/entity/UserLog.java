/**  
 * @Title: UserLog.java
 * @Package cn.zg.springcloud.entities.userCenter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author liuhai
 * @date 2020年2月26日
 * @version V1.0  
 */

package cn.soa.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: UserLog
 * @Description: 用户操作日志累
 * @author liuhai
 * @date 2020年2月26日
 *
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserLog implements Serializable {
	private String id;
	private String userID;// 用户ID
	private String username; // 用户名
	private String operation; // 操作
	private String method; // 方法名
	private String params; // 参数
	private String ip; // ip地址
	private String createDate; // 操作时间
	// 创建getter和setter方法

}
