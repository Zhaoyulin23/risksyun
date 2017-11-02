package com.xj.pojo;

import java.util.Date;

public class SignleEnterprise {
    private Integer seId;

    private String seName;

    private String seCreditCode;

    private String seWebsite;

    private String seRegisteredAddress;

    private Integer seProvince;

    private Integer seCity;

    private Integer seDistrict;

    private String seRegisteredCapital;

    private Integer seIndustryCategory;

    private Integer seIndustryClass;

    private Integer seIndustrySclass;

    private Integer seXjCategory;

    private Integer seXjClass;

    private Integer seXjSclass;

    private String seIntroduction;

    private String seType;

    private String legalRepresentative;

    private Date establishmentDate;

    private String operationPeriod;

    private String registrationStatus;

    private String scopeOfBusiness;

    private String mainBusiness;

    private String membershipGroup;

    private String staffNumber;

    private String websitesCollection;
    
    private Integer author;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Integer isDel;
    
    private PlaUser plaUser;
    
    
	public PlaUser getPlaUser() {
		return plaUser;
	}

	public void setPlaUser(PlaUser plaUser) {
		this.plaUser = plaUser;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
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

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}


    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public String getSeName() {
        return seName;
    }

    public void setSeName(String seName) {
        this.seName = seName == null ? null : seName.trim();
    }

    public String getSeCreditCode() {
        return seCreditCode;
    }

    public void setSeCreditCode(String seCreditCode) {
        this.seCreditCode = seCreditCode == null ? null : seCreditCode.trim();
    }

    public String getSeWebsite() {
        return seWebsite;
    }

    public void setSeWebsite(String seWebsite) {
        this.seWebsite = seWebsite == null ? null : seWebsite.trim();
    }

    public String getSeRegisteredAddress() {
        return seRegisteredAddress;
    }

    public void setSeRegisteredAddress(String seRegisteredAddress) {
        this.seRegisteredAddress = seRegisteredAddress == null ? null : seRegisteredAddress.trim();
    }

    public Integer getSeProvince() {
        return seProvince;
    }

    public void setSeProvince(Integer seProvince) {
        this.seProvince = seProvince;
    }

    public Integer getSeCity() {
        return seCity;
    }

    public void setSeCity(Integer seCity) {
        this.seCity = seCity;
    }

    public Integer getSeDistrict() {
        return seDistrict;
    }

    public void setSeDistrict(Integer seDistrict) {
        this.seDistrict = seDistrict;
    }

    public String getSeRegisteredCapital() {
        return seRegisteredCapital;
    }

    public void setSeRegisteredCapital(String seRegisteredCapital) {
        this.seRegisteredCapital = seRegisteredCapital == null ? null : seRegisteredCapital.trim();
    }

    public Integer getSeIndustryCategory() {
        return seIndustryCategory;
    }

    public void setSeIndustryCategory(Integer seIndustryCategory) {
        this.seIndustryCategory = seIndustryCategory;
    }

    public Integer getSeIndustryClass() {
        return seIndustryClass;
    }

    public void setSeIndustryClass(Integer seIndustryClass) {
        this.seIndustryClass = seIndustryClass;
    }

    public Integer getSeIndustrySclass() {
        return seIndustrySclass;
    }

    public void setSeIndustrySclass(Integer seIndustrySclass) {
        this.seIndustrySclass = seIndustrySclass;
    }

    public Integer getSeXjCategory() {
        return seXjCategory;
    }

    public void setSeXjCategory(Integer seXjCategory) {
        this.seXjCategory = seXjCategory;
    }

    public Integer getSeXjClass() {
        return seXjClass;
    }

    public void setSeXjClass(Integer seXjClass) {
        this.seXjClass = seXjClass;
    }

    public Integer getSeXjSclass() {
        return seXjSclass;
    }

    public void setSeXjSclass(Integer seXjSclass) {
        this.seXjSclass = seXjSclass;
    }

    public String getSeIntroduction() {
        return seIntroduction;
    }

    public void setSeIntroduction(String seIntroduction) {
        this.seIntroduction = seIntroduction == null ? null : seIntroduction.trim();
    }

    public String getSeType() {
        return seType;
    }

    public void setSeType(String seType) {
        this.seType = seType;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getOperationPeriod() {
        return operationPeriod;
    }

    public void setOperationPeriod(String operationPeriod) {
        this.operationPeriod = operationPeriod == null ? null : operationPeriod.trim();
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus == null ? null : registrationStatus.trim();
    }

    public String getScopeOfBusiness() {
        return scopeOfBusiness;
    }

    public void setScopeOfBusiness(String scopeOfBusiness) {
        this.scopeOfBusiness = scopeOfBusiness == null ? null : scopeOfBusiness.trim();
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
    }

    public String getMembershipGroup() {
        return membershipGroup;
    }

    public void setMembershipGroup(String membershipGroup) {
        this.membershipGroup = membershipGroup == null ? null : membershipGroup.trim();
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber == null ? null : staffNumber.trim();
    }

    public String getWebsitesCollection() {
        return websitesCollection;
    }

    public void setWebsitesCollection(String websitesCollection) {
        this.websitesCollection = websitesCollection == null ? null : websitesCollection.trim();
    }
}