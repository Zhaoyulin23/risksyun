package com.xj.pojo;

import java.util.Date;

public class InformationNegative {
    private Integer inId;

    private Integer seId;

    private Date idDate;

    private Integer type;

    private String amount;

    private String incident;
    
	private InformationNegativeType informationNegativeType;

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public Date getIdDate() {
        return idDate;
    }

    public void setIdDate(Date idDate) {
        this.idDate = idDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident == null ? null : incident.trim();
    }

	public InformationNegativeType getInformationNegativeType() {
		return informationNegativeType;
	}

	public void setInformationNegativeType(
			InformationNegativeType informationNegativeType) {
		this.informationNegativeType = informationNegativeType;
	}
    
}