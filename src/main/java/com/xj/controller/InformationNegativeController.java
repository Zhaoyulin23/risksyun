package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.InformationNegative;
import com.xj.pojo.InformationNegativeType;
import com.xj.service.InformationNegativeService;

@Controller
public class InformationNegativeController {

	@Autowired
	private InformationNegativeService informationNegativeService;
	
	@RequestMapping(value = "getInformationNegativeList.do")
	public ModelAndView getInformationNegativeList(HttpServletRequest request, @RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		List<InformationNegative> in_list = new ArrayList<InformationNegative>();
		
		in_list = informationNegativeService.getInformationNegativeList(se_id);
		
		modelAndView.addObject("in_list", in_list);
		
		modelAndView.addObject("seId", se_id);
		
		
		modelAndView.setViewName("view/seInformationNegative");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "getInformationNegative.do")
	public ModelAndView getInformationNegative(HttpServletRequest request, @RequestParam Integer inId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		InformationNegative informationNegative = new InformationNegative();
		
		informationNegative = informationNegativeService.getInformationNegative(inId);
		
		modelAndView.addObject("informationNegative", informationNegative);
		modelAndView.addObject("seId", seId);
		
		List<InformationNegativeType> int_list = new ArrayList<InformationNegativeType>();
		int_list = informationNegativeService.getInformationNegativeTypeList();
		modelAndView.addObject("int_list", int_list);
		
		modelAndView.setViewName("view/seInformationNegativeUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationNegative.do")
	public ModelAndView saveInformationNegative(HttpServletRequest request,InformationNegative informationNegative, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		if(informationNegative.getInId() == null){
			informationNegativeService.addInformationNegative(informationNegative);
		}else{
			informationNegativeService.updateInformationNegative(informationNegative);
		}
		
		modelAndView.setViewName("redirect:/getInformationNegativeList.do?se_id="+seId);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteInformationNegative.do")
	public ModelAndView deleteInformationNegative(HttpServletRequest request,@RequestParam Integer inId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		informationNegativeService.deleteInformationNegative(inId);
		
		modelAndView.setViewName("redirect:/getInformationNegativeList.do?se_id="+seId);
		
		return modelAndView;
	}
	
}
