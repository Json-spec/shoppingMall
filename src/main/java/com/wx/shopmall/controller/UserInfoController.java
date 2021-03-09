package com.wx.shopmall.controller;

import com.wx.shopmall.common.RResult;
import com.wx.shopmall.service.UserInfoControllerService;
import com.wx.shopmall.vo.LoginParamVo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
     * @return
     * @Author jack
     * @Description 登录 (通过code获取openid和sessionkey)
     * @Date 2021/2/24
     * @Param
     **/
    @ApiOperation(value = "微信登录")
    @PostMapping("/wxlogin")
    public RResult<Object> weChatLogin(@RequestBody LoginParamVo loginParamVo, HttpServletRequest request, HttpServletResponse response) {
        if (ObjectUtil.isNotEmpty(loginParamVo)) {
                Object obj = userInfoControllerService.weChatLogin(loginParamVo);
                if (ObjectUtil.isNotEmpty(obj)) {
                    return RResult.success(obj);
                } else {
                    return RResult.failed();
                }
        } else {
            throw new NullPointerException("参数不能为空");
        }

    }


}
