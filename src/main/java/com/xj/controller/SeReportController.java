package com.xj.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.SeReport;
import com.xj.pojo.SeReportType;
import com.xj.service.SeReportService;

@Controller
public class SeReportController {

	@Autowired
	private SeReportService reportService;
	
	@RequestMapping(value = "getSeReportList.do")
	public ModelAndView getSeReportList(HttpServletRequest request,@RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		List<SeReport> sr_list = new ArrayList<SeReport>();
		
		sr_list = reportService.getSeReportListBySeId(se_id);
		
		modelAndView.addObject("sr_list", sr_list);
		modelAndView.addObject("seId", se_id);
		
		modelAndView.setViewName("view/seReport");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "getSeReport.do")
	public ModelAndView getSeReport(HttpServletRequest request,@RequestParam Integer reportId,@RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		SeReport seReport = new SeReport();
		
		seReport = reportService.getSeReport(reportId);
		
		modelAndView.addObject("seReport", seReport);
		modelAndView.addObject("seId", seId);
		
		List<SeReportType> st_list = new ArrayList<SeReportType>();
		st_list = reportService.getSeReportTypeList();
		modelAndView.addObject("st_list", st_list);
		
		modelAndView.setViewName("view/seReportUpdate");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "saveSeReport.do")
	public ModelAndView saveSeReport(HttpServletRequest request, SeReport seReport,@RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		if(seReport.getReportId() == null){
			reportService.addSeReport(seReport);
		}else{
			reportService.updateSeReport(seReport);
		}
		
		modelAndView.setViewName("redirect:/getSeReportList.do?se_id="+seId);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteSeReport.do")
	public ModelAndView deleteSeReport(HttpServletRequest request, @RequestParam Integer reportId,@RequestParam Integer seId){
		ModelAndView modelAndView = new ModelAndView();
		
		reportService.deleteSeReport(reportId);
		
		modelAndView.setViewName("redirect:/getSeReportList.do?se_id="+seId);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "doUploadReport.do")
	@ResponseBody
	public String doUploadReport(HttpServletRequest request,@RequestParam("file") MultipartFile file){
		
		String path = request.getSession().getServletContext().getRealPath("upload");  
		String fileName = file.getOriginalFilename();
		
		File dir  = new File(path, fileName);
		if(!dir.exists()){  
            dir.mkdirs();  
        }
		try {
			
			//MultipartFile自带的解析方法  
			file.transferTo(dir);
			String filePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/upload/" +fileName;
			return filePath;
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return "upload error!";
	}
	
}
