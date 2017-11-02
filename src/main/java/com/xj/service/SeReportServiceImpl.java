package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.SeReportMapper;
import com.xj.dao.SeReportTypeMapper;
import com.xj.pojo.SeReport;
import com.xj.pojo.SeReportType;

@Service("seReportService")
public class SeReportServiceImpl implements SeReportService {

	@Autowired
	private SeReportMapper reportMapper;
	
	@Autowired
	private SeReportTypeMapper reportTypeMapper;
	
	public List<SeReport> getSeReportListBySeId(Integer seId) {
		
		return reportMapper.getSeReportListBySeId(seId);
	}

	public SeReport getSeReport(Integer reportId) {
		
		return reportMapper.selectByPrimaryKey(reportId);
	}

	public int addSeReport(SeReport seReport) {
		
		return reportMapper.insertSelective(seReport);
	}

	public int updateSeReport(SeReport seReport) {
		
		return reportMapper.updateByPrimaryKeySelective(seReport);
	}

	public int deleteSeReport(Integer reportId) {
		
		return reportMapper.deleteByPrimaryKey(reportId);
	}
	
	public List<SeReportType> getSeReportTypeList(){
		
		return reportTypeMapper.getSeReportTypeList();
	}

}
