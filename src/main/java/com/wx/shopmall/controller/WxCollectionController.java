package com.wx.shopmall.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.common.RResult;
import com.wx.shopmall.service.WxFootprintService;
import com.wx.shopmall.vo.WxFootprintResultListVo;
import com.wx.shopmall.vo.WxProductResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "商品收藏")
@RequestMapping(value = "/collect")
public class WxCollectionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxCollectionController.class);

    //收藏功能可以通过浏览记录表中进行操作
    //浏览表中有一个字段是记录是否收藏的

    @Autowired
    private WxFootprintService wxFootprintService;

    /**
     * 商品收藏和取消
     * @param userId
     * @param proId
     * @param type
     * @return
     */

    @GetMapping(value = "/addordelete")
    @ApiOperation(value = "收藏/取消")
    public RResult collectAddordelte(@RequestParam("userId") Long userId ,
                                     @RequestParam("proId") Long proId ,
                                     @RequestParam("type") Integer type ){
        int flag = wxFootprintService.collectAddordelte(userId , proId , type);
        if (flag==1){
            return RResult.success();
        }else{
            return RResult.failed();
        }
    }

    /**
     * 商品收藏
     * @param userId
     * @param type
     * @param page
     * @param limit
     * @return
     */

    @GetMapping(value = "/list")
    @ApiOperation(value = "收藏列表")
    public RResult<Page<WxFootprintResultListVo>> collectList(@RequestParam("userId") Long userId ,@RequestParam("type") Integer type , @RequestParam("page") Integer page , @RequestParam("limit") Integer limit){
        Page<WxFootprintResultListVo> pageList =wxFootprintService.collectList(new Page<WxFootprintResultListVo>(page,limit),userId,type);
        LOGGER.info("返回数据"+pageList);
        if (ObjectUtil.isNotEmpty(pageList)) {
            return RResult.success(pageList);
        } else {
            return RResult.failed();
        }

    }
}
