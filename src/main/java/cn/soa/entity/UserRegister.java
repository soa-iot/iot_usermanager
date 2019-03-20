/**  
 * @Title: UserOrganization.java
 * @Package cn.zg.springcloud.entities.userCenter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月9日
 * @version V1.0  
 */

        
package cn.soa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: UserOrganization
 * @Description: 用户中心实体类-用户组织
 * @author zhugang
 * @date 2019年1月9日
 *
 */

@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
@Validated
public class UserRegister implements Serializable{
	
	/**   
	 * @Fields serialVersionUID : 序列化   
	 */  
	private static final long serialVersionUID = 1L;
	
	private String regid;
	
	@NotNull(message="用户标识不能为空")
	private String num;
	
	@NotBlank(message="用户名不能为空")
	private String name;	
	
	private Date create_time;	
	private Integer state;	
	
	@NotBlank(message="用户备注不能为空")
	private String note;
	private Integer remark1;
	private String remark2;
	
	public UserRegister( String num, String name, Integer state, String note) {
		this.num = num;
		this.name = name;
		this.state = state;
		this.note = note;
	}
}
