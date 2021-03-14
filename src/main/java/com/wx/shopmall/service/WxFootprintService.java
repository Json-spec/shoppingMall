package com.wx.shopmall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
}
