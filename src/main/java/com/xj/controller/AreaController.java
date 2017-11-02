package com.xj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xj.pojo.Area;
import com.xj.service.AreaService;

@Controller
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "getSeProvince.do")
	@ResponseBody
	public List<Area> getSeProvice(HttpServletRequest request){
		
		List<Area> privice_list = new ArrayList<Area>();
		
		privice_list = areaService.getSeProvince();
		
		return privice_list;
	}
	
	@RequestMapping(value = "getSeCity.do")
	@ResponseBody
	public List<Area> getSeCity(HttpServletRequest request,@RequestParam Integer id){
		
		List<Area> city_list = new ArrayList<Area>();
		
		city_list = areaService.getSeCity(id);
		
		return city_list;
	}
	
	@RequestMapping(value = "getSeDistrict.do")
	@ResponseBody
	public List<Area> getSeDistrict(HttpServletRequest request,@RequestParam Integer id){
		
		List<Area> district_list = new ArrayList<Area>();
		
		district_list = areaService.getSeDistrict(id);
		
		return district_list;
	}
}
