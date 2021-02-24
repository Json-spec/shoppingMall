package com.wx.shopmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.shopmall.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: jack
 * @Date: 2021/2/24 13:10
 * @Description:
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * @Author jack
     * @Description 根据openId查询对象信息
     * @Date  2021/2/24
     * @Param
     * @return
     **/
    UserInfo selectByUserName(@Param("openId") String openId);
}
