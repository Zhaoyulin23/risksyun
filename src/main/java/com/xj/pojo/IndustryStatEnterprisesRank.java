package com.xj.pojo;

import java.util.Date;

public class IndustryStatEnterprisesRank {
    private Integer ierId;

    private Integer iseId;

    private Integer order;

    private String name;

    private String rankBasis;

    private String rankValue;

    private String province;

    private String city;

    private String district;
    
    private Date createTime;
    
    private Date updateTime;

    public Integer getIerId() {
        return ierId;
    }

    public void setIerId(Integer ierId) {
        this.ierId = ierId;
    }

    public Integer getIseId() {
        return iseId;
    }

    public void setIseId(Integer iseId) {
        this.iseId = iseId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRankBasis() {
        return rankBasis;
    }

    public void setRankBasis(String rankBasis) {
        this.rankBasis = rankBasis == null ? null : rankBasis.trim();
    }

    public String getRankValue() {
        return rankValue;
    }

    public void setRankValue(String rankValue) {
        this.rankValue = rankValue == null ? null : rankValue.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
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