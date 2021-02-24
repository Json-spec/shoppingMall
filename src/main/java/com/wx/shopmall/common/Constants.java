package com.wx.shopmall.common;

/**
 * @Auther: jack
 * @Date: 2021/2/24 13:21
 * @Description:
 */
public class Constants {


    /**
     * response.data.code
     * 200     成功处理请求
     * ==============================
     * 70000   登录成功登录成功进行跳转
     * 70001   重复登录同一个账号只能一个客户端登录
     * 70002   登录超时需要再次登录
     * 70003   用户名或密码不对需要重新提交
     * 70004   账户异常,用户已冻结请联系系统管理员进行解冻操作
     * ==============================
     * 70020   无权限访问越权访问，
     * 70021   操作失败!
     * ==============================
     * 999   系统异常,请联系管理员请求处理异常，可二次尝试
     */
    public static final int SUCCESS = 200;
    public static final int LOGIN_SUCCESS = 70000;

    public static final int LOGIN_REPEAT = 70001;
    public static final int LOGIN_TIMEOUT = 70002;
    public static final int LOGIN_FAIL = 70003;
    public static final int LOGIN_FREEZ = 70004;
    public static final int LOGIN_FORBIDDEN = 70005;
    public static final int OPT_NOPOWER = 70020;
    public static final int VF_ERROR = 700071;
    public static final int OPT_FAIL = 700021;
    public static final int OPT_PARAMERROR = 700022;
    public static final int FAIL = 999;
    public static final String SUCCESS_MESSAGE = "调取成功";
    public static final String FAIL_MESSAGE = "调取失败";


}
