package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.InformationShareholder;
import com.xj.pojo.SignleEnterprise;
import com.xj.service.InformationShareholderService;
import com.xj.service.SignleEnterpriseService;

@Controller
public class InformationShareholderController {

	@Autowired
	private InformationShareholderService informationShareholderService;
	
	@Autowired
	private SignleEnterpriseService signleEnterpriseService;
	
	@RequestMapping(value = "getInformationShareholderList.do")
	public ModelAndView getInformationShareholderListBySeId(HttpServletRequest request, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		List<InformationShareholder> list = new ArrayList<InformationShareholder>();
		
		list = informationShareholderService.getInformationShareholderBySeId(seId);
		
		modelAndView.addObject("is_list", list);
		
		SignleEnterprise signleEnterprise = signleEnterpriseService.selectByPrimaryKey(seId);
		modelAndView.addObject("signleEnterprise", signleEnterprise);
		
		modelAndView.setViewName("view/seInformationShareholder");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "informationShareholderDetail.do")
	public ModelAndView getInformationShareholderDetail(HttpServletRequest request, @RequestParam Integer isId,@RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		InformationShareholder informationShareholder = informationShareholderService.getInformationShareholder(isId);
		
		modelAndView.addObject("informationShareholder", informationShareholder);
		
		SignleEnterprise signleEnterprise = signleEnterpriseService.selectByPrimaryKey(seId);
		modelAndView.addObject("signleEnterprise", signleEnterprise);
		
		modelAndView.setViewName("view/seInformationShareholderUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationShareholder.do")
	public ModelAndView saveInformationShareholder(HttpServletRequest request,InformationShareholder informationShareholder){
		ModelAndView modelAndView = new ModelAndView();
		
		if(informationShareholder.getIsId() == null){
			informationShareholderService.addInformationShareholder(informationShareholder);
		}else{
			informationShareholderService.updateInformationShareholder(informationShareholder);
		}
		
		modelAndView.setViewName("redirect:/getInformationShareholderList.do?seId="+informationShareholder.getSeId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteInformationShareholder.do")
	public ModelAndView deleteInformationShareholder(HttpServletRequest request,@RequestParam Integer isId ,@RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		informationShareholderService.deleteInformationShareholder(isId);
		
		modelAndView.setViewName("redirect:/getInformationShareholderList.do?seId="+seId);
		
		return modelAndView;
	}
	
	
}
