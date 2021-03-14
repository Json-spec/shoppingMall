package com.wx.shopmall.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.controller.WxProductController;
import com.wx.shopmall.entity.WxFootprint;
import com.wx.shopmall.entity.WxProduct;
import com.wx.shopmall.mapper.WxFootprintMapper;
import com.wx.shopmall.mapper.WxProductMapper;
import com.wx.shopmall.service.WxFootprintService;
import com.wx.shopmall.service.WxProductService;
import com.wx.shopmall.vo.WxProductResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/11 21:31
 * @Description:
 */
@Service
public class WxProductServiceImpl implements WxProductService {

    private static final Logger logger = LoggerFactory.getLogger(WxProductServiceImpl.class);

    @Autowired
    private WxProductMapper wxProductMapper;

    @Autowired
    private WxFootprintService wxFootprintService;

    @Autowired
    private WxFootprintMapper wxFootprintMapper;


    @Override
    public Page<WxProductResultVo> productIndex(Page<WxProductResultVo> page,Long id) {
        Page<WxProductResultVo> pageList =  wxProductMapper.productIndex(page,id);
        return pageList;
    }


    @Override
    public WxProduct proDetal(Long id,Long userId) {
        WxProduct wxProduct = wxProductMapper.proDetal(id);
        if (ObjectUtil.isNotEmpty(wxProduct)){
            //查看具体商品需要留下商品浏览记录需要在wx_footprint表中插入信息（先查询表是否存在存在更新下时间不存在插入）
            WxFootprint wxFootprint = wxFootprintMapper.selectOne(new QueryWrapper<WxFootprint>().eq("user_id", userId).eq("pro_id", id).eq("flag",1));
            if (ObjectUtil.isNotEmpty(wxFootprint)){
                wxFootprint.setUpdateTime(new Date());
                wxFootprintMapper.updateById(wxFootprint);
            }else{
                int insert = wxFootprintService.insertWxFootprint(wxProduct.getId(),userId);
            }
            return wxProduct;
        }else{
            return null;
        }
    }

    @Override
    public Integer productCount() {
        Integer count = wxProductMapper.productCount();
        return count;
    }
}
