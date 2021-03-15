package com.wx.shopmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.entity.WxCategoryBrand;
import com.wx.shopmall.vo.WxProductResultSeachVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jack
 * @Date: 2021/3/10 21:50
 * @Description:
 */
@Mapper
public interface WxCategoryBrandMapper extends BaseMapper<WxCategoryBrand> {

    /**
     * @Author jack
     * @Description 根据父id查看品牌
     * @Date  2021/3/10
     * @Param
     * @return
     **/
    List<WxCategoryBrand> queryBrandList(@Param("categoryId") Long categoryId);

    Page<WxProductResultSeachVo> queryGoodsList(Page<WxProductResultSeachVo> wxProductResultSeachVoPage,@Param("map") Map<String, Object> map);
}
