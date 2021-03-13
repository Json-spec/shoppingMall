package com.wx.shopmall.vo;

import com.wx.shopmall.entity.WxAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/12 23:20
 * @Description:
 */
@Data
@ApiModel(value = "收货人地址集合")
public class WxAddressResultVo {


    @ApiModelProperty(value = "收货人地址")
    private List<WxAddress> list;
}
