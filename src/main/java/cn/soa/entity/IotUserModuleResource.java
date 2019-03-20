package cn.soa.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors( chain=true )
public class IotUserModuleResource {
    private String modId;

    private String name;

    private String url;

    private String describe;

    private String createTime;

    private String lastModifyTime;

    private String remark1;

    private String parentId;
    
    private String isParent;

    
}