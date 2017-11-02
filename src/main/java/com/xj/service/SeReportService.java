package com.xj.service;

import java.util.List;

import com.xj.pojo.SeReport;
import com.xj.pojo.SeReportType;

public interface SeReportService {
	
	public List<SeReport> getSeReportListBySeId(Integer seId);
	
	public SeReport getSeReport(Integer reportId);
	
	public int addSeReport(SeReport seReport);
	
	public int updateSeReport(SeReport seReport);
	
	public int deleteSeReport(Integer reportId);
	
	public List<SeReportType> getSeReportTypeList();

}
