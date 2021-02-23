package com.wx.shopmall.service.impl;

import com.wx.shopmall.mapper.testMapper;
import com.wx.shopmall.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
 class testServerImp implements testService {

    @Autowired
    private testMapper testMapper;

    @Override
    public String index() {
        String s = UUID.randomUUID().toString();
        return s;
    }
}
