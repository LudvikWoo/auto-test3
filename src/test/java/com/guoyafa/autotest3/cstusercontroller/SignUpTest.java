package com.guoyafa.autotest3.cstusercontroller;

import com.alibaba.fastjson.JSON;
import com.guoyafa.autotest3.signUp.SignUpReq;
import com.guoyafa.autotest3.signUp.SignUpResp;
import com.guoyafa.autotest3.tools.HttpTools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

  @Test
  public void signUp(){
    SignUpReq signUpReq=new SignUpReq();
    signUpReq.setPhone("18616765843");
    signUpReq.setPwd("wl123456");
    signUpReq.setRePwd("wl123456");
    signUpReq.setUserName("wuling2022");

    String reqJson= JSON.toJSONString(signUpReq,true);
    System.out.println("---------------------注册接口：请求报文-------------------");
    System.out.println(reqJson);

    String url="http://qa.guoyasoft.com:8080/user/signup";
    String respJson=HttpTools.doPostByJson(url, reqJson, "UTF-8");
    System.out.println("---------------注册接口：响应报文-----------");
    System.out.println(respJson);

    SignUpResp signUpResp=JSON.parseObject(respJson,SignUpResp.class);
    Assert.assertEquals(signUpResp.getRespBase().getRespCode(), "0000");
  }

}
