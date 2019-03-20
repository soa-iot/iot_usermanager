/**  
 * @Title: UserInfo.java
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
 * @ClassName: UserInfo
 * @Description: 用户中心实体类-用户信息
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
public class UserInfo implements Serializable{
	
	@NotNull(message="用户信息id不能为空")
	private String usernum;	
	
	private String nname;
	
	private Integer age;
	
	private Integer sex;
	
	private String address;
	
	private String telephone;
	private String email;
	private Date create_time;
	private Date last_modify_time;
	private String note;
	private Integer remark1;
	private String remark2;
}
