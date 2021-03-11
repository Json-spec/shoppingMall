package com.wx.shopmall.vo;

import com.wx.shopmall.entity.WxCategoryBrand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/10 21:59
 * @Description:
 */
@Data
@ApiModel("二级分类品牌")
public class WxCategoryBrandRresultVo {


    @ApiModelProperty(value = "二级分类品牌明细")
    private List<WxCategoryBrand> currentSubCategoryList;
}
