package com.wx.shopmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: jack
 * @Date: 2021/2/24 13:12
 * @Description:
 */

@Data
@ApiModel(description="用户信息表")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value ="id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String  userName;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "sessionKey")
    private String sessionKey;

    @ApiModelProperty(value = "头像")
    private String imgUrl;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;
}
