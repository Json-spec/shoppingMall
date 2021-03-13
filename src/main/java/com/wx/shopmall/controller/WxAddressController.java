package com.wx.shopmall.controller;

import cn.hutool.core.util.ObjectUtil;
import com.wx.shopmall.common.RResult;
import com.wx.shopmall.entity.WxAddress;
import com.wx.shopmall.service.WxAddressService;
import com.wx.shopmall.vo.WxAddressResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: jack
 * @Date: 2021/3/12 21:32
 * @Description:
 */

@RestController
@Api(tags = "收货人地址")
@RequestMapping(value = "/address")
public class WxAddressController {

    private static final Logger logger = LoggerFactory.getLogger(WxAddressController.class);

    @Autowired
    private WxAddressService wxAddressService;

    /**
     * @Author jack
     * @Description 添加收货人信息
     * @Date  2021/3/12
     * @Param
     * @return
     **/

    @RequestMapping(value = "/save/{code}")
    @ApiOperation(value = "添加收货人信息")
    public RResult saveAddressMsg(@PathVariable String id ,  @RequestBody WxAddress wxAddress){
        logger.info("参数"+wxAddress);
        int flag = wxAddressService.saveAddressMsg(id, wxAddress);
        if (flag==1){
            return RResult.success();
        }else{
            return RResult.failed();
        }
    }


    /**
     * @Author jack
     * @Description 通过登录人id查看收货人列表
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    @RequestMapping(value = "/list")
    @ApiOperation(value = "查看登录人全部收货地址")
    public RResult<WxAddressResultVo> queryAddressList(@RequestParam("id") Long id){
        logger.info("参数"+id);
        WxAddressResultVo wxAddressResultVo =  wxAddressService.queryAddressList(id);
        if (ObjectUtil.isNotEmpty(wxAddressResultVo)){
            return RResult.success(wxAddressResultVo);
        }else{
            return RResult.failed();
        }
    }


    /**
     * @Author jack
     * @Description 通过收货id查看收货人列表
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    @RequestMapping(value = "/detail")
    @ApiOperation(value = "查看地址详情")
    public RResult<WxAddress> queryAddressDetail(@RequestParam("id") Long id){
        logger.info("参数"+id);
        WxAddress wxAddress =  wxAddressService.queryAddressDetail(id);
        if (ObjectUtil.isNotEmpty(wxAddress)){
            return RResult.success(wxAddress);
        }else{
            return RResult.failed();
        }
    }


    /**
     * @Author jack
     * @Description 通过收货id查看收货人列表
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    @RequestMapping(value = "/delete")
    @ApiOperation(value = "根据删除地址")
    public RResult<WxAddress> deleteAddress(@RequestParam("id") Long id){
        logger.info("参数"+id);
        int flag =  wxAddressService.deleteAddress(id);
        if (flag==1){
            return RResult.success();
        }else{
            return RResult.failed();
        }
    }
}





