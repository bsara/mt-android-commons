package com.mysterioustrousers.android.app;



import android.app.Activity;
import android.app.AlertDialog;



public class ActivityUtils {
  private ActivityUtils() {}


  public static void showDialog(final Activity activity, AlertDialog dialog) {
    if (!activity.isFinishing()) {
      dialog.show();
    }
  }
}