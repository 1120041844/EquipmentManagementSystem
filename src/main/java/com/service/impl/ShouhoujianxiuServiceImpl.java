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


import com.dao.ShouhoujianxiuDao;
import com.entity.ShouhoujianxiuEntity;
import com.service.ShouhoujianxiuService;
import com.entity.vo.ShouhoujianxiuVO;
import com.entity.view.ShouhoujianxiuView;

@Service("shouhoujianxiuService")
public class ShouhoujianxiuServiceImpl extends ServiceImpl<ShouhoujianxiuDao, ShouhoujianxiuEntity> implements ShouhoujianxiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShouhoujianxiuEntity> page = this.selectPage(
                new Query<ShouhoujianxiuEntity>(params).getPage(),
                new EntityWrapper<ShouhoujianxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShouhoujianxiuEntity> wrapper) {
		  Page<ShouhoujianxiuView> page =new Query<ShouhoujianxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShouhoujianxiuVO> selectListVO(Wrapper<ShouhoujianxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShouhoujianxiuVO selectVO(Wrapper<ShouhoujianxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShouhoujianxiuView> selectListView(Wrapper<ShouhoujianxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShouhoujianxiuView selectView(Wrapper<ShouhoujianxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
