package com.wx.shopmall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.entity.WxProduct;
import com.wx.shopmall.vo.WxProductResultVo;

/**
 * @Auther: jack
 * @Date: 2021/3/11 21:30
 * @Description:
 */
public interface WxProductService {

    /**
     * @return
     * @Author jack
     * @Description 根据二级分类id查询商品信息
     * @Date 2021/3/10
     * @Param
     **/
    Page<WxProductResultVo> productIndex(Page<WxProductResultVo> page ,Long id);

    /**
     * @Author jack
     * @Description 根据商品id查询具体详情
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    WxProduct proDetal(Long id);

    /**
     * @Author jack
     * @Description 查询产品总数
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    Integer productCount();
}
