package com.guoyasoft.autotest2.testCase;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.autotest2.bean.login.LoginReq;
import com.guoyasoft.autotest2.bean.login.LoginResp;
import com.guoyasoft.autotest2.bean.signUp.SignUpReq;
import com.guoyasoft.autotest2.bean.signUp.SignUpResp;
import com.guoyasoft.autotest2.tools.HttpClientUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CstusercontrollerTest {

  @Test
  public void login(){
    System.out.println("测试成功");
    LoginReq loginReq=new LoginReq();
    loginReq.setUserName("wuling");
    loginReq.setPwd("123456");

    String reqJson= JSON.toJSONString(loginReq,true);
    System.out.println("---------------------请求报文-------------------------");
    System.out.println(reqJson);

    String respJson=HttpClientUtils.doPostByJson("http://qa.guoyasoft.com:8080/user/login", reqJson, "UTF-8");
    System.out.println("-----------------响应报文-----------------");
    System.out.println(respJson);

    LoginResp loginResp=JSON.parseObject(respJson,LoginResp.class);
    System.out.println("响应编码="+loginResp.getRespCode());

    Assert.assertEquals(loginResp.getRespCode(), "0000");
  }

  @Test
  public void signUp(){
    SignUpReq signUpReq=new SignUpReq();
    signUpReq.setPhone("18616765946");
    signUpReq.setPwd("123456");
    signUpReq.setRePwd("123456");
    signUpReq.setUserName("wuling1105");

    String reqJson=JSON.toJSONString(signUpReq);
    System.out.println("------------用户注册：请求报文----------");
    System.out.println(reqJson);

    String result=HttpClientUtils.doPostByJson("http://qa.guoyasoft.com:8080/user/signup", reqJson, "UTF-8");
    System.out.println("----------用户注册：响应报文------------");
    System.out.println(result);

    SignUpResp signUpResp=JSON.parseObject(result,SignUpResp.class);
    Assert.assertEquals(signUpResp.getRespBase().getRespCode(), "0000");
  }
}
