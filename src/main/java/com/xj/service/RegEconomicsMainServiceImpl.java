package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.RegEconomicsMainMapper;
import com.xj.model.Page;
import com.xj.pojo.RegEconomicsMain;

@Service("regEconomicsMainService")
public class RegEconomicsMainServiceImpl implements RegEconomicsMainService {

	@Autowired
	private RegEconomicsMainMapper remMapper;
	
	public ModelAndView getRegEconomicsMainList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) remMapper.getCount();
		
		List<RegEconomicsMain> list = new ArrayList<RegEconomicsMain>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		list = remMapper.getRegEconomicsMainList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("rem_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public RegEconomicsMain selectByPrimaryKey(int rem_id) {
		
		return remMapper.selectByPrimaryKey(rem_id);
	}

	public int addRegEconomicsMain(RegEconomicsMain regEconomicsMain){
		return remMapper.insertSelective(regEconomicsMain);
	}
	
	public int updateRegEconomicsMain(RegEconomicsMain regEconomicsMain){
		return remMapper.updateByPrimaryKeySelective(regEconomicsMain);
	}
	
	public int deleteRegEconomicsMain(Integer rem_id){
		return remMapper.deleteByPrimaryKey(rem_id);
	}
}
