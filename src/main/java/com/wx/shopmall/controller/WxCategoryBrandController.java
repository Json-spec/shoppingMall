package com.wx.shopmall.controller;

import cn.hutool.core.util.ObjectUtil;
import com.wx.shopmall.common.RResult;
import com.wx.shopmall.service.WxCategoryBrandService;
import com.wx.shopmall.vo.WxCategoryBrandRresultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: jack
 * @Date: 2021/3/10 21:46
 * @Description:
 */
@RequestMapping("/wxCategoryBrand")
@RestController
@Api(tags = "品牌二级分类")
public class WxCategoryBrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxCategoryBrandController.class);


    @Autowired
    private WxCategoryBrandService wxCategoryBrandService;

    /**
     * @Author jack
     * @Description 根据父id查看品牌
     * @Date  2021/3/10
     * @Param
     * @return
     **/

    @PostMapping(value = "/queryBrandList")
    @ApiOperation(value = "根据父id查看品牌")
    public RResult<WxCategoryBrandRresultVo> queryBrandList(@RequestParam(value = "categoryId") Long categoryId){
        WxCategoryBrandRresultVo currentSubCategoryList  = wxCategoryBrandService.queryBrandList(categoryId);
        if (ObjectUtil.isNotEmpty(currentSubCategoryList)){
            return RResult.success(currentSubCategoryList);
        }else{
            return RResult.failed();
        }
    }

}




