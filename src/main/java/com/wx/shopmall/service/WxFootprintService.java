package com.wx.shopmall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.vo.WxFootprintResultListVo;
import com.wx.shopmall.vo.WxProductResultVo;

public interface WxFootprintService {
    /**
     * 根据商品id插入数据
     * @param id
     * @return
     */
    int insertWxFootprint(Long id,Long userId);

    /**
     * 根据用户id查看足迹
     * @param wxProductResultVoPage
     * @param userId
     * @return
     */
    Page<WxProductResultVo> footprintList(Page<WxProductResultVo> wxProductResultVoPage, Long userId);

    /**
     * 根据记录id删除浏览记录
     * @param id
     * @return
     */
    int footprintDelete(Long id);

    /**
     * 商品收藏和取消
     * @param userId
     * @param proId
     * @param type
     * @return
     */
    int collectAddordelte(Long userId, Long proId, Integer type);

    /**
     * 查询商品收藏列表
     * @param wxFootprintResultListVoPage
     * @param userId
     * @param type
     * @return
     */
    Page<WxFootprintResultListVo> collectList(Page<WxFootprintResultListVo> wxFootprintResultListVoPage, Long userId, Integer type);
}
