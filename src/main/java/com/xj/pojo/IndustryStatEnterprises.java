package com.xj.pojo;

import java.util.Date;

public class IndustryStatEnterprises {
    private Integer iseId;

    private String industryCategory;

    private String industryClass;

    private String industryKind;

    private Date year;

    private String rankName;

    private String websites;
    
    private Date createTime;
    
    private Date updateTime;

    public Integer getIseId() {
        return iseId;
    }

    public void setIseId(Integer iseId) {
        this.iseId = iseId;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory == null ? null : industryCategory.trim();
    }

    public String getIndustryClass() {
        return industryClass;
    }

    public void setIndustryClass(String industryClass) {
        this.industryClass = industryClass == null ? null : industryClass.trim();
    }

    public String getIndustryKind() {
        return industryKind;
    }

    public void setIndustryKind(String industryKind) {
        this.industryKind = industryKind == null ? null : industryKind.trim();
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites == null ? null : websites.trim();
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