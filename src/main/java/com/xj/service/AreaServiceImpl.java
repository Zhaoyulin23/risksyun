package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.AreaMapper;
import com.xj.pojo.Area;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	public List<Area> getSeProvince() {
		
		return areaMapper.getSeProvince();
	}
	
	public List<Area> getSeCity(Integer id) {
		
		return areaMapper.getSeCity(id);
	}
	
	public List<Area> getSeDistrict(Integer id) {
		
		return areaMapper.getSeDistrict(id);
	}

}
