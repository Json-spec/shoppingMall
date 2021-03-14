package com.wx.shopmall.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.common.RResult;
import com.wx.shopmall.entity.WxFootprint;
import com.wx.shopmall.entity.WxProduct;
import com.wx.shopmall.service.WxFootprintService;
import com.wx.shopmall.vo.WxProductResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/footprint")
@Api(value = "浏览足迹")
public class WxFootprintController {

    private static final Logger logger = LoggerFactory.getLogger(WxFootprintController.class);

    @Autowired
    private WxFootprintService wxFootprintService;


    /**
     * 浏览足迹列表（更具用户id）
     */

    @RequestMapping("/list")
    @ApiOperation(value = "足迹列表")
    public RResult<Page<WxProductResultVo>> footprintList(@RequestParam("userId") Long userId,
                                                          @RequestParam("page") Integer page ,
                                                          @RequestParam("limit") Integer limit){
        Page<WxProductResultVo> pageList = wxFootprintService.footprintList(new Page<WxProductResultVo>(page, limit),userId);
        logger.info("返回数据"+pageList);
        if (ObjectUtil.isNotEmpty(pageList)) {
            return RResult.success(pageList);
        } else {
            return RResult.failed();
        }
    }

    /**
     * 根据记录id删除浏览记录
     */
    @RequestMapping("/delete")
    @ApiOperation(value = "根据记录id删除浏览记录")
    public RResult footprintDelete(@RequestParam("id") Long id){
        int flag= wxFootprintService.footprintDelete(id);
        logger.info("返回数据"+flag);
        if (flag==1) {
            return RResult.success();
        } else {
            return RResult.failed();
        }
    }

}
