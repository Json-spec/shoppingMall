package com.wx.shopmall.service;

import com.wx.shopmall.vo.WxAddFeedSubmitParamVo;

public interface WxFeedBackService {
    /**
     * 意见反馈添加
     * @param wxAddFeedSubmitParamVo
     * @return
     */
    int addFeedSubmit(WxAddFeedSubmitParamVo wxAddFeedSubmitParamVo);
}
