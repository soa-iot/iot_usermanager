
/**
 * <一句话功能描述>
 * <p>权限资源 -业务层接口
 * @author 陈宇林
 * @version [版本号, 2019年2月2日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service.inter;

import java.util.List;
import java.util.Map;

import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.Node;

public interface ResourceServiceInter {
	
	
	/**
	 * 获取所有的权限资源
	 * @return
	 */
	List<IotUserModuleResource> getResourceInfo();
	
	/**
	 * 根据id删除权限资源信息，并返回影响数据条数
	 * @return
	 */
	int delResourceInfoById(String modId);
	
	/**
	 * 获取父级资源id和名称
	 * @return
	 */
	List<Map<String,String>> getParentResource();
	
	/**
	 * 添加资源
	 * @param resource 资源对象
	 * @return 影响数据条数
	 */
	Integer addResourceInfo(IotUserModuleResource resource);
	
	/**
	 * 更新资源
	 * @param resource 资源对象
	 * @return 影响数据条数
	 */
	Integer updateResourceInfo(IotUserModuleResource resource);
	
	
	/**
	 * 获取指定格式的资源信息
	 * @return
	 */
	List<Node> getResourceInfoOfNode();

}
