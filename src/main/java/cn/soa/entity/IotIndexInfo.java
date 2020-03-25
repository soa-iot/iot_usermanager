package cn.soa.entity;

import java.util.Date;

public class IotIndexInfo {
	private String id;

	private String pageId;

	private Short positionX;

	private Short positionY;

	private Short width;

	private Short height;

	private String content;

	private Date lastModifiedDate;

	private String standby1;

	private String standby2;

	private String standby3;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}


	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId == null ? null : pageId.trim();
	}

	public Short getPositionX() {
		return positionX;
	}

	public void setPositionX(Short positionX) {
		this.positionX = positionX;
	}

	public Short getPositionY() {
		return positionY;
	}

	public void setPositionY(Short positionY) {
		this.positionY = positionY;
	}

	public Short getWidth() {
		return width;
	}

	public void setWidth(Short width) {
		this.width = width;
	}

	public Short getHeight() {
		return height;
	}

	public void setHeight(Short height) {
		this.height = height;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IotIndexInfo [id=" + id + ", pageId=" + pageId + ", positionX=" + positionX
				+ ", positionY=" + positionY + ", width=" + width + ", height=" + height + ", content=" + content
				+ ", lastModifiedDate=" + lastModifiedDate + ", standby1=" + standby1 + ", standby2=" + standby2
				+ ", standby3=" + standby3 + "]";
	}
}