package com.wx.shopmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "意见反馈请求参数")
public class WxAddFeedSubmitParamVo {


    @ApiModelProperty(value ="用户id")
    private Long userId;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "反馈类型")
    private String feedType;

    @ApiModelProperty(value = "内容")
    private String  content;

    @ApiModelProperty(value = "是否有图片")
    private Boolean hasPicture;

    @ApiModelProperty(value = "图片集合")
    private String[] picUrls;

}
