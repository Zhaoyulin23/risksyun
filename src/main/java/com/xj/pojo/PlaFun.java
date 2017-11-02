package com.xj.pojo;

public class PlaFun {
    private Integer funId;

    private String funName;
    
    
    private String funLabel;

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

	public String getFunLabel() {
		return funLabel;
	}

	public void setFunLabel(String funLabel) {
		this.funLabel = funLabel;
	}
    
}