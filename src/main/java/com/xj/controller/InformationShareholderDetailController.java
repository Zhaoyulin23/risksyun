package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.InformationShareholderDetail;
import com.xj.pojo.ShareholdersBackgroundType;
import com.xj.service.InformationShareholderDetailService;

@Controller
public class InformationShareholderDetailController {

	@Autowired
	private InformationShareholderDetailService informationShareholderDetailService;
	
	
	@RequestMapping(value = "getInformationShareholderDetailList.do")
	public ModelAndView getInformationShareholderDetailList(HttpServletRequest request, @RequestParam Integer isId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		List<InformationShareholderDetail> list = new ArrayList<InformationShareholderDetail>();
		
		list = informationShareholderDetailService.getInformationShareholderDetailListByIsId(isId);
		
		modelAndView.addObject("isd_list", list);
		modelAndView.addObject("isId", isId);
		modelAndView.addObject("seId", seId);
		
		modelAndView.setViewName("view/seInformationShareholderDetail");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "getInformationShareholderDetail.do")
	public ModelAndView getInformationShareholderDetail(HttpServletRequest request, @RequestParam Integer isdId, @RequestParam Integer isId, @RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		InformationShareholderDetail informationShareholderDetail = new InformationShareholderDetail();
		
		informationShareholderDetail = informationShareholderDetailService.getInformationShareholderDetail(isdId);
		
		modelAndView.addObject("informationShareholderDetail", informationShareholderDetail);
		modelAndView.addObject("isId", isId);
		modelAndView.addObject("seId", seId);

		List<ShareholdersBackgroundType> sbType_list = informationShareholderDetailService.getSbTypeList();
		modelAndView.addObject("sbType_list", sbType_list);
		
		modelAndView.setViewName("view/seInformationShareholderDetailUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveInformationShareholderDetail.do")
	public ModelAndView saveInformationShareholderDetail(HttpServletRequest request,InformationShareholderDetail informationShareholderDetail, @RequestParam Integer isId){
		ModelAndView modelAndView = new ModelAndView();
		
		if(informationShareholderDetail.getIsdId() == null){
			informationShareholderDetailService.addInformationShareholderDetail(informationShareholderDetail);
		}else{
			informationShareholderDetailService.updateInformationShareholderDetail(informationShareholderDetail);
		}
		
		modelAndView.setViewName("redirect:/getInformationShareholderDetailList.do?isId="+isId);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteInformationShareholderDetail.do")
	public ModelAndView deleteInformationShareholderDetail(HttpServletRequest request,@RequestParam Integer isdId, @RequestParam Integer isId){
		ModelAndView modelAndView = new ModelAndView();
		
		informationShareholderDetailService.deleteInformationShareholderDetail(isdId);
		
		modelAndView.setViewName("redirect:/getInformationShareholderDetailList.do?isId="+isId);
		
		return modelAndView;
	}
}
