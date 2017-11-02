package com.xj.pojo;

import java.util.Date;

public class InformationIpo {
    private Integer ipoId;

    private Integer seId;

    private Integer financdId;

    private String exchange;

    private Date ipoDate;

    private String ipoCode;

    public Integer getIpoId() {
        return ipoId;
    }

    public void setIpoId(Integer ipoId) {
        this.ipoId = ipoId;
    }

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public Integer getFinancdId() {
        return financdId;
    }

    public void setFinancdId(Integer financdId) {
        this.financdId = financdId;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    public Date getIpoDate() {
        return ipoDate;
    }

    public void setIpoDate(Date ipoDate) {
        this.ipoDate = ipoDate;
    }

    public String getIpoCode() {
        return ipoCode;
    }

    public void setIpoCode(String ipoCode) {
        this.ipoCode = ipoCode == null ? null : ipoCode.trim();
    }
}