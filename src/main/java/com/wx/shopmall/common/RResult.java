/*
 *
 *      Copyright (c) 2019-2020, JieDeYun.Cn All rights reserved.
 *
 *  	Author: eric king
 *
 */
package com.wx.shopmall.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author eric king
 * @createdate 2019/12/16-15:34
 * @discription
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "返回数据封装类")
public class RResult<T> implements Serializable {
    private static final long serialVersionUID = -1161500982408876289L;

    @Setter
    @Getter
    @ApiModelProperty(value = "返回响应码")
    private int code;

    @Setter
    @Getter
    @ApiModelProperty(value = "消息内容")
    private String msg;

    @Setter
    @Getter
    @ApiModelProperty(value = "返回数据封装")
    private T obj;

    @Setter
    @Getter
    @ApiModelProperty(value = "请求所耗费时长(仅服务端)")
    private Long endTime;

    private static <T> RResult<T> restResult(T obj, int code, String msg) {
        RResult<T> apiResult = new RResult<>();
        apiResult.setCode(code);
        apiResult.setObj(obj);
        apiResult.setEndTime(System.currentTimeMillis());
        apiResult.setMsg(msg);
        return apiResult;
    }

    /**
     * 数据处理成功
     **/
    public static <T> RResult<T> success() {
        return restResult(null, Constants.SUCCESS, "操作成功!");
    }

    public static <T> RResult<T> success(T data) {
        return restResult(data, Constants.SUCCESS, "操作成功!");
    }

    public static <T> RResult<T> success(T data, String msg) {
        return restResult(data, Constants.SUCCESS, msg);
    }

    /**
     * 通用处理失败
     **/
    public static <T> RResult<T> failed() {
        return restResult(null, Constants.FAIL, "操作失败!");
    }

    public static <T> RResult<T> failed(String msg) {
        return restResult(null, Constants.FAIL, msg);
    }

    public static <T> RResult<T> failed(T data) {
        return restResult(data, Constants.FAIL, "操作失败!");
    }

    public static <T> RResult<T> failed(T data, String msg) {
        return restResult(data, Constants.FAIL, msg);
    }

    public static <T> RResult<T> custom(int code, String msg, T data) {
        return restResult(data, code, msg);
    }

    /**
     * 用户登录处理
     **/

    /**
     * 成功登录
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RResult<T> loginSuccess(T data) {
        return restResult(data, Constants.LOGIN_SUCCESS, "登录成功!");
    }

    /**
     * 重复登录
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RResult<T> loginRepeat(String msg) {
        return restResult(null, Constants.LOGIN_REPEAT, msg);
    }

    /**
     * 失败登录(用户名或密码不正确)
     *
     * @param <T>
     * @return
     */
    public static <T> RResult<T> loginFail() {
        return restResult(null, Constants.LOGIN_FAIL, "用户名或密码不正确!");
    }

    /**
     * 超时登录
     *
     * @param <T>
     * @return
     */
    public static <T> RResult<T> loginTimeOut() {
        return restResult(null, Constants.LOGIN_TIMEOUT, "登录超时,请重新登录!");
    }

    /**
     * 账户冻结
     *
     * @param <T>
     * @return
     */
    public static <T> RResult<T> loginFreez() {
        return restResult(null, Constants.LOGIN_FREEZ, "账户已冻结,请联系系统管理员!");
    }

    /**
     * 无权操作或无权查看
     *
     * @param <T>
     * @return
     */
    public static <T> RResult<T> opt_nopower() {
        return restResult(null, Constants.OPT_NOPOWER, "权限不足,如有疑问请联系系统管理员!");
    }

    /**
     * 操作失败
     *
     * @param <T>
     * @return
     */
    public static <T> RResult<T> opt_fail(String msg) {
        return restResult(null, Constants.OPT_FAIL, msg);
    }

    public static <T> RResult<T> opt_fail() {
        return restResult(null, Constants.OPT_FAIL, "操作失败,请检查后重新提交!");
    }

    public static <T> RResult<T> opt_param(T data) {
        return restResult(data, Constants.OPT_PARAMERROR, "参数有误!");
    }

    /**
     * 数据处理异常
     **/
    public static <T> RResult<T> exception(String msg) {
        return restResult(null, Constants.FAIL, msg);
    }
}