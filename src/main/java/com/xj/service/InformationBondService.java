package com.xj.service;

import java.util.List;

import com.xj.pojo.InformationBond;

public interface InformationBondService {

	public List<InformationBond> getInformationBondList(Integer seId);
	
	public InformationBond getInformationBond(Integer ibId);
	
	public int addInformationBond(InformationBond informationBond);
	
	public int updateInformationBond(InformationBond informationBond);
	
	public int deleteInformationBond(Integer ibId);
}
