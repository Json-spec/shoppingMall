package com.wx.shopmall.service;

import com.wx.shopmall.vo.LoginParamVo;

/**
 * @Auther: jack
 * @Date: 2021/2/24 13:09
 * @Description:
 */
public interface UserInfoControllerService {
    /**
     * @Author jack
     * @Description 微信登录通过code获取openid和sesssionKey
     * @Date  2021/2/24
     * @Param
     * @return
     **/
    Object weChatLogin(LoginParamVo loginParamVo);
}
