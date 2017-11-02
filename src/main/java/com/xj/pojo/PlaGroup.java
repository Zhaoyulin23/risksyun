package com.xj.pojo;

import java.util.List;

public class PlaGroup {
    private Integer groupId;

    private String groupName;
    
    private List<PlaFun> plafunList;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

	public List<PlaFun> getPlafunList() {
		return plafunList;
	}

	public void setPlafunList(List<PlaFun> plafunList) {
		this.plafunList = plafunList;
	}
    
}