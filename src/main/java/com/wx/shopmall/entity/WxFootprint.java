package com.wx.shopmall.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "浏览足迹实体类")

public class WxFootprint {

    @ApiModelProperty(value = "浏览足迹id")
    @TableId(value = "id" , type= IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品id")
    private Long proId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 1不删除 2 删除")
    private int flag;

    @ApiModelProperty(value = "是否收藏 1 收藏 2 不收藏")
    private int isCollection;



}
