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
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
@Validated
public class UserTest implements Serializable{
	
	/**   
	 * @Fields serialVersionUID : 序列化   
	 */  
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Integer pId;
	
	private Integer id;
	
	public UserTest(String name, Integer id, Integer pId) {
		this.name = name;
		this.id = id;
		this.pId = pId;
	}

	

}
