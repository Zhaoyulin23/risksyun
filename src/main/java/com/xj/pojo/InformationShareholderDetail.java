package com.xj.pojo;

public class InformationShareholderDetail {
    private Integer isdId;

    private Integer isId;

    private String shareholders;

    private String contributionAmount;

    private String ratio;

    private Integer sbType;
    
    private ShareholdersBackgroundType shareholdersBackgroundType;

    public Integer getIsdId() {
        return isdId;
    }

    public void setIsdId(Integer isdId) {
        this.isdId = isdId;
    }

    public Integer getIsId() {
        return isId;
    }

    public void setIsId(Integer isId) {
        this.isId = isId;
    }

    public String getShareholders() {
        return shareholders;
    }

    public void setShareholders(String shareholders) {
        this.shareholders = shareholders == null ? null : shareholders.trim();
    }

    public String getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(String contributionAmount) {
        this.contributionAmount = contributionAmount == null ? null : contributionAmount.trim();
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio == null ? null : ratio.trim();
    }

	public Integer getSbType() {
		return sbType;
	}

	public void setSbType(Integer sbType) {
		this.sbType = sbType;
	}

	public ShareholdersBackgroundType getShareholdersBackgroundType() {
		return shareholdersBackgroundType;
	}

	public void setShareholdersBackgroundType(
			ShareholdersBackgroundType shareholdersBackgroundType) {
		this.shareholdersBackgroundType = shareholdersBackgroundType;
	}

   
}