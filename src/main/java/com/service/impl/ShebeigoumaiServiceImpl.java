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


import com.dao.ShebeigoumaiDao;
import com.entity.ShebeigoumaiEntity;
import com.service.ShebeigoumaiService;
import com.entity.vo.ShebeigoumaiVO;
import com.entity.view.ShebeigoumaiView;

@Service("shebeigoumaiService")
public class ShebeigoumaiServiceImpl extends ServiceImpl<ShebeigoumaiDao, ShebeigoumaiEntity> implements ShebeigoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeigoumaiEntity> page = this.selectPage(
                new Query<ShebeigoumaiEntity>(params).getPage(),
                new EntityWrapper<ShebeigoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeigoumaiEntity> wrapper) {
		  Page<ShebeigoumaiView> page =new Query<ShebeigoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeigoumaiVO> selectListVO(Wrapper<ShebeigoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeigoumaiVO selectVO(Wrapper<ShebeigoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeigoumaiView> selectListView(Wrapper<ShebeigoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeigoumaiView selectView(Wrapper<ShebeigoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
