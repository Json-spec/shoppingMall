package com.wx.shopmall.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.wx.shopmall.entity.WxCategory;
import com.wx.shopmall.mapper.WxCategoryMapper;
import com.wx.shopmall.service.WxCategoryService;
import com.wx.shopmall.vo.CatalogIndexResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/10 12:52
 * @Description:
 */
@Service
public class WxCategoryServiceImpl implements WxCategoryService {
    @Autowired
    private WxCategoryMapper wxCategoryMapper;

    @Override
    public CatalogIndexResultVo catalogIndex() {
        CatalogIndexResultVo catalogIndexResultVo = new CatalogIndexResultVo();
        List<WxCategory> list = wxCategoryMapper.catalogIndex();
        if (CollectionUtil.isNotEmpty(list) && list.size()>0){
            catalogIndexResultVo.setWxCategoryList(list);
        }
        return catalogIndexResultVo;
    }
}
