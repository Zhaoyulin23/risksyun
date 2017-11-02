package com.xj.pojo;

public class SeReport {
    private Integer reportId;

    private Integer seId;

    private Integer reportType;

    private String arYear;

    private String reportName;
    
    private String reportUrl;

    private String websites;
    
    private SeReportType seReportType;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public String getArYear() {
        return arYear;
    }

    public void setArYear(String arYear) {
        this.arYear = arYear == null ? null : arYear.trim();
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }
    


	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites == null ? null : websites.trim();
    }

	public SeReportType getSeReportType() {
		return seReportType;
	}

	public void setSeReportType(SeReportType seReportType) {
		this.seReportType = seReportType;
	}
    
}