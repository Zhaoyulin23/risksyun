package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.RegEconomicsEnterprisesMapper;
import com.xj.model.Page;
import com.xj.pojo.RegEconomicsEnterprises;

@Service("regEconomicsEnterprisesService")
public class RegEconomicsEnterprisesServiceImpl implements RegEconomicsEnterprisesService {

	@Autowired
	private RegEconomicsEnterprisesMapper reeMapper;
	
	public ModelAndView getRegEconomicsEnterprisesList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) reeMapper.getCount();
		
		List<RegEconomicsEnterprises> list = new ArrayList<RegEconomicsEnterprises>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		list = reeMapper.getRegEconomicsEnterprisesList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("ree_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public RegEconomicsEnterprises selectByPrimaryKey(String rge_id) {
		
		return reeMapper.selectByPrimaryKey(rge_id);
	}

	public int addRegEconomicsEnterprises(RegEconomicsEnterprises regEconomicsEnterprises){
		return reeMapper.insertSelective(regEconomicsEnterprises);
	}
	
	public int updateRegEconomicsEnterprises(RegEconomicsEnterprises regEconomicsEnterprises){
		return reeMapper.updateByPrimaryKeySelective(regEconomicsEnterprises);
	}
	
	public int deleteRegEconomicsEnterprises(String rge_id){
		return reeMapper.deleteByPrimaryKey(rge_id);
	}
}
