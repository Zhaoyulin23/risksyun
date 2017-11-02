package com.xj.pojo;

import java.util.Date;

public class RegEconomicsMain {
    private Integer remId;

    private String province;

    private String city;

    private String district;

    private String govPortWebsite;

    private String statDeptWebsite;

    private String bureauFinanceWebsite;
    
    private Date createTime;
    
    private Date updateTime;

    public Integer getRemId() {
        return remId;
    }

    public void setRemId(Integer remId) {
        this.remId = remId;
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

    public String getGovPortWebsite() {
        return govPortWebsite;
    }

    public void setGovPortWebsite(String govPortWebsite) {
        this.govPortWebsite = govPortWebsite == null ? null : govPortWebsite.trim();
    }

    public String getStatDeptWebsite() {
        return statDeptWebsite;
    }

    public void setStatDeptWebsite(String statDeptWebsite) {
        this.statDeptWebsite = statDeptWebsite == null ? null : statDeptWebsite.trim();
    }

    public String getBureauFinanceWebsite() {
        return bureauFinanceWebsite;
    }

    public void setBureauFinanceWebsite(String bureauFinanceWebsite) {
        this.bureauFinanceWebsite = bureauFinanceWebsite == null ? null : bureauFinanceWebsite.trim();
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