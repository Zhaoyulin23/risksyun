package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xj.pojo.InformationSeniorManager;
import com.xj.pojo.SignleEnterprise;
import com.xj.service.InformationSeniorManagerService;
import com.xj.service.SignleEnterpriseService;

@Controller
public class InformationSeniorManagerController {

	@Autowired
	private InformationSeniorManagerService informationSeniorManagerService;
	
	@Autowired
	private SignleEnterpriseService signleEnterpriseService;
	
	@RequestMapping(value = "getInformationSeniorManagerList.do")
	public ModelAndView getInformationSeniorManagerList(HttpServletRequest request, @RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		List<InformationSeniorManager> ism_list = new ArrayList<InformationSeniorManager>();
		
		ism_list = informationSeniorManagerService.getInformationSeniorManagerListBySeId(se_id);
		modelAndView.addObject("ism_list", ism_list);
		
		SignleEnterprise signleEnterprise = signleEnterpriseService.selectByPrimaryKey(se_id);
		modelAndView.addObject("signleEnterprise", signleEnterprise);
		
		modelAndView.setViewName("view/seInformationSeniorManager");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "informationSeniorManagertDetail.do")
	public ModelAndView getInformationSeniorManagerDetail(HttpServletRequest request, @RequestParam Integer ism_id, @RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		InformationSeniorManager informationSeniorManager = new InformationSeniorManager();
		
		informationSeniorManager = informationSeniorManagerService.getInformationSeniorManagerDetail(ism_id);
		
		modelAndView.addObject("informationSeniorManager", informationSeniorManager);
		
		SignleEnterprise signleEnterprise = signleEnterpriseService.selectByPrimaryKey(se_id);
		modelAndView.addObject("signleEnterprise", signleEnterprise);
		
		modelAndView.setViewName("view/seInformationSeniorManagerUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationSeniorManager.do")
	public ModelAndView saveInformationSeniorManager(HttpServletRequest request,  InformationSeniorManager informationSeniorManager){
		ModelAndView modelAndView = new ModelAndView();
		
		if(informationSeniorManager.getIsmId() == null){
			informationSeniorManagerService.addInformationSeniorManager(informationSeniorManager);
		}else{
			informationSeniorManagerService.updateInformationSeniorManager(informationSeniorManager);
		}
		
		modelAndView.setViewName("redirect:/getInformationSeniorManagerList.do?se_id="+informationSeniorManager.getSeId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteInformationSeniorManager.do")
	public ModelAndView deleteInformationSeniorManager(HttpServletRequest request,RedirectAttributes red,@RequestParam Integer ism_id, @RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView(); 
		
		informationSeniorManagerService.deleteInformationSeniorManager(ism_id);
		
		red.addFlashAttribute("se_id", se_id);
		modelAndView.setViewName("redirect:/getInformationSeniorManagerList.do?se_id="+se_id);
		
		return modelAndView;
	}
	
}
