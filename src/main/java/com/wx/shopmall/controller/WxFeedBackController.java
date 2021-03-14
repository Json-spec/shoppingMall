package com.wx.shopmall.controller;

import cn.hutool.core.util.ObjectUtil;
import com.wx.shopmall.common.RResult;
import com.wx.shopmall.service.WxFeedBackService;
import com.wx.shopmall.vo.CatalogIndexResultVo;
import com.wx.shopmall.vo.WxAddFeedSubmitParamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/feedback")
@RestController
@Api(tags = "意见反馈")
public class WxFeedBackController {

    private static final Logger logger = LoggerFactory.getLogger(WxFeedBackController.class);

    @Autowired
    private WxFeedBackService wxFeedBackService;

    /**
     * 意见反馈添加
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/submit")
    @ApiOperation(value = "意见反馈添加")
    public RResult addFeedSubmit(@RequestBody WxAddFeedSubmitParamVo wxAddFeedSubmitParamVo) {
        int flag = wxFeedBackService.addFeedSubmit(wxAddFeedSubmitParamVo);
        if (flag==1) {
            return RResult.success();
        } else {
            return RResult.failed();
        }
    }



}
