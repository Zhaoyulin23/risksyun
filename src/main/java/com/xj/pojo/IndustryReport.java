package com.xj.pojo;

import java.util.Date;

public class IndustryReport {
    private Integer industryStatisticsId;

    private Date year;

    private String reportClass;

    private String name;

    private String region;

    private String websites;

    private String content;

    private String attachment;
    
    private Date createTime;
    
    private Date updateTime;

    public Integer getIndustryStatisticsId() {
        return industryStatisticsId;
    }

    public void setIndustryStatisticsId(Integer industryStatisticsId) {
        this.industryStatisticsId = industryStatisticsId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
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