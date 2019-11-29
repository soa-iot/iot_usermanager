package cn.soa.entity;

public class AccountExtends {
    private Integer eId;

    private String userOrganId;

    private String accountName;

    private String accountPhone;

    private String accountEmail;

    private Integer accountPicture;

    private String remark1;

    private String remark2;

    private String remark3;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getUserOrganId() {
        return userOrganId;
    }

    public void setUserOrganId(String userOrganId) {
        this.userOrganId = userOrganId == null ? null : userOrganId.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone == null ? null : accountPhone.trim();
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail == null ? null : accountEmail.trim();
    }

    public Integer getAccountPicture() {
        return accountPicture;
    }

    public void setAccountPicture(Integer accountPicture) {
        this.accountPicture = accountPicture;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }
}