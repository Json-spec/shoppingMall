package com.wx.shopmall.service.impl;

import com.wx.shopmall.entity.WxCategoryBrand;
import com.wx.shopmall.mapper.WxCategoryBrandMapper;
import com.wx.shopmall.service.WxCategoryBrandService;
import com.wx.shopmall.vo.WxCategoryBrandRresultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/10 21:49
 * @Description:
 */
@Service
public class WxCategoryBrandServiceImpl implements WxCategoryBrandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxCategoryBrandServiceImpl.class);

    @Autowired
    private WxCategoryBrandMapper wxCategoryBrandMapper;

    /**
     * @Author jack
     * @Description 根据父id查看品牌
     * @Date  2021/3/10
     * @Param
     * @return
     **/
    @Override
    public WxCategoryBrandRresultVo queryBrandList(Long categoryId) {

        WxCategoryBrandRresultVo wxCategoryBrandRresultVo = new WxCategoryBrandRresultVo();
        List<WxCategoryBrand> wxCategoryBrand = wxCategoryBrandMapper.queryBrandList(categoryId);
        wxCategoryBrandRresultVo.setCurrentSubCategoryList(wxCategoryBrand);
        return wxCategoryBrandRresultVo;
    }
}
