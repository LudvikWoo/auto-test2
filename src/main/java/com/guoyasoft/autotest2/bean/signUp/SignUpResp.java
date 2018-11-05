package com.guoyasoft.autotest2.bean.signUp;

public class SignUpResp {
  private RespBase respBase=new RespBase();
  private String userName;
  private int accoutId;
  private int cstId;
  private int userId;

  public RespBase getRespBase() {
    return respBase;
  }

  public void setRespBase(RespBase respBase) {
    this.respBase = respBase;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getAccoutId() {
    return accoutId;
  }

  public void setAccoutId(int accoutId) {
    this.accoutId = accoutId;
  }

  public int getCstId() {
    return cstId;
  }

  public void setCstId(int cstId) {
    this.cstId = cstId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "SignUpResp{" +
        "respBase=" + respBase +
        ", userName='" + userName + '\'' +
        ", accoutId=" + accoutId +
        ", cstId=" + cstId +
        ", userId=" + userId +
        '}';
  }
}
