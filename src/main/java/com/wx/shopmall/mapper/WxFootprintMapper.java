package com.wx.shopmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.entity.WxFootprint;
import com.wx.shopmall.vo.WxFootprintResultListVo;
import com.wx.shopmall.vo.WxProductResultVo;
import io.swagger.annotations.ApiResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxFootprintMapper extends BaseMapper<WxFootprint> {

    /**
     * 根据用户id查看足迹
     * @param wxProductResultVoPage
     * @param userId
     * @return
     */
    Page<WxProductResultVo> footprintList(Page<WxProductResultVo> wxProductResultVoPage, Long userId);

    /**
     * 查询收藏列表
     * @param wxFootprintResultListVoPage
     * @param userId
     * @param type
     * @return
     */
    Page<WxFootprintResultListVo> collectList(Page<WxFootprintResultListVo> wxFootprintResultListVoPage, @Param("userId") Long userId);
}
