package com.wx.shopmall.controller;

import cn.hutool.core.util.ObjectUtil;
import com.wx.shopmall.common.RResult;
import com.wx.shopmall.service.WxCategoryBrandService;
import com.wx.shopmall.service.WxCategoryService;
import com.wx.shopmall.vo.CatalogIndexResultVo;
import com.wx.shopmall.vo.WxCategoryBrandRresultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: jack
 * @Date: 2021/3/10 12:51
 * @Description:
 */
@Api(tags = "分类")
@RestController
@RequestMapping(value = "/catalog")
public class WxCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxCategoryController.class);

    @Autowired
    private WxCategoryService wxCategoryService;

    @Autowired
    private WxCategoryBrandService wxCategoryBrandService;


    /**
     * @return
     * @Author jack
     * @Description 获取所有分类
     * @Date 2021/3/10
     * @Param
     **/
   @GetMapping(value = "/index")
   @ApiOperation(value = "查看默认分类列表")
    public RResult<CatalogIndexResultVo> catalogIndex(HttpServletRequest request, HttpServletResponse response) {
        CatalogIndexResultVo catalogIndexResultVo = wxCategoryService.catalogIndex();
       LOGGER.info("返回数据"+catalogIndexResultVo);
        if (ObjectUtil.isNotEmpty(catalogIndexResultVo)) {
            return RResult.success(catalogIndexResultVo);
        } else {
            return RResult.failed();
        }
    }


    @GetMapping(value = "/current/{id}")
    @ApiOperation(value = "根据父id查看品牌")
    public RResult<WxCategoryBrandRresultVo> queryBrandList(@PathVariable Long id){
        WxCategoryBrandRresultVo currentSubCategoryList  = wxCategoryBrandService.queryBrandList(id);
        if (ObjectUtil.isNotEmpty(currentSubCategoryList)){
            return RResult.success(currentSubCategoryList);
        }else{
            return RResult.failed();
        }
    }
}