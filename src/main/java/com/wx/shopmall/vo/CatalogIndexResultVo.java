package com.wx.shopmall.vo;

import com.wx.shopmall.entity.WxCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/10 12:59
 * @Description:
 */
@Data
@ApiModel(value = "小程序默认返回的分类")
public class CatalogIndexResultVo {

    @ApiModelProperty(value = "分类数组")
    private List<WxCategory> wxCategoryList;
}
