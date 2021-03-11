package com.wx.shopmall.mapper;

import com.wx.shopmall.entity.WxCategoryBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/10 21:50
 * @Description:
 */
@Mapper
public interface WxCategoryBrandMapper {

    /**
     * @Author jack
     * @Description 根据父id查看品牌
     * @Date  2021/3/10
     * @Param
     * @return
     **/
    List<WxCategoryBrand> queryBrandList(@Param("categoryId") Long categoryId);
}
