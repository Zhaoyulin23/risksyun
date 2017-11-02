package com.xj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.InformationFinancing;
import com.xj.service.InformationFinancingService;

@Controller
public class InformationFinancingController {

	@Autowired
	private InformationFinancingService informationFinancingService;
	
	@RequestMapping(value = "getInformationFinancing.do")
	public ModelAndView getInformationFinancing(HttpServletRequest request, @RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		InformationFinancing informationFinancing = informationFinancingService.getInformationFinancingBySeId(se_id);
		
		if(informationFinancing == null){
			informationFinancing = new InformationFinancing();
			informationFinancing.setIfId(0);
		}
		modelAndView.addObject("informationFinancing", informationFinancing);
		modelAndView.addObject("seId", se_id);
		
		modelAndView.setViewName("view/seInformationFinancing");
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationFinancing.do")
	@ResponseBody
	public String saveInformationFinancing(HttpServletRequest request){
		InformationFinancing informationFinancing = new InformationFinancing();
		
		String ifIdStr = request.getParameter("ifId");
		int seId = Integer.parseInt(request.getParameter("seId"));
		String field =request.getParameter("field");
		int value =Integer.parseInt(request.getParameter("value"));
		
		informationFinancing.setSeId(seId);
		if(field.equals("ipo")){
			informationFinancing.setIpo(value);
		}else if(field.equals("issueBond")){
			informationFinancing.setIssueBond(value);
		}
		
		String str = "";
		if(ifIdStr == null || "".equals(ifIdStr) || "0".equals(ifIdStr)){
			informationFinancingService.addInformationFinancing(informationFinancing);
			str = "add-"+informationFinancing.getIfId();
		}else{
			informationFinancing.setIfId(Integer.parseInt(ifIdStr));
			informationFinancingService.updateInformationFinancing(informationFinancing);
		}
		
		return str;
	}
}
