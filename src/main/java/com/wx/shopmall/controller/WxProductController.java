package com.wx.shopmall.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shopmall.common.RResult;
import com.wx.shopmall.entity.WxProduct;
import com.wx.shopmall.service.WxProductService;
import com.wx.shopmall.vo.CatalogIndexResultVo;
import com.wx.shopmall.vo.WxProductResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: jack
 * @Date: 2021/3/11 21:28
 * @Description:
 */
@RequestMapping("/goods")
@RestController
@Api(tags = "商品清单")
public class WxProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxProductController.class);


    @Autowired
    private WxProductService wxProductService;


    /**
     * @return
     * @Author jack
     * @Description 根据二级分类id查询商品信息
     * @Date 2021/3/10
     * @Param
     **/
    @GetMapping(value = "/category")
    @ApiOperation(value = "根据二级分类id查询商品信息")
    public RResult<Page<WxProductResultVo>> productIndex(@RequestParam("id") Long id , @RequestParam("page") Integer page , @RequestParam("limit") Integer limit) {
        Page<WxProductResultVo> wxProductResultVo = wxProductService.productIndex(new Page<WxProductResultVo>(page, limit) , id);
        LOGGER.info("返回数据"+wxProductResultVo);
        if (ObjectUtil.isNotEmpty(wxProductResultVo)) {
            return RResult.success(wxProductResultVo);
        } else {
            return RResult.failed();
        }
    }


    /**
     * @Author jack
     * @Description 根据商品id查询具体详情
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    @GetMapping(value = "/detail")
    @ApiOperation(value = "根据商品id查询具体详情")
    public RResult<WxProduct> proDetal(@ApiParam(value = "商品id")
                                       @RequestParam("id") Long id){
        WxProduct wxProduct = wxProductService.proDetal(id);
        LOGGER.info("返回数据"+wxProduct);
        if (ObjectUtil.isNotEmpty(wxProduct)) {
            return RResult.success(wxProduct);
        } else {
            return RResult.failed();
        }
    }

    /**
     * @Author jack
     * @Description 总共商品数量
     * @Date  2021/3/12
     * @Param
     * @return
     **/
    @GetMapping(value = "/count")
    @ApiOperation(value = "根据商品id查询具体详情")
    public RResult<Integer> productCount(){
        Integer count = wxProductService.productCount();
        LOGGER.info("返回数据"+count);
       return RResult.success(count);
    }



}
