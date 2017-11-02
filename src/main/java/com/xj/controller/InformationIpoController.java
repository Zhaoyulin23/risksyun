package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.InformationIpo;
import com.xj.service.InformationIpoService;

@Controller
public class InformationIpoController {

	@Autowired
	private InformationIpoService informationIpoService;
	
	@RequestMapping(value = "getInformationIpoList.do")
	public ModelAndView getInformationIpoList(HttpServletRequest request, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		List<InformationIpo> ipo_list = new ArrayList<InformationIpo>();
		ipo_list = informationIpoService.getInformationIpoList(seId);
		
		modelAndView.addObject("ipo_list", ipo_list);
		modelAndView.addObject("seId", seId);
		
		modelAndView.setViewName("view/seInformationIpo");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "getInformationIpo.do")
	public ModelAndView getInformationIpo(HttpServletRequest request, @RequestParam Integer ipoId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		 
		InformationIpo informationIpo = new InformationIpo();
		informationIpo = informationIpoService.getInformationIpo(ipoId);
		
		modelAndView.addObject("informationIpo", informationIpo);
		modelAndView.addObject("seId", seId);
		
		modelAndView.setViewName("view/seInformationIpoUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationIpo.do")
	public ModelAndView saveInformationIpo(HttpServletRequest request,InformationIpo informationIpo, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		if(informationIpo.getIpoId() == null){
			informationIpoService.addInformationIpo(informationIpo);
		}else{
			informationIpoService.updateInformationIpo(informationIpo);
		}
		
		modelAndView.setViewName("redirect:/getInformationIpoList.do?seId="+seId);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteInformationIpo.do")
	public ModelAndView deleteInformationIpo(HttpServletRequest request, @RequestParam Integer ipoId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		informationIpoService.deleteInformationIpo(ipoId);
		modelAndView.setViewName("redirect:/getInformationIpoList.do?seId="+seId);
		
		return modelAndView;
	}
}
