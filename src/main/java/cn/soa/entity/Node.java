
/**
 * <一句话功能描述>
 * <p>资源层级实体
 * @author 陈宇林
 * @version [版本号, 2019年2月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class Node {
	
	private String name;//节点名称
	private boolean spread;//是否展开
	private String id;//id
	private List<Node> children;
}
