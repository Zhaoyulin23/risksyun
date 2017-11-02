package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo. IndustryStatEnterprisesRank;

public interface IndustryStatEnterprisesRankService {
	
	public ModelAndView getIndustryStatEnterprisesRankList(HttpServletRequest request, ModelAndView modelAndView);
	
	public  IndustryStatEnterprisesRank selectByPrimaryKey(int ier_id);
	
	public int addIndustryStatEnterprisesRank( IndustryStatEnterprisesRank  industryStatEnterprisesRank);
	
	public int updateIndustryStatEnterprisesRank( IndustryStatEnterprisesRank  industryStatEnterprisesRank);
	
	public int deleteIndustryStatEnterprisesRank(Integer ier_id);
}
