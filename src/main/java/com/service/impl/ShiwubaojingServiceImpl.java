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


import com.dao.ShiwubaojingDao;
import com.entity.ShiwubaojingEntity;
import com.service.ShiwubaojingService;
import com.entity.vo.ShiwubaojingVO;
import com.entity.view.ShiwubaojingView;

@Service("shiwubaojingService")
public class ShiwubaojingServiceImpl extends ServiceImpl<ShiwubaojingDao, ShiwubaojingEntity> implements ShiwubaojingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiwubaojingEntity> page = this.selectPage(
                new Query<ShiwubaojingEntity>(params).getPage(),
                new EntityWrapper<ShiwubaojingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiwubaojingEntity> wrapper) {
		  Page<ShiwubaojingView> page =new Query<ShiwubaojingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShiwubaojingVO> selectListVO(Wrapper<ShiwubaojingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShiwubaojingVO selectVO(Wrapper<ShiwubaojingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShiwubaojingView> selectListView(Wrapper<ShiwubaojingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiwubaojingView selectView(Wrapper<ShiwubaojingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
