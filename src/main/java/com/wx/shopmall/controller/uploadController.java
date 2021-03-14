package com.wx.shopmall.controller;


import io.swagger.annotations.ApiOperation;
import org.apache.http.protocol.HttpRequestExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping(value = "/storage")
public class uploadController {

private final Logger logger = LoggerFactory.getLogger(uploadController.class);

@Value("${uploadImg.storage}")
private String  uploadStoragePath;


    @RequestMapping(value = "/upload")
    @ApiOperation(value = "文件上传")
    public String uploadImg(HttpServletRequest request , HttpServletResponse response ,@RequestParam("file") MultipartFile [] file){
        StringBuffer sb = new StringBuffer();
              if (file.length<0 && file==null){
                  return null;
              }else{
                  for (MultipartFile multipartFile : file) {
                      File files = new File(uploadStoragePath);
                      if (!files.exists()){
                          files.mkdirs();
                      }
                      //获取文件名字
                      String originalFilename = multipartFile.getOriginalFilename();
                      //获取文件后缀
                      String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
                      //生成新的文件名字
                      long time = new Date().getTime();
                      String newPath = time + substring;
                      File newfile  = new File(uploadStoragePath + newPath);
                      //将上传文件保存到路径
                      try {
                          multipartFile.transferTo(newfile);
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                      sb.append(newPath+",");
                  }
              }
              return sb.toString();
    }
}
