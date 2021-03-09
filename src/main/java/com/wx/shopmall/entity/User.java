package com.wx.shopmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: jack
 * @Date: 2021/3/9 17:35
 * @Description:
 */
@Data
public class User {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value ="id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String  nickName;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "sessionKey")
    private String sessionKey;

    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "地址")
    private String city;

    private String province;

    @ApiModelProperty(value = "地址")
    private String country;

    @ApiModelProperty(value = "地址")
    private String language;
}
