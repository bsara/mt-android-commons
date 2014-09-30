package com.mysterioustrousers.android;



import android.content.Context;
import android.content.res.Configuration;



public final class ConfigUtils {

  private ConfigUtils() {}


  public static boolean isTablet(Context context) {
    return (ConfigUtils.getScreenSize(context).ordinal() >= ScreenSize.LARGE.ordinal());
  }


  public static ScreenSize getScreenSize(Context context) {
    switch (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) {
      case Configuration.SCREENLAYOUT_SIZE_SMALL:
        return ScreenSize.SMALL;
      case Configuration.SCREENLAYOUT_SIZE_NORMAL:
        return ScreenSize.NORMAL;
      case Configuration.SCREENLAYOUT_SIZE_LARGE:
        return ScreenSize.LARGE;
      case Configuration.SCREENLAYOUT_SIZE_XLARGE:
        return ScreenSize.XLARGE;
      default:
        return ScreenSize.UNKNOWN;
    }
  }
}