package com.wx.shopmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.entity.WxFootprint;
import com.wx.shopmall.vo.WxProductResultVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxFootprintMapper extends BaseMapper<WxFootprint> {

    /**
     * 根据用户id查看足迹
     * @param wxProductResultVoPage
     * @param userId
     * @return
     */
    Page<WxProductResultVo> footprintList(Page<WxProductResultVo> wxProductResultVoPage, Long userId);
}
