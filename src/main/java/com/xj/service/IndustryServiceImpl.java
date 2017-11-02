package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.IndustryMapper;
import com.xj.model.Page;
import com.xj.pojo.Industry;

@Service("industryService")
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryMapper siMapper;
	
	public List<Industry> getSeIndustryCategory() {
		return siMapper.getSeIndustryCategory();
	}

	public List<Industry> getSeIndustryClass(Integer industryCategory) {
		
		return siMapper.getSeIndustryClass(industryCategory);
	}

	public List<Industry> getSeIndustrySclass(Integer industryClass) {
		
		return siMapper.getSeIndustrySclass(industryClass);
	}
	
	public ModelAndView getIndustryList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) siMapper.getCount();
		
		List<Industry> list = new ArrayList<Industry>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		list = siMapper.getIndustryList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("si_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public Industry selectByPrimaryKey(int id) {
		
		return siMapper.selectByPrimaryKey(id);
	}

	public int addIndustry(Industry industry){
		return siMapper.insertSelective(industry);
	}
	
	public int updateIndustry(Industry industry){
		return siMapper.updateByPrimaryKeySelective(industry);
	}
	
	public int deleteIndustry(Integer id){
		return siMapper.deleteByPrimaryKey(id);
	}	
}
