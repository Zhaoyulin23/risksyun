package com.xj.pojo;

import java.util.Date;

public class RegEconomicsReport {
    private Integer rerId;

    private Integer regEcoId;

    private Date year;

    private String reportClass;

    private String reportName;

    private String type;

    private String websites;

    private String content;

    private String attachment;
    
    private Date createTime;
    
    private Date updateTime;

    public Integer getRerId() {
        return rerId;
    }

    public void setRerId(Integer rerId) {
        this.rerId = rerId;
    }

    public Integer getRegEcoId() {
        return regEcoId;
    }

    public void setRegEcoId(Integer regEcoId) {
        this.regEcoId = regEcoId;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getReportClass() {
        return reportClass;
    }

    public void setReportClass(String reportClass) {
        this.reportClass = reportClass == null ? null : reportClass.trim();
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites == null ? null : websites.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}