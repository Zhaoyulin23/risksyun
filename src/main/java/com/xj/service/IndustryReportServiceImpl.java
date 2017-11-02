package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.IndustryReportMapper;
import com.xj.model.Page;
import com.xj.pojo.IndustryReport;

@Service("industryReportService")
public class IndustryReportServiceImpl implements IndustryReportService {

	@Autowired
	private IndustryReportMapper irMapper;
	
	public ModelAndView getIndustryReportList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) irMapper.getCount();
		
		List<IndustryReport> list = new ArrayList<IndustryReport>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		list = irMapper.getIndustryReportList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("ir_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public IndustryReport selectByPrimaryKey(int industryStatisticsId) {
		
		return irMapper.selectByPrimaryKey(industryStatisticsId);
	}

	public int addIndustryReport(IndustryReport industryReport){
		return irMapper.insertSelective(industryReport);
	}
	
	public int updateIndustryReport(IndustryReport industryReport){
		return irMapper.updateByPrimaryKeySelective(industryReport);
	}
	
	public int deleteIndustryReport(Integer industryStatisticsId){
		return irMapper.deleteByPrimaryKey(industryStatisticsId);
	}
}
