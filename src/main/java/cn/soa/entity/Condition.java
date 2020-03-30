
/**
 * <一句话功能描述>
 * <p> 请求参数实体类
 * @author 陈宇林
 * @version [版本号, 2020年3月10日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Condition {

	private String roleName;//角色名称

	private int page;//当前页码
	
	private int limit;//每页数据条数
}
