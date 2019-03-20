

	/**  
     * @Title: UserAuthority.java
 	 * @Package cn.zg.springcloud.entities.userCenter
 	 * @Description: TODO(用一句话描述该文件做什么)
 	 * @author zhugang
 	 * @date 2019年1月12日
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
 	 * @ClassName: UserAuthority
 	 * @Description: 用户中心实体类-用户信息
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */

@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class UserAuthority implements Serializable {
	private int autid;
	private int type;
	private String name;
	private String note;
	private String remark1;
	
	public UserAuthority(int type, String name, String note, String remark1) {
		this.type = type;
		this.name = name;		
		this.note = note;
		this.remark1 = remark1;
	}
		
}
