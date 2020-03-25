package cn.soa.entity;

public class IndexTempInfo {
    private String id;

    private String tempName;

    private String standby1;

    private String standby2;

    private String standby3;

    private String tempComtent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName == null ? null : tempName.trim();
    }

    public String getStandby1() {
        return standby1;
    }

    public void setStandby1(String standby1) {
        this.standby1 = standby1 == null ? null : standby1.trim();
    }

    public String getStandby2() {
        return standby2;
    }

    public void setStandby2(String standby2) {
        this.standby2 = standby2 == null ? null : standby2.trim();
    }

    public String getStandby3() {
        return standby3;
    }

    public void setStandby3(String standby3) {
        this.standby3 = standby3 == null ? null : standby3.trim();
    }

    public String getTempComtent() {
        return tempComtent;
    }

    public void setTempComtent(String tempComtent) {
        this.tempComtent = tempComtent == null ? null : tempComtent.trim();
    }
}