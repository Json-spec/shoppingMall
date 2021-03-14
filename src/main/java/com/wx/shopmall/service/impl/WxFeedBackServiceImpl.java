package com.wx.shopmall.service.impl;

import com.wx.shopmall.entity.WxFeedback;
import com.wx.shopmall.mapper.WxFeedBackMapper;
import com.wx.shopmall.service.WxFeedBackService;
import com.wx.shopmall.vo.WxAddFeedSubmitParamVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WxFeedBackServiceImpl implements WxFeedBackService {


    private static final Logger logger = LoggerFactory.getLogger(WxFeedBackServiceImpl.class);


    @Autowired
    private WxFeedBackMapper wxFeedBackMapper;


    @Override
    public int addFeedSubmit(WxAddFeedSubmitParamVo wxAddFeedSubmitParamVo) {

        logger.info(wxAddFeedSubmitParamVo + "");
        StringBuffer sb = new StringBuffer();
        WxFeedback wxFeedBack = new WxFeedback();
        wxFeedBack.setContent(wxAddFeedSubmitParamVo.getContent());
        wxFeedBack.setCreateTime(new Date());
        wxFeedBack.setMobile(wxAddFeedSubmitParamVo.getMobile());
        wxFeedBack.setState(1);
        wxFeedBack.setFeedType(wxAddFeedSubmitParamVo.getFeedType());
        wxFeedBack.setUpdateTime(new Date());
        wxFeedBack.setUserId(wxAddFeedSubmitParamVo.getUserId());
        if (wxAddFeedSubmitParamVo.getHasPicture()) {
            String[] picUrls = wxAddFeedSubmitParamVo.getPicUrls();
            for (String picUrl : picUrls) {
                sb.append(picUrl);
            }
            wxFeedBack.setFeedImg(sb.toString());
        }
        return wxFeedBackMapper.insert(wxFeedBack);
    }
}
