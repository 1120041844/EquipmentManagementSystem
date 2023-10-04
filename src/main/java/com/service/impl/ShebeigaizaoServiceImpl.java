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


import com.dao.ShebeigaizaoDao;
import com.entity.ShebeigaizaoEntity;
import com.service.ShebeigaizaoService;
import com.entity.vo.ShebeigaizaoVO;
import com.entity.view.ShebeigaizaoView;

@Service("shebeigaizaoService")
public class ShebeigaizaoServiceImpl extends ServiceImpl<ShebeigaizaoDao, ShebeigaizaoEntity> implements ShebeigaizaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeigaizaoEntity> page = this.selectPage(
                new Query<ShebeigaizaoEntity>(params).getPage(),
                new EntityWrapper<ShebeigaizaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeigaizaoEntity> wrapper) {
		  Page<ShebeigaizaoView> page =new Query<ShebeigaizaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeigaizaoVO> selectListVO(Wrapper<ShebeigaizaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeigaizaoVO selectVO(Wrapper<ShebeigaizaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeigaizaoView> selectListView(Wrapper<ShebeigaizaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeigaizaoView selectView(Wrapper<ShebeigaizaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
