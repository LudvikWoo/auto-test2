package com.guoyasoft.autotest2.bean.signUp;

public class SignUpReq {
  private String phone;
  private String pwd;
  private String rePwd;
  private String userName;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getRePwd() {
    return rePwd;
  }

  public void setRePwd(String rePwd) {
    this.rePwd = rePwd;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "SignUpReq{" +
        "phone='" + phone + '\'' +
        ", pwd='" + pwd + '\'' +
        ", rePwd='" + rePwd + '\'' +
        ", userName='" + userName + '\'' +
        '}';
  }
}
