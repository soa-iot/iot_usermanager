package cn.soa.entity;

public class IotUserRoleAuth {
    private String rolAutId;

    private String rolid;

    private String autid;

    public String getRolAutId() {
        return rolAutId;
    }

    public void setRolAutId(String rolAutId) {
        this.rolAutId = rolAutId == null ? null : rolAutId.trim();
    }

    public String getRolid() {
        return rolid;
    }

    public void setRolid(String rolid) {
        this.rolid = rolid == null ? null : rolid.trim();
    }

    public String getAutid() {
        return autid;
    }

    public void setAutid(String autid) {
        this.autid = autid == null ? null : autid.trim();
    }
}