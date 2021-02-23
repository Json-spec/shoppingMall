package com.wx.shopmall.entity;

import lombok.Data;

import java.util.Date;
@Data
public class SysLog {

    private String logId;
    private String empNo;
    private String operationType;
    private String description;
    private String requestUri;
    private String requestType;
    private String className;
    private String methodName;
    private String params;
    private String requestIp;
    private String responseIp;
    private Date startTime;
    private Date endTime;
    private String exceptionCode;
    private String exceptionMessage;

}
