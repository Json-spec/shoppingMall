package com.wx.shopmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.entity.WxFootprint;
import com.wx.shopmall.mapper.WxFootprintMapper;
import com.wx.shopmall.service.WxAddressService;
import com.wx.shopmall.service.WxFootprintService;
import com.wx.shopmall.vo.WxProductResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WxFootprintServiceimpl implements WxFootprintService {

    private final Logger logger = LoggerFactory.getLogger(WxFootprintServiceimpl.class);


    @Autowired
    private WxFootprintMapper wxFootprintMapper;

    @Override
    public int insertWxFootprint(Long id , Long userId) {
        WxFootprint wxFootprint = new WxFootprint();
        wxFootprint.setCreateTime(new Date());
        wxFootprint.setUpdateTime(new Date());
        wxFootprint.setProId(id);
        wxFootprint.setFlag(1);
        wxFootprint.setUserId(userId);
        wxFootprint.setIsCollection(2);
        return wxFootprintMapper.insert(wxFootprint);
    }

    @Override
    public Page<WxProductResultVo> footprintList(Page<WxProductResultVo> wxProductResultVoPage, Long userId) {
        Page<WxProductResultVo> pageList =  wxFootprintMapper.footprintList(wxProductResultVoPage,userId);
        return pageList;
    }

    /**
     * 根据浏览记录id删除浏览记录
     * @param id
     * @return
     */
    @Override
    public int footprintDelete(Long id) {
        UpdateWrapper<WxFootprint> objectUpdateWrapper = new UpdateWrapper<>();
        objectUpdateWrapper.lambda().set(WxFootprint::getFlag,2).eq(WxFootprint::getId,id);
        return wxFootprintMapper.update(null,objectUpdateWrapper);
    }
}
