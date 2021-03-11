package com.wx.shopmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: jack
 * @Date: 2021/3/10 21:50
 * @Description:
 */
@Data
@ApiModel(value = "二级分类表")
public class WxCategoryBrand {

    @TableId(value = "id" , type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父id")
    private Long categoryId;

    @ApiModelProperty(value = "'商品名称'" )
    private String brandName;

    @ApiModelProperty(value = "商品主图")
    private String brandImg;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否可用 1 可用 2 不可用")
    private Integer baranState;



}
