package cn.soa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息VO实体类
 * @author Jiang, Hang
 * @date 2020-03-30
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String usernum;	           //用户账号
	private String nname;              //用户姓名
	private Integer age;               //用户年龄
	private Integer sex;               //用户性别
	private String address;            
	private String telephone;          //用户手机号
	private String email;              
	private Date create_time;          //用户创建时间
	private Date last_modify_time;     //最新修改时间时间
	private Integer state;             //用户状态
	private String picture;             //用户头像
	private UserOrganization organ;     //用户所属部门信息
	private List<UserRole> roles;       //用户所属角色列表

}
