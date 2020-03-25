
/**
 * <一句话功能描述>
 * <p>待办任务详情实体类
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
public class TodoTask {
	
	private String taskInstName;//任务实例名称
	
	private String starter;//任务启动人
	
	private String arriveDate;//任务到达时间
	
	private String proInstId;//piid
	
	private String taskInstPotentialOwner;//任务所有人
	
	private String taskInstId;//任务实例id
	
	private String taskState;//任务状态：一般、紧急

}
