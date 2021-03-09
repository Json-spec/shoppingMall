package com.wx.shopmall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: jack
 * @Date: 2021/3/9 17:32
 * @Description:
 */
@Data
public class UserInfo {

    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    @ApiModelProperty(value = "地址")
    private String city;

    @ApiModelProperty(value = "地址")
    private String country;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "地址")
    private String language;

    @ApiModelProperty(value = "用户名")
    private String  nickName;

    private String province;





}
