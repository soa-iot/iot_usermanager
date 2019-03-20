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
 * @ClassName: UserRole
 * @Description: 用户中心实体类-用户角色
 * @author zhugang
 * @date 2019年1月11日
 *
 */
@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class UserRole implements Serializable {
	
	private String rolid;
	private String name;
	private Integer state;
	private String create_time;
	private String last_modify_time;
	private String note;
	private Integer remark1;
	private String remark2;
	
	
	public UserRole(String name, Integer state, String note, Integer remark1, String remark2){
		this.name = name;
		this.state = state;
		this.note = note;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}
}
