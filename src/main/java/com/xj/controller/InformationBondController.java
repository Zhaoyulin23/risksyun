package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.InformationBond;
import com.xj.service.InformationBondService;

@Controller
public class InformationBondController {

	@Autowired
	private InformationBondService informationBondService;
	
	@RequestMapping(value = "getInformationBondList.do")
	public ModelAndView getInformationBondList(HttpServletRequest request,@RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		List<InformationBond> bond_list = new ArrayList<InformationBond>();
		
		bond_list = informationBondService.getInformationBondList(seId);
		
		modelAndView.addObject("bond_list", bond_list);
		modelAndView.addObject("seId", seId);
		modelAndView.setViewName("view/seInformationBond");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "getInformationBond.do")
	public ModelAndView getInformationBond(HttpServletRequest request,@RequestParam Integer ibId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		InformationBond informationBond = new InformationBond();
		
		informationBond = informationBondService.getInformationBond(ibId);
		
		modelAndView.addObject("informationBond", informationBond);
		modelAndView.addObject("seId", seId);
		
		modelAndView.setViewName("view/seInformationBondUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationBond.do")
	public ModelAndView saveInformationBond(HttpServletRequest request,InformationBond informationBond, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		if(informationBond.getIbId() == null){
			informationBondService.addInformationBond(informationBond);
		}else{
			informationBondService.updateInformationBond(informationBond);
		}
		
		modelAndView.setViewName("redirect:/getInformationBondList.do?seId="+seId);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteInformationBond.do")
	public ModelAndView deleteInformationBond(HttpServletRequest request,@RequestParam Integer ibId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		informationBondService.deleteInformationBond(ibId);
		
		modelAndView.setViewName("redirect:/getInformationBondList.do?seId="+seId);
		
		return modelAndView;
	}
}
