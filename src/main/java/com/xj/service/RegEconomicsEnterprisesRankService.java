package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsEnterprisesRank;

public interface RegEconomicsEnterprisesRankService {
	
	public ModelAndView getRegEconomicsEnterprisesRankList(HttpServletRequest request, ModelAndView modelAndView);
	
	public RegEconomicsEnterprisesRank selectByPrimaryKey(int rer_id);
	
	public int addRegEconomicsEnterprisesRank(RegEconomicsEnterprisesRank regEconomicsEnterprisesRank);
	
	public int updateRegEconomicsEnterprisesRank(RegEconomicsEnterprisesRank regEconomicsEnterprisesRank);
	
	public int deleteRegEconomicsEnterprisesRank(Integer rer_id);
}
