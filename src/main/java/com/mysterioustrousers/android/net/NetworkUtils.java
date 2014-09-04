package com.mysterioustrousers.android.net;



import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



public class NetworkUtils {

  public static boolean isNetworkConnected(Context context) {
    NetworkInfo activeNetwork = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnected();
  }
}