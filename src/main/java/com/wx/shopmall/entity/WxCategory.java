package com.wx.shopmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: jack
 * @Date: 2021/3/10 12:45
 * @Description:
 */
@Data
@ApiModel(value = "一级分类实体类")
public class WxCategory {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id" ,type = IdType.AUTO)
    private Long id ;

    @ApiModelProperty(value = "父节点")
    private Integer parentId;

    @ApiModelProperty(value = "分类名陈")
    private String  categoryName;

    @ApiModelProperty(value = "分类状态是否可用 1-正常,2-已废弃")
    private Integer status;

    @ApiModelProperty(value = "排序编号,同类展示顺序,数值相等则自然排序")
    private Integer sortorder;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
