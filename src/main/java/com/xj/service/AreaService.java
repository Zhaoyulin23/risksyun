package com.xj.service;

import java.util.List;

import com.xj.pojo.Area;

public interface AreaService {
	
	public List<Area> getSeProvince();
	
	public List<Area> getSeCity(Integer id);
	
	public List<Area> getSeDistrict(Integer id);
}
