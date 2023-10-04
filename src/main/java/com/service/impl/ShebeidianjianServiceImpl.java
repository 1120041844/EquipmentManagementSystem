package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShebeidianjianDao;
import com.entity.ShebeidianjianEntity;
import com.service.ShebeidianjianService;
import com.entity.vo.ShebeidianjianVO;
import com.entity.view.ShebeidianjianView;

@Service("shebeidianjianService")
public class ShebeidianjianServiceImpl extends ServiceImpl<ShebeidianjianDao, ShebeidianjianEntity> implements ShebeidianjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeidianjianEntity> page = this.selectPage(
                new Query<ShebeidianjianEntity>(params).getPage(),
                new EntityWrapper<ShebeidianjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeidianjianEntity> wrapper) {
		  Page<ShebeidianjianView> page =new Query<ShebeidianjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeidianjianVO> selectListVO(Wrapper<ShebeidianjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeidianjianVO selectVO(Wrapper<ShebeidianjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeidianjianView> selectListView(Wrapper<ShebeidianjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeidianjianView selectView(Wrapper<ShebeidianjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
