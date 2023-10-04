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


import com.dao.PeijiangoumaiDao;
import com.entity.PeijiangoumaiEntity;
import com.service.PeijiangoumaiService;
import com.entity.vo.PeijiangoumaiVO;
import com.entity.view.PeijiangoumaiView;

@Service("peijiangoumaiService")
public class PeijiangoumaiServiceImpl extends ServiceImpl<PeijiangoumaiDao, PeijiangoumaiEntity> implements PeijiangoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeijiangoumaiEntity> page = this.selectPage(
                new Query<PeijiangoumaiEntity>(params).getPage(),
                new EntityWrapper<PeijiangoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeijiangoumaiEntity> wrapper) {
		  Page<PeijiangoumaiView> page =new Query<PeijiangoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeijiangoumaiVO> selectListVO(Wrapper<PeijiangoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeijiangoumaiVO selectVO(Wrapper<PeijiangoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeijiangoumaiView> selectListView(Wrapper<PeijiangoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeijiangoumaiView selectView(Wrapper<PeijiangoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
