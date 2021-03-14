package com.wx.shopmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: jack
 * @Date: 2021/3/12 20:55
 * @Description:
 */

@Data

@ApiModel(value = "收货人地址实体类")
public class WxAddress {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id" ,type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "收货人id")
    private Long userId;

    @ApiModelProperty(value = "收货人名字")
    private String name;

    @ApiModelProperty(value = "收货人电话")
    private String  tel;

    @ApiModelProperty(value = "省份")
    private String  province;

    @ApiModelProperty(value = "收货人城市")
    private String  city;

    @ApiModelProperty(value = "收货人地区")
    private String county;

    @ApiModelProperty(value = "收货人城市代码")
    private String addressCode;

    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    @ApiModelProperty(value = "是偶是默认收货人地址1默认 2 非默认")
    private Boolean isDefault;

    @ApiModelProperty(value = "是否可用 1 可用 2 不可用")
    private int flag;









}
