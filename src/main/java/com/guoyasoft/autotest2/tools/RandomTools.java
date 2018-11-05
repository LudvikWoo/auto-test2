package com.guoyasoft.autotest2.tools;

import java.util.Random;

public class RandomTools {

  public static String randomString(String s,int i){
    String str ="";
    int length = s.length();
    for (int j = 0; j < i; j++) {
      str=str+String.valueOf(s.charAt((int)(Math.random() * length)));
    }
    return str;
  }

  public static int randomInt(int min,int max){
    if (min>=max){new Exception("最小数大于等于最大数");}
    Random random = new Random();
    return random.nextInt(max) % (max - min + 1) + min;
  }

}
