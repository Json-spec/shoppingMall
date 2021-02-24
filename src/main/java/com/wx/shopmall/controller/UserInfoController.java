package com.wx.shopmall.controller;

import com.wx.shopmall.common.RResult;
import com.wx.shopmall.service.UserInfoControllerService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.hutool.core.util.ObjectUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: jack
 * @Date: 2021/2/24 13:08
 * @Description:
 */
@RestController
public class UserInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoControllerService userInfoControllerService;

    /**
     * @Author jack
     * @Description 登录 (通过code获取openid和sessionkey)
     * @Date  2021/2/24
     * @Param
     * @return
     **/
    @ApiOperation(value = "微信登录")
    @GetMapping("/wxlogin")
    public RResult<Object> weChatLogin(@RequestParam(value = "code") String code , HttpServletRequest request , HttpServletResponse response){
        Object obj = userInfoControllerService.weChatLogin(code);
        if(ObjectUtil.isNotEmpty(obj)){
            return RResult.success(obj);
        }else{
            return RResult.failed();
        }
    }



}
