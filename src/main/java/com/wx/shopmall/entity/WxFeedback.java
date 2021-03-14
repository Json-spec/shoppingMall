package com.wx.shopmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "意见反馈")
public class WxFeedback {

    @ApiModelProperty(value = "id")
    @TableId(value = "id" ,type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "反馈类型")
    private String feedType;

    @ApiModelProperty(value = "反馈内容")
    private String content;


    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "处理状态 （1 未处理 2处理中 3 已处理）")
    private Integer state;

    @ApiModelProperty(value = "反馈图片")
    private String feedImg;


}
