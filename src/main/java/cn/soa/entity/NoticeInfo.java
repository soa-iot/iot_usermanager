
/**
 * <一句话功能描述>
 * <p>消息提醒实体类
 * @author 陈宇林
 * @version [版本号, 2019年5月17日]
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
public class NoticeInfo {
	
	private String taskType;//任务类型
	
	private String taskClass;//任务类
	
	private String taskName;//任务名称
	
	private String executor;//执行者
	
	private String startTime;//任务开始时间
	
	private String plannedCompletionTime;//计划完成时间
	
	private String overTime;//超时时间
	
	private String piid;//piid
	
	

}
