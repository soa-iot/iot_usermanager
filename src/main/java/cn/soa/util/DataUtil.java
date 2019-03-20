
/**
 * <一句话功能描述>
 * <p>数据处理工具类
 * @author 陈宇林
 * @version [版本号, 2019年2月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.Node;

public class DataUtil {

	/**
	 * 获取资源的子级资源
	 * @param parentResourceInfo 需要获取子节点的节点
	 * @param resourceInfos 所有节点
	 * @return
	 */
	public static List<Node> findChildNode(IotUserModuleResource parentResourceInfo,List<IotUserModuleResource> resourceInfos) {
		
		List<Node> children = new ArrayList<Node>();
		
		for(IotUserModuleResource resourceInfo : resourceInfos) {
			
			if(parentResourceInfo.getModId().equals(resourceInfo.getParentId())) { 
				Node node = new Node();
				node.setId(resourceInfo.getModId());
				node.setName(resourceInfo.getName());
				node.setSpread(false);
				node.setChildren(findChildNode(resourceInfo,resourceInfos));
				children.add(node);
				System.out.println(">>>>>>>>>>>>>>");
				System.out.println(resourceInfo);
			}
		}
		return children;
	}

}
