package cn.soa.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: AuthInfo
 * @Description: 用户权限实体类
 * @author zhugang
 * @date 2019年2月18日
 */

@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class AuthInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化   
	 */  
	private static final long serialVersionUID = 2222222L;
	
	private String id;
	
	private String first;
	
	private String second;
	
	private String url;
}
