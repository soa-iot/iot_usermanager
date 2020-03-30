package cn.soa.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class IotUserModuleResource {
	
	private String modId;

	private String name;

	private String url;

	private String describe;

	private Date createTime;

	private Date lastModifyTime;

	private String remark1;

	private String parentId;

	private String isParent;

	private String menuIcon;

	private String standby2;

	private String standby3;

	private String standby4;

}