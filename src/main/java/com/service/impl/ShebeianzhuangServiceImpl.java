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


import com.dao.ShebeianzhuangDao;
import com.entity.ShebeianzhuangEntity;
import com.service.ShebeianzhuangService;
import com.entity.vo.ShebeianzhuangVO;
import com.entity.view.ShebeianzhuangView;

@Service("shebeianzhuangService")
public class ShebeianzhuangServiceImpl extends ServiceImpl<ShebeianzhuangDao, ShebeianzhuangEntity> implements ShebeianzhuangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeianzhuangEntity> page = this.selectPage(
                new Query<ShebeianzhuangEntity>(params).getPage(),
                new EntityWrapper<ShebeianzhuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeianzhuangEntity> wrapper) {
		  Page<ShebeianzhuangView> page =new Query<ShebeianzhuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeianzhuangVO> selectListVO(Wrapper<ShebeianzhuangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeianzhuangVO selectVO(Wrapper<ShebeianzhuangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeianzhuangView> selectListView(Wrapper<ShebeianzhuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeianzhuangView selectView(Wrapper<ShebeianzhuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
