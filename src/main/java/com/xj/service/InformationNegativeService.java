package com.xj.service;

import java.util.List;

import com.xj.pojo.InformationNegative;
import com.xj.pojo.InformationNegativeType;

public interface InformationNegativeService {

	public List<InformationNegative> getInformationNegativeList(Integer seId);
	
	public InformationNegative getInformationNegative(Integer inId);
	
	public int addInformationNegative(InformationNegative informationNegative);
	
	public int updateInformationNegative(InformationNegative informationNegative);
	
	public int deleteInformationNegative(Integer inId);
	
	public List<InformationNegativeType> getInformationNegativeTypeList();
}
