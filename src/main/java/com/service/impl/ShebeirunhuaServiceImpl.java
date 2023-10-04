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


import com.dao.ShebeirunhuaDao;
import com.entity.ShebeirunhuaEntity;
import com.service.ShebeirunhuaService;
import com.entity.vo.ShebeirunhuaVO;
import com.entity.view.ShebeirunhuaView;

@Service("shebeirunhuaService")
public class ShebeirunhuaServiceImpl extends ServiceImpl<ShebeirunhuaDao, ShebeirunhuaEntity> implements ShebeirunhuaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeirunhuaEntity> page = this.selectPage(
                new Query<ShebeirunhuaEntity>(params).getPage(),
                new EntityWrapper<ShebeirunhuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeirunhuaEntity> wrapper) {
		  Page<ShebeirunhuaView> page =new Query<ShebeirunhuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShebeirunhuaVO> selectListVO(Wrapper<ShebeirunhuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeirunhuaVO selectVO(Wrapper<ShebeirunhuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeirunhuaView> selectListView(Wrapper<ShebeirunhuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeirunhuaView selectView(Wrapper<ShebeirunhuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
