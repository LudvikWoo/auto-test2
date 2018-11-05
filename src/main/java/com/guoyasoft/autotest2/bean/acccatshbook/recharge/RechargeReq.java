package com.guoyasoft.autotest2.bean.acccatshbook.recharge;

public class RechargeReq {
  private String accountName;
  private int changeMoney;

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public int getChangeMoney() {
    return changeMoney;
  }

  public void setChangeMoney(int changeMoney) {
    this.changeMoney = changeMoney;
  }

  @Override
  public String toString() {
    return "RechargeReq{" +
        "accountName='" + accountName + '\'' +
        ", changeMoney=" + changeMoney +
        '}';
  }
}
