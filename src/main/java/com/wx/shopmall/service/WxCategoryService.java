package com.wx.shopmall.service;

import com.wx.shopmall.vo.CatalogIndexResultVo;

/**
 * @Auther: jack
 * @Date: 2021/3/10 12:51
 * @Description:
 */
public interface WxCategoryService {

    /**
     * @Author jack
     * @Description 查询默认分类
     * @Date  2021/3/10
     * @Param
     * @return
     **/
    CatalogIndexResultVo catalogIndex();
}
