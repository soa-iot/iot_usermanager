package cn.soa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IndexInfoRole {
    private String id;

    private String roleId;

    private String pageId;

    private String pageName;

    private String roleName;
}