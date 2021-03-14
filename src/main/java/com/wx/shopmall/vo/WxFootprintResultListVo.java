package com.wx.shopmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "浏览历史清单返回数据")
public class WxFootprintResultListVo {

    @ApiModelProperty(value = "商品id")
    private Long proId;

    @ApiModelProperty(value = "浏览记录id")
    private Long footprintId;

    @ApiModelProperty(value = "产品名称")
    private String proName;

    @ApiModelProperty(value = "产品描述")
    private String proDesc;

    @ApiModelProperty(value = "产品价格")
    private BigDecimal proProice;

    @ApiModelProperty(value = "封面图")
    private String proImg;

    @ApiModelProperty(value = "封面图")
    private String addDate;




}
