
	/**  
     * @Title: UserTableJson.java
 	 * @Package cn.userCenter.Entity.headResult
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月17日
 	 * @version V1.0  
 	 */

        
package cn.soa.entity.headResult;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
  * @ClassName: UserTableJson
  * @Description: 
  * @author zhugang
  * @date 2019年1月17日
  */
@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class UserTableJson<T> implements Serializable {
	/**   
	 * @Fields serialVersionUID : 序列化   
	 */  
	private static final long serialVersionUID = 812376774103405857L;
	
	/**
	 * @Fields msg : 返回信息
	 */	    
	private String msg;
	
	/**
	 * @Fields code : 请求状态
	 */
	private int code;
	
	/**
	 * @Fields tip : 返回提示信息
	 */
	private String tip;
	
	/**
	 * @Fields data : 返回数据
	 */
	private T data;
	
	/**
	 * @Fields count : 返回数据条数
	 */
	private int count;
	
	/**
	 * @Fields is : 请求是否成功
	 */
	private boolean is;
	
//	public UserTableJson(String msg, int code, T data, int count, boolean is, String tip) {
//		this.msg = "";
//	}
}
