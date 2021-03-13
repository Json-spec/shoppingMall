package com.wx.shopmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wx.shopmall.controller.WxProductController;
import com.wx.shopmall.entity.User;
import com.wx.shopmall.entity.WxAddress;
import com.wx.shopmall.mapper.UserInfoMapper;
import com.wx.shopmall.mapper.WxAddressMapper;
import com.wx.shopmall.service.WxAddressService;
import com.wx.shopmall.vo.WxAddressResultVo;
import com.wx.shopmall.vo.WxProductResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/12 22:02
 * @Description:
 */
@Service
public class WxAddressServiceImpl implements WxAddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxAddressServiceImpl.class);


    @Autowired
    private WxAddressMapper wxAddressMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * @Author jack
     * @Description 添加收货人信息
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    @Override
    public int saveAddressMsg(String id , WxAddress wxAddress) {
        //根据id查询到用户id然后进行维护到收货人地址表中
        User user = userInfoMapper.selectByUserName(id);
        wxAddress.setUserId(user.getId());
        return wxAddressMapper.insert(wxAddress);
    }

    @Override
    public WxAddressResultVo queryAddressList(Long id) {
        WxAddressResultVo wxAddressResultVo = new WxAddressResultVo();
        List<WxAddress> wxAddressesList = wxAddressMapper.selectList(new QueryWrapper<WxAddress>().eq("user_id", id));
        wxAddressResultVo.setList(wxAddressesList);
        return wxAddressResultVo;
    }

    @Override
    public WxAddress queryAddressDetail(Long id) {
        QueryWrapper<WxAddress> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.lambda().eq(WxAddress::getId,id);
        WxAddress wxAddress = wxAddressMapper.selectOne(objectQueryWrapper);
        return wxAddress;
    }

    @Override
    public int deleteAddress(Long id) {
        int i = wxAddressMapper.deleteById(id);
        return i;
    }
}
