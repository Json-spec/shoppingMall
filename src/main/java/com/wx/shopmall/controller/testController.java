package com.wx.shopmall.controller;

import com.wx.shopmall.service.testService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "测试")
public class testController {

    @Autowired
    private testService testService;

    @GetMapping("/index")

    public String index(){
        String str = testService.index();
        return str;
    }
}
