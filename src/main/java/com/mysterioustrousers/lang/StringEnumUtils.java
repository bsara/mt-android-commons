package com.mysterioustrousers.lang;



import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;



public final class StringEnumUtils {

  private StringEnumUtils() {}



  public static <T extends Enum<T>> T parseString(Class<T> clazz, String str) {
    if (clazz == null || StringUtils.isBlank(str)) {
      return null;
    }
    return EnumUtils.getEnum(clazz, str.trim().toUpperCase());
  }


  public static <T extends Enum<T>> String toString(T enumObj) {
    if (enumObj == null) {
      return null;
    }
    return enumObj.toString().toLowerCase();
  }
}