/**  
 * @Title: UserRole.java
 * @Package cn.zg.springcloud.entities.userCenter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月11日
 * @version V1.0  
 */

        
package cn.soa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户角色VO实体类
 * @author Administrator
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String rolid;
	private String name;
	private Integer state;
	private String create_time;
	private String last_modify_time;
	private String note;
	private List<IotUserModuleResource> resources;
	
}
