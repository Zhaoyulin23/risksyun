package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.InformationContact;
import com.xj.pojo.SignleEnterprise;
import com.xj.service.InformationContactService;
import com.xj.service.SignleEnterpriseService;

@Controller
public class InformationContactController {

	@Autowired
	private InformationContactService informationContactService;
	
	@Autowired
	private SignleEnterpriseService signleEnterpriseService;
	
	@RequestMapping(value = "getInformationContactList.do")
	public ModelAndView getInformationContactList(HttpServletRequest request, @RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		List<InformationContact> list = new ArrayList<InformationContact>();
				
		list = informationContactService.getInformationContactListBySeId(se_id);
		
		modelAndView.addObject("ic_list", list);
		
		SignleEnterprise  signleEnterptise=signleEnterpriseService.selectByPrimaryKey(se_id);
		
		modelAndView.addObject("signleEnterptise", signleEnterptise);
		
		modelAndView.setViewName("view/seInformationContract");
		
		return modelAndView;
	}
	
	@RequestMapping(value ="informationContractDetail.do")
	public ModelAndView getInformationContactDetail(HttpServletRequest request, @RequestParam Integer icId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		InformationContact informationContact = new InformationContact();
		
		informationContact = informationContactService.getInformationContract(icId);
		
		modelAndView.addObject("informationContact", informationContact);
		
		SignleEnterprise  signleEnterptise=signleEnterpriseService.selectByPrimaryKey(seId);
		
		modelAndView.addObject("signleEnterptise", signleEnterptise);
		
		modelAndView.setViewName("view/seInformationContractUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationContract.do")
	public ModelAndView saveInformationContract(HttpServletRequest request,InformationContact informationContact){
		ModelAndView modelAndView = new ModelAndView();
		
		if(informationContact.getIcId() == null){
			informationContactService.addInformationContact(informationContact);
		}else{
			informationContactService.updateInformationContact(informationContact);
		}
		
		modelAndView.setViewName("redirect:/getInformationContactList.do?se_id="+informationContact.getSeId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteInformationContract.do")
	public ModelAndView deleteInformationContract(HttpServletRequest request,@RequestParam Integer icId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		informationContactService.delInformationContact(icId);
		
		modelAndView.setViewName("redirect:/getInformationContactList.do?se_id="+seId);
		
		return modelAndView;
	}
}
