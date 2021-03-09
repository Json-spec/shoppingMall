package com.wx.shopmall.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: jack
 * @Date: 2021/3/8 12:47
 * @Description:
 */
@Data
@ApiModel("登录参数接受类")
public class LoginParamVo  {

    @ApiModelProperty(value = "code状态码")
    private String code;

    @ApiModelProperty(value ="用户信息")
    private UserInfo userInfo;
}
