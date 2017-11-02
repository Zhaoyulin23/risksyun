package com.xj.pojo;

import java.util.Date;

public class RegEconomicsEnterprisesRank {
    private Integer rerId;

    private Integer rgeId;

    private Integer order;

    private String enterprisesName;

    private String rankBasis;

    private Integer rankBasisValue;

    private String industryCategory;

    private String industryClass;

    private String industryKind;
    
    private Date createTime;
    
    private Date updateTime;

    public Integer getRerId() {
        return rerId;
    }

    public void setRerId(Integer rerId) {
        this.rerId = rerId;
    }

    public Integer getRgeId() {
        return rgeId;
    }

    public void setRgeId(Integer rgeId) {
        this.rgeId = rgeId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getEnterprisesName() {
        return enterprisesName;
    }

    public void setEnterprisesName(String enterprisesName) {
        this.enterprisesName = enterprisesName == null ? null : enterprisesName.trim();
    }

    public String getRankBasis() {
        return rankBasis;
    }

    public void setRankBasis(String rankBasis) {
        this.rankBasis = rankBasis == null ? null : rankBasis.trim();
    }

    public Integer getRankBasisValue() {
        return rankBasisValue;
    }

    public void setRankBasisValue(Integer rankBasisValue) {
        this.rankBasisValue = rankBasisValue;
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