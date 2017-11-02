package com.xj.service;

import java.util.List;

import com.xj.pojo.InformationIpo;

public interface InformationIpoService {

	public List<InformationIpo> getInformationIpoList(Integer seId);
	
	public InformationIpo getInformationIpo(Integer ipoId);
	
	public int addInformationIpo(InformationIpo informationIpo);
	
	public int updateInformationIpo(InformationIpo informationIpo);
	
	public int deleteInformationIpo(Integer ipoId);
}
