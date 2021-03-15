package com.wx.shopmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.entity.WxProduct;
import com.wx.shopmall.vo.WxProductResultSeachVo;
import com.wx.shopmall.vo.WxProductResultVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jack
 * @Date: 2021/3/11 21:32
 * @Description:
 */
@Mapper
public interface WxProductMapper extends BaseMapper<WxProduct> {

    Page<WxProductResultVo> productIndex(Page<WxProductResultVo> page,Long id);

    WxProduct proDetal(@Param("id") Long id);

    Integer productCount();

    /**
     * 商品搜索
     * @param wxProductResultVoPage
     * @param map
     * @return
     */
    Page<WxProductResultSeachVo> queryGoodslist(Page<WxProductResultSeachVo> wxProductResultVoPage, @Param("map") Map<String, Object> map);
}
