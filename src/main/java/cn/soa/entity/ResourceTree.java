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
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 菜单资源树实体类
 * @author Administrator
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceTree implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;                 //权限ID
	private String rid;                //资源ID
	private String title;               //资源名称
	private boolean spread = true;     //资源是否展开
	private List<ResourceTree> children = new LinkedList<ResourceTree>();     //子节点
	
}
