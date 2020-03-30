package cn.soa.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户查询条件实体类
 * @author Jiang, Hang
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String usernum;                 //用户账号
	private String nname;                   //用户姓名
	private Integer state;                  //用户状态
	private Integer page;                   //页数
	private Integer limit;                  //每页行数
	private String orderField;              //排序字段
	private String orderName;               //排序类型   ASC-正序，DESC-倒序
}
