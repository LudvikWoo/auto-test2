package com.guoyasoft.autotest2.testCase;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.autotest2.bean.login.LoginReq;
import com.guoyasoft.autotest2.bean.login.LoginResp;
import com.guoyasoft.autotest2.bean.signUp.SignUpReq;
import com.guoyasoft.autotest2.bean.signUp.SignUpResp;
import com.guoyasoft.autotest2.tools.HttpTools;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CstusercontrollerTest {
  public static Properties prop ;

/*  @BeforeSuite
  public void init(){
    prop = new Properties();
    try {
      InputStream in = CstusercontrollerTest.class.getClassLoader().getResourceAsStream(
          "env.properties");
      prop.load(in);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }*/

  @Test
  public void login(){
    System.out.println("测试成功");
    LoginReq loginReq=new LoginReq();
    loginReq.setUserName("wuling");
    loginReq.setPwd("123456");

    String reqJson= JSON.toJSONString(loginReq,true);
    System.out.println("---------------------请求报文-------------------------");
    System.out.println(reqJson);

    String protocol=prop.getProperty("protocol");
    String ip=prop.getProperty("ip");
    String port=prop.getProperty("port");

    String url=protocol+"://"+ip+":"+port+"/user/login";
    System.out.println("-----------url-------------");
    System.out.println(url);
    String respJson= HttpTools.doPostByJson(url, reqJson, "UTF-8");
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
    /*String pwd= CommonUtils.randomString("0123456789", 6);
    System.out.println("随机密码："+pwd);
    signUpReq.setPwd(pwd);
    signUpReq.setRePwd(pwd);
    String userName=CommonUtils.randomString("asdfqwertyuiokhzxcvb", 4)+CommonUtils.randomString("0123456789", 4);
    *//*signUpReq.setUserName(userName);*/

    String reqJson=JSON.toJSONString(signUpReq);
    System.out.println("------------用户注册：请求报文----------");
    System.out.println(reqJson);


    String result= HttpTools
        .doPostByJson("http://qa.guoyasoft.com:8080/user/signup", reqJson, "UTF-8");
    System.out.println("----------用户注册：响应报文------------");
    System.out.println(result);

    SignUpResp signUpResp=JSON.parseObject(result,SignUpResp.class);
    Assert.assertEquals(signUpResp.getRespBase().getRespCode(), "0000");
  }
}
