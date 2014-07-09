package com.mysterioustrousers.lang;



public class StringUtils {

  public static final String EMPTY = "";
  public static final String SPACE = " ";



  public static String defaultIfNullOrEmpty(String str, CharSequence defaultCharSeq) {
    return StringUtils.defaultIfNullOrEmpty(str, ((defaultCharSeq == null) ? null : defaultCharSeq.toString()));
  }


  public static String defaultIfNullOrEmpty(CharSequence charSeq, CharSequence defaultCharSeq) {
    if (charSeq == null) {
      return ((defaultCharSeq == null) ? null : defaultCharSeq.toString());
    }
    return StringUtils.defaultIfNullOrEmpty(charSeq.toString(), defaultCharSeq.toString());
  }


  public static String defaultIfNullOrEmpty(CharSequence charSeq, String defaultStr) {
    if (charSeq == null) {
      return defaultStr;
    }
    return StringUtils.defaultIfNullOrEmpty(charSeq.toString(), defaultStr);
  }


  public static String defaultIfNullOrEmpty(String str, String defaultStr) {
    return (StringUtils.isNullOrEmpty(str) ? defaultStr : str);
  }


  public static String defaultIfNullOrWhiteSpace(String str, CharSequence defaultCharSeq) {
    return StringUtils.defaultIfNullOrWhiteSpace(str, ((defaultCharSeq == null) ? null : defaultCharSeq.toString()));
  }


  public static String defaultIfNullOrWhiteSpace(CharSequence charSeq, CharSequence defaultCharSeq) {
    if (charSeq == null) {
      return ((defaultCharSeq == null) ? null : defaultCharSeq.toString());
    }
    return StringUtils.defaultIfNullOrWhiteSpace(charSeq.toString(), defaultCharSeq.toString());
  }


  public static String defaultIfNullOrWhiteSpace(CharSequence charSeq, String defaultStr) {
    if (charSeq == null) {
      return defaultStr;
    }
    return StringUtils.defaultIfNullOrWhiteSpace(charSeq.toString(), defaultStr);
  }


  public static String defaultIfNullOrWhiteSpace(String str, String defaultStr) {
    return (StringUtils.isNullOrWhiteSpace(str) ? defaultStr : str);
  }


  public static boolean isNullOrEmpty(CharSequence charSeq) {
    if (charSeq == null) {
      return true;
    }
    return StringUtils.isNullOrEmpty(charSeq.toString());
  }


  public static boolean isNullOrEmpty(String str) {
    return (str == null || org.apache.commons.lang3.StringUtils.isEmpty(str));
  }


  public static boolean isNullOrWhiteSpace(CharSequence charSeq) {
    if (charSeq == null) {
      return true;
    }
    return StringUtils.isNullOrWhiteSpace(charSeq.toString());
  }


  public static boolean isNullOrWhiteSpace(String str) {
    return (StringUtils.isNullOrEmpty(str) || org.apache.commons.lang3.StringUtils.isWhitespace(str));
  }


  public static String trimIfNotNull(CharSequence charSeq) {
    return StringUtils.trimIfNotNull(charSeq.toString());
  }


  public static String trimIfNotNull(String str) {
    return (str == null) ? null : str.trim();
  }
}