package com.wx.shopmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wx.shopmall.controller.WxProductController;
import com.wx.shopmall.entity.User;
import com.wx.shopmall.entity.WxAddress;
import com.wx.shopmall.mapper.UserInfoMapper;
import com.wx.shopmall.mapper.WxAddressMapper;
import com.wx.shopmall.service.WxAddressService;
import com.wx.shopmall.vo.WxAddressResultVo;
import com.wx.shopmall.vo.WxProductResultVo;
import org.apache.commons.lang.ObjectUtils;
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
        //判断添加地址是否是默认的并查询数据库有没有设置过
        if (wxAddress.getIsDefault()){
            WxAddress wxAddress1 = wxAddressMapper.selectOne(new QueryWrapper<WxAddress>().eq("user_id", user.getId()).eq("is_default", 1));
            if (ObjectUtil.isNotEmpty(wxAddress1)){
                wxAddress1.setIsDefault(false);
                wxAddressMapper.updateById(wxAddress1);
            }else{
                wxAddress.setFlag(1);
                wxAddressMapper.insert(wxAddress);
            }
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public WxAddressResultVo queryAddressList(String id) {
        WxAddressResultVo wxAddressResultVo = new WxAddressResultVo();
        User user = userInfoMapper.selectByUserName(id);
        List<WxAddress> wxAddressesList = wxAddressMapper.selectList(new QueryWrapper<WxAddress>().eq("user_id", user.getId())
                                                                                                  .eq("flag",1));
        wxAddressResultVo.setList(wxAddressesList);
        return wxAddressResultVo;
    }

    @Override
    public WxAddress queryAddressDetail(Long id) {
        QueryWrapper<WxAddress> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.lambda().eq(WxAddress::getId,id).eq(WxAddress::getFlag,1);
        WxAddress wxAddress = wxAddressMapper.selectOne(objectQueryWrapper);
        return wxAddress;
    }

    @Override
    public int deleteAddress(Long id) {
        WxAddress wxAddress = this.queryAddressDetail(id);
        if (ObjectUtil.isNotEmpty(wxAddress)){
            int update = wxAddressMapper.update(null, new UpdateWrapper<WxAddress>().set("flag", 2).eq("id", id));
            return update;
        }else{
            return 0 ;
        }
    }
}
