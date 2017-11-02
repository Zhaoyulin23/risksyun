package com.xj.pojo;

import java.util.Date;
import java.util.List;

public class PlaUser {
    private Integer plaUserId;
    
    private Integer plaUserGroup;

    private String plaUserName;

    private String plaUserPwd;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;
    
    private PlaGroup plaGroup;
    
    private List<PlaFun> plafunList;

    public PlaGroup getPlaGroup() {
		return plaGroup;
	}

	public void setPlaGroup(PlaGroup plaGroup) {
		this.plaGroup = plaGroup;
	}

	public Integer getPlaUserId() {
        return plaUserId;
    }

    public void setPlaUserId(Integer plaUserId) {
        this.plaUserId = plaUserId;
    }

    public String getPlaUserName() {
        return plaUserName;
    }

    public void setPlaUserName(String plaUserName) {
        this.plaUserName = plaUserName == null ? null : plaUserName.trim();
    }

    public String getPlaUserPwd() {
        return plaUserPwd;
    }

    public void setPlaUserPwd(String plaUserPwd) {
        this.plaUserPwd = plaUserPwd == null ? null : plaUserPwd.trim();
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

	public Integer getPlaUserGroup() {
		return plaUserGroup;
	}

	public void setPlaUserGroup(Integer plaUserGroup) {
		this.plaUserGroup = plaUserGroup;
	}

	public List<PlaFun> getPlafunList() {
		return plafunList;
	}

	public void setPlafunList(List<PlaFun> plafunList) {
		this.plafunList = plafunList;
	}
	
}