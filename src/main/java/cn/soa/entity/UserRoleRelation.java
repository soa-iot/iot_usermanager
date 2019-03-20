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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: UserRoleRelation
 * @Description: 用户中心实体类-用户角色
 * @author lixuefeng
 * @date 2019年1月11日
 *
 */
@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class UserRoleRelation implements Serializable {
	private String user_rol_id;
	private String userid;
	private String rolid;
	public UserRoleRelation(String userid, String rolid) {
		
		this.userid = userid;
		this.rolid = rolid;
	}
	
	
}
