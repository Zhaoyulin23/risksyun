package com.xj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xj.pojo.Industry;
import com.xj.service.IndustryService;
//import java.util.List;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndustryController {
	
	@Autowired
	private IndustryService industryService;
	
	
	@RequestMapping(value = "getSeIndustryCategory.do")
	@ResponseBody
	public List<Industry> getSeIndustryCategory(HttpServletRequest request){
		
		List<Industry> list = industryService.getSeIndustryCategory();
		
		
		return list;
	}
	
	@RequestMapping(value = "getSeIndustryClass.do")
	@ResponseBody
	public List<Industry> getSeIndustryClass(HttpServletRequest request,@RequestParam Integer industryCategory){
		return industryService.getSeIndustryClass(industryCategory);
	}
	
	@RequestMapping(value = "getSeIndustrySclass.do")
	@ResponseBody
	public List<Industry> getSeIndustrySclass(HttpServletRequest request, @RequestParam Integer industryClass){
		
		return industryService.getSeIndustrySclass(industryClass);
	}
}	
