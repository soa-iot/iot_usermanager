
/**
 * <一句话功能描述>
 * <p>首页服务层
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package cn.soa.service.inter;

import java.util.Map;

import org.springframework.stereotype.Service;



public interface IndexServiceInter {
	/**
	 * 获取首页数据
	 * @param userName
	 * @return
	 */
	public Map<String,Object> getIndexData(String userName);

}
