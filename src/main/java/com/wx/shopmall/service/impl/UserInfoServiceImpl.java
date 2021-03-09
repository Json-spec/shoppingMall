package com.wx.shopmall.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.druid.wall.violation.ErrorCode;
import com.alibaba.fastjson.JSONObject;
import com.wx.shopmall.common.Constants;
import com.wx.shopmall.common.HttpClientUtils;
import com.wx.shopmall.controller.UserInfoController;
import com.wx.shopmall.entity.User;
import com.wx.shopmall.mapper.UserInfoMapper;
import com.wx.shopmall.service.UserInfoControllerService;
import com.wx.shopmall.vo.LoginParamVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: jack
 * @Date: 2021/2/24 13:09
 * @Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoControllerService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Value("${weChat.url}")
    private String url;

    @Value("${weChat.appSecret}")
    private String appSecret;

    @Value("${weChat.appId}")
    private String appId;

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String weChatLogin(LoginParamVo loginParamVo) {
        try {
            if (ObjectUtil.isNotEmpty(loginParamVo.getCode()) && "".equals(loginParamVo.getCode())){
                throw  new Exception("code不能为空");
            }else{
                User user = new User();
                //登录参数获取的业务实现
                JSONObject weChatSession = getWeChatSession(loginParamVo.getCode(), url, appSecret, appId);
                logger.info(weChatSession.toString());
                //wechat返回的openId
                String  openId = weChatSession.getString("openid");
                //wechat返回的sessionKey
                String  sessionKey  = weChatSession.getString("session_key");
                //组装得到的结果看是否在数据库中
                //组装结果
                Map<String,Object> resMap = new HashMap<String,Object>();
                User userInfo = userInfoMapper.selectByUserName(openId);
                if (ObjectUtil.isNotEmpty(userInfo)){
                    logger.info("验证是否绑定微信", "用户查询成功");
                    //0:操作成功
                    resMap.put("code", Constants.SUCCESS);
                    resMap.put("desc", Constants.SUCCESS_MESSAGE);
                    resMap.put("userInfo", userInfo);
                }else{
                    logger.info("验证是否绑定微信","未登录");
                    resMap.put("code", Constants.SUCCESS);
                    resMap.put("desc",Constants.SUCCESS_MESSAGE);
                    user.setAvatarUrl(loginParamVo.getUserInfo().getAvatarUrl());
                    user.setCity(loginParamVo.getUserInfo().getCity());
                    user.setCountry(loginParamVo.getUserInfo().getCountry());
                    user.setGender(loginParamVo.getUserInfo().getGender());
                    user.setLanguage(loginParamVo.getUserInfo().getLanguage());
                    user.setNickName(loginParamVo.getUserInfo().getNickName());
                    user.setOpenId(weChatSession.getString("openid"));
                    user.setSessionKey(weChatSession.getString("session_key"));
                    userInfoMapper.insert(user);
                    resMap.put("userInfo",user);
                }
                String sessionId = openId + UUID.randomUUID().toString() + sessionKey + new Date().getTime();
                resMap.put("sessionId",sessionId);
                return JSONObject.toJSONString(resMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author jack
     * @Description 通过code获取openId和sessionKey
     * @Date  2021/2/24
     * @Param code
     * @return
     **/
    public static JSONObject getWeChatSession(String code,String url , String appId , String appSecret){
        logger.info("code"+code+" &appId"+appId+" &appSecret"+appSecret);
        Map<String,String> requestUrlParam = new HashMap<String,String>();
        //开发者设置中的appId
        requestUrlParam.put("appid",appId);
        //开发者设置中的appSecret
        requestUrlParam.put("secret",appSecret);
        //小程序调用wx.login返回的code
        requestUrlParam.put("js_code", code);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");
        //String jsonString = HttpClientUtils.doGetForWeChat(url, requestUrlParam,appId , appSecret , code,"authorization_code");
        String jsonString = HttpClientUtils.doGet(url,requestUrlParam);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        return jsonObject;
    }
}
