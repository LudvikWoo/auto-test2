package com.guoyasoft.autotest2.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptTools {

  public static String enMD5(String s){
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    // 计算md5函数
    md.update(s.getBytes());
    return new BigInteger(1, md.digest()).toString(16);
  }
}
