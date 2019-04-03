
/**
 * <一句话功能描述>
 * <p>权限资源（模块、菜单等）-控制层
 * @author 陈宇林
 * @version [版本号, 2019年2月2日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.soa.entity.IotUserModuleResource;
import cn.soa.entity.Node;
import cn.soa.entity.headResult.ResultJson;
import cn.soa.entity.headResult.UserTableJson;
import cn.soa.service.inter.ResourceServiceInter;

@RestController
@RequestMapping("/resource")
public class ResourceControl {

	@Autowired
	private ResourceServiceInter resourceService;

	/**
	 * 获取所有权限资源（模块、菜单等）信息
	 * 
	 * @return
	 */
	@RequestMapping("/getAllResourceInfo")
	public UserTableJson<List<IotUserModuleResource>> getAllResourceInfo() {

		List<IotUserModuleResource> resourceInfo = resourceService.getResourceInfo();

		UserTableJson<List<IotUserModuleResource>> reObj = new UserTableJson<List<IotUserModuleResource>>("success", 0,
				"查询成功", resourceInfo, resourceInfo.size(), true);

		return reObj;
	}

	/**
	 * 根据id删除权限资源（模块、菜单等）信息,其子级也将被删除，
	 * 其对应的权限、以及该权限对应的权限关系也将被删除
	 * 
	 * @param modId
	 *            权限id
	 * @return 影响数据条数
	 */
	@RequestMapping("/delResourceInfoById")
	public ResultJson<Integer> delResourceInfoById(@RequestParam("modId") String modId) {

		Integer num = resourceService.delResourceInfoById(modId);
		ResultJson<Integer> reObj = new ResultJson<Integer>(0, "删除数据成功", num);

		return reObj;
	}

	/**
	 * 获取父级资源id和名称
	 * 
	 * @return
	 */
	@RequestMapping("/getParentResource")
	public ResultJson<List<Map<String, String>>> getParentResource() {
		List<Map<String, String>> data = resourceService.getParentResource();
		ResultJson<List<Map<String, String>>> reObj = new ResultJson<List<Map<String, String>>>(0, "查询数据成功", data);

		return reObj;
	}

	/**
	 * 添加数据
	 * @param resource
	 * @return
	 */
	@RequestMapping("/addResource")
	public ResultJson<String> addResourceInfo(IotUserModuleResource resource) {

		System.out.println(resource);
		Integer result = resourceService.addResourceInfo(resource);
		ResultJson<String> reObj = new ResultJson<String>(0, "添加数据成功", result + "");
		return reObj;
	}
	
	/**
	 * 更新数据
	 * @param resource
	 * @return
	 */
	@RequestMapping("/updateResource")
	public ResultJson<String> updateResource(IotUserModuleResource resource){
		System.out.println(resource);
		Integer result = resourceService.updateResourceInfo(resource);
		ResultJson<String> reObj = new ResultJson<String>(0, "添加数据成功", result + "");
		return reObj;
		
		
	}
	
	/**
	 * 按指定格式获取资源信息
	 * @return
	 */
	@RequestMapping("/getResourceInfoOfNode")
	public ResultJson<List<Node>> getResourceInfoOfNode(){
		List<Node> nodes = resourceService.getResourceInfoOfNode();
		ResultJson<List<Node>> reObj = new ResultJson<List<Node>>(0, "查询数据成功！！！", nodes);
		return reObj;
	}
	
}
