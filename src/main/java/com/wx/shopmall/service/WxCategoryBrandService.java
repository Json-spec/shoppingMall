package com.wx.shopmall.service;

import com.wx.shopmall.vo.WxCategoryBrandRresultVo;

/**
 * @Auther: jack
 * @Date: 2021/3/10 21:48
 * @Description:
 */
public interface WxCategoryBrandService {
    /**
     * @Author jack
     * @Description 根据父id查看品牌
     * @Date  2021/3/10
     * @Param
     * @return
     **/
    WxCategoryBrandRresultVo queryBrandList(Long categoryId);
}
