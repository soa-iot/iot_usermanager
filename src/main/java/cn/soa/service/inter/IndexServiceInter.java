
/**
 * <一句话功能描述>
 * <p>首页服务层
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service.inter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.soa.entity.IndexTempInfo;
import cn.soa.entity.IotIndexInfo;



public interface IndexServiceInter {
	/**
	 * 获取首页数据
	 * @param userName
	 * @return
	 */
	public Map<String,Object> getIndexData(String userName);
	
	/**
	 * 保存首页编辑后的数据（块元素的位置、大小等信息）
	 * @param datas
	 * @return
	 */
	public int saveIndexEditData(List<IotIndexInfo> datas);
	
	/**
	 * 根据用户角色id获取其对应的首页编辑信息
	 * @param roleId
	 * @return
	 */
	public List<IotIndexInfo> getIndexEditData();

	/**
	 * @return
	 */
	public List<IndexTempInfo> getIndexTempIndfo();

}
