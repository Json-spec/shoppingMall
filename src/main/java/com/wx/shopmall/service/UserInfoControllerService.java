package com.wx.shopmall.service;

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
    Object weChatLogin(String code);
}
