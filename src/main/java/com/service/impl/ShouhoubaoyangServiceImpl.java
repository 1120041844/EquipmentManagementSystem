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


import com.dao.ShouhoubaoyangDao;
import com.entity.ShouhoubaoyangEntity;
import com.service.ShouhoubaoyangService;
import com.entity.vo.ShouhoubaoyangVO;
import com.entity.view.ShouhoubaoyangView;

@Service("shouhoubaoyangService")
public class ShouhoubaoyangServiceImpl extends ServiceImpl<ShouhoubaoyangDao, ShouhoubaoyangEntity> implements ShouhoubaoyangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShouhoubaoyangEntity> page = this.selectPage(
                new Query<ShouhoubaoyangEntity>(params).getPage(),
                new EntityWrapper<ShouhoubaoyangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShouhoubaoyangEntity> wrapper) {
		  Page<ShouhoubaoyangView> page =new Query<ShouhoubaoyangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShouhoubaoyangVO> selectListVO(Wrapper<ShouhoubaoyangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShouhoubaoyangVO selectVO(Wrapper<ShouhoubaoyangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShouhoubaoyangView> selectListView(Wrapper<ShouhoubaoyangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShouhoubaoyangView selectView(Wrapper<ShouhoubaoyangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
