package com.wx.shopmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.shopmall.entity.WxCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/10 12:53
 * @Description:
 */
@Mapper
public interface WxCategoryMapper extends BaseMapper<WxCategory> {
    /**
     * @Author jack
     * @Description 查询默认所有可用分类
     * @Date  2021/3/10
     * @Param
     * @return
     **/
    List<WxCategory> catalogIndex();
}
