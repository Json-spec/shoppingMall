package com.wx.shopmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jack
 * @Date: 2021/3/11 21:34
 * @Description:
 */
@Data
@ApiModel(description="")
public class WxProduct  implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键")
    @TableId(value ="id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "上级id")
    private Long wcbId;

    @ApiModelProperty(value = "产品名称")
    private String proName;

    @ApiModelProperty(value = "产品描述")
    private String proDesc;

    @ApiModelProperty(value = "产品价格")
    private BigDecimal proProice;

    @ApiModelProperty(value = "是否上线1上线2不上线")
    private Integer isOnline;

    @ApiModelProperty(value = "单位")
    private String proUnit;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "折扣")
    private BigDecimal proRebate;

    @ApiModelProperty(value = "封面图")
    private String proImg;

    @ApiModelProperty(value = "图片集合")
    private String proImgList;

    @ApiModelProperty(value = "是否热卖 1 热卖 2 非热卖")
    private Integer isHost;

    @ApiModelProperty(value = "商品标题")
    private String proTitle;

    @ApiModelProperty(value = "库存")
    private Integer proCount;
    public WxProduct() {}

}
