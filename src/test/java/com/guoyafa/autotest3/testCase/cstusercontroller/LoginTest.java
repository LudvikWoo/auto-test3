package com.guoyafa.autotest3.testCase.cstusercontroller;

import com.alibaba.fastjson.JSON;
import com.guoyafa.autotest3.bean.user.login.LoginReq;
import com.guoyafa.autotest3.bean.user.login.LoginResp;
import com.guoyafa.autotest3.tools.HttpTools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

  @Test
  public void login(){
    LoginReq loginReq=new LoginReq();
    loginReq.setUserName("wuling2021");
    loginReq.setPwd("wl123456");

    String reqJson= JSON.toJSONString(loginReq,true);
    System.out.println("-----------登录：请求报文------");
    System.out.println(reqJson);
    String url="http://qa.guoyasoft.com:8080/user/login";
    String respJson= HttpTools.doPostByJson(url, reqJson, "UTF-8");
    System.out.println("------------登录：响应报文------------");
    System.out.println(reqJson);

    LoginResp loginResp=JSON.parseObject(respJson,LoginResp.class);
    Assert.assertEquals(loginResp.getRespCode(), "0000");
  }
}
