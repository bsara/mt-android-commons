package com.mysterioustrousers.net;



import java.net.InetAddress;

import org.apache.commons.lang3.StringUtils;



public class InternetUtils {

  private InternetUtils() {}


  public static boolean isInternetAvailable() {
    return InternetUtils.isURLAvailable("google.com");
  }


  public static boolean isURLAvailable(String url) {
    try {
      return !InetAddress.getByName(url).equals(StringUtils.EMPTY);
    } catch (Exception e) {
      return false;
    }
  }
}