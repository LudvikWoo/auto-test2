package com.guoyasoft.autotest2.testCase;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.autotest2.bean.LoginReq;
import com.guoyasoft.autotest2.bean.LoginResp;
import com.guoyasoft.autotest2.tools.HttpClientUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cstusercontrollerTest {

  @Test
  public void login(){
    System.out.println("测试成功");
    LoginReq loginReq=new LoginReq();
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

}
