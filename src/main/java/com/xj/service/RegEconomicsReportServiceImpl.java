package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.RegEconomicsReportMapper;
import com.xj.model.Page;
import com.xj.pojo.RegEconomicsReport;

@Service("RegEconomicsReportService")
public class RegEconomicsReportServiceImpl implements RegEconomicsReportService {

	@Autowired
	private RegEconomicsReportMapper rerMapper;
	
	public ModelAndView getRegEconomicsReportList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) rerMapper.getCount();
		
		List<RegEconomicsReport> list = new ArrayList<RegEconomicsReport>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		list = rerMapper.getRegEconomicsReportList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("rer_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public RegEconomicsReport selectByPrimaryKey(int rer_id) {
		
		return rerMapper.selectByPrimaryKey(rer_id);
	}

	public int addRegEconomicsReport(RegEconomicsReport regEconomicsReport){
		return rerMapper.insertSelective(regEconomicsReport);
	}
	
	public int updateRegEconomicsReport(RegEconomicsReport regEconomicsReport){
		return rerMapper.updateByPrimaryKeySelective(regEconomicsReport);
	}
	
	public int deleteRegEconomicsReport(Integer rer_id){
		return rerMapper.deleteByPrimaryKey(rer_id);
	}
}
