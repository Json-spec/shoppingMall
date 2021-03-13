package com.wx.shopmall.service;

import com.wx.shopmall.entity.WxAddress;
import com.wx.shopmall.vo.WxAddressResultVo;

/**
 * @Auther: jack
 * @Date: 2021/3/12 22:02
 * @Description:
 */
public interface WxAddressService {
    /**
     * @Author jack
     * @Description 添加收货人信息
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    int saveAddressMsg(String id ,WxAddress wxAddress);

    /**
     * @Author jack
     * @Description 通过登录人id查看所有收货地址
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    WxAddressResultVo queryAddressList(Long id);

    /**
     * @Author jack
     * @Description 根据收货id查看地址详情
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    WxAddress queryAddressDetail(Long id);
/**
 * @Author jack
 * @Description 根据地址低删除地址
 * @Date  2021/3/12
 * @Param
 * @return
 **/
    int deleteAddress(Long id);
}
