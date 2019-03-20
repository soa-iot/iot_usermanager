package cn.soa.entity;

public class IotUserAuthority {

	private String autid;

	private String resourceid;

	private Short type;

	private String name;

	private String note;

	private Integer remark1;

	public String getAutid() {
		return autid;
	}

	public void setAutid(String autid) {
		this.autid = autid == null ? null : autid.trim();
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid == null ? null : resourceid.trim();
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public Integer getRemark1() {
		return remark1;
	}

	public void setRemark1(Integer remark1) {
		this.remark1 = remark1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IotUserAuthority [autid=" + autid + ", resourceid=" + resourceid + ", type=" + type + ", name=" + name
				+ ", note=" + note + ", remark1=" + remark1 + "]";
	}
}