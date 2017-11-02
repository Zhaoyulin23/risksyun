package com.xj.pojo;

public class InformationFinancing {
    private Integer ifId;

    private Integer seId;

    private Integer ipo;

    private String ipoId;

    private Integer issueBond;

    private String bondId;

    public Integer getIfId() {
        return ifId;
    }

    public void setIfId(Integer ifId) {
        this.ifId = ifId;
    }

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public Integer getIpo() {
        return ipo;
    }

    public void setIpo(Integer ipo) {
        this.ipo = ipo;
    }

    public String getIpoId() {
        return ipoId;
    }

    public void setIpoId(String ipoId) {
        this.ipoId = ipoId == null ? null : ipoId.trim();
    }

    public Integer getIssueBond() {
        return issueBond;
    }

    public void setIssueBond(Integer issueBond) {
        this.issueBond = issueBond;
    }

    public String getBondId() {
        return bondId;
    }

    public void setBondId(String bondId) {
        this.bondId = bondId == null ? null : bondId.trim();
    }
}