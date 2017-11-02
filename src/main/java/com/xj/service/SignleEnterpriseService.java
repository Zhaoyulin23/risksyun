package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.SignleEnterprise;

public interface SignleEnterpriseService {
	
	public ModelAndView getSignleEnterpriseList(HttpServletRequest request, ModelAndView modelAndView);
	
	public SignleEnterprise selectByPrimaryKey(int se_id);
	
	public int addSignleEnterprise(SignleEnterprise signleEnterprise);
	
	public int updateSignleEnterprise(SignleEnterprise signleEnterprise);
	
	public int deleteSingleEnterprise(Integer se_id);
}
