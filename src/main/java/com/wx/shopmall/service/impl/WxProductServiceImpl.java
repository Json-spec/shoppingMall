package com.wx.shopmall.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.controller.WxProductController;
import com.wx.shopmall.entity.WxProduct;
import com.wx.shopmall.mapper.WxProductMapper;
import com.wx.shopmall.service.WxProductService;
import com.wx.shopmall.vo.WxProductResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public Page<WxProductResultVo> productIndex(Page<WxProductResultVo> page,Long id) {
        Page<WxProductResultVo> pageList =  wxProductMapper.productIndex(page,id);
        return pageList;
    }


    @Override
    public WxProduct proDetal(Long id) {
        WxProduct wxProduct = wxProductMapper.proDetal(id);
        if (ObjectUtil.isNotEmpty(wxProduct)){
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
