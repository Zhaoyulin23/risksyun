package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.IndustryStatEnterprisesMapper;
import com.xj.model.Page;
import com.xj.pojo.IndustryStatEnterprises;

@Service("industryStatEnterprisesService")
public class IndustryStatEnterprisesServiceImpl implements IndustryStatEnterprisesService {

	@Autowired
	private IndustryStatEnterprisesMapper iseMapper;
	
	public ModelAndView getIndustryStatEnterprisesList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) iseMapper.getCount();

		List<IndustryStatEnterprises> list = new ArrayList<IndustryStatEnterprises>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		list = iseMapper.getIndustryList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("ise_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public IndustryStatEnterprises selectByPrimaryKey(int iseId) {
		
		return iseMapper.selectByPrimaryKey(iseId);
	}

	public int addIndustryStatEnterprises(IndustryStatEnterprises industryStatEnterprises){
		return iseMapper.insertSelective(industryStatEnterprises);
	}
	
	public int updateIndustryStatEnterprises(IndustryStatEnterprises industryStatEnterprises){
		return iseMapper.updateByPrimaryKeySelective(industryStatEnterprises);
	}
	
	public int deleteIndustryStatEnterprises(Integer iseId){
		return iseMapper.deleteByPrimaryKey(iseId);
	}
}
