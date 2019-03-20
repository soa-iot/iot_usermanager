
/**
 * <一句话功能描述>
 * <p>角色权限实体类
 * @author 陈宇林
 * @version [版本号, 2019年2月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class RoleAuthority {
	
	private String autid;//权限id
	
	private String type;//权限类型
	
	private String name;//权限名称
	
	private String note;//权限备注
	
	private String resourceName;//资源名称
	
	private String url;//资源url
	
	private String describe;//资源描述
	
	private String modId;//资源id
	
	private String parentId;//父级id
	

}
