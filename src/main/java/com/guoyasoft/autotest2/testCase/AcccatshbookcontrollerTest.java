package com.guoyasoft.autotest2.testCase;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.autotest2.bean.acccatshbook.recharge.RechargeReq;
import com.guoyasoft.autotest2.bean.acccatshbook.recharge.RechargeResp;
import com.guoyasoft.autotest2.tools.HttpTools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcccatshbookcontrollerTest {

  @Test
  public void recharge(){
    RechargeReq rechargeReq=new RechargeReq();
    rechargeReq.setAccountName("wuling2018");
    rechargeReq.setChangeMoney(30000);

    String reqJson= JSON.toJSONString(rechargeReq,true);
    System.out.println("-------------账户充值：请求报文-----------");
    System.out.println(reqJson);

    String url="http://qa.guoyasoft.com:8080/user/recharge";
    String result= HttpTools.doPostByJson(url, reqJson, "UTF-8");
    System.out.println("---------------账户充值：响应报文------------");
    System.out.println(result);

    RechargeResp rechargeResp=JSON.parseObject(result,RechargeResp.class);
    String respCode=rechargeResp.getRespCode();
    System.out.println("响应报文："+respCode);


    Assert.assertEquals(respCode, "0000");
  }
}
