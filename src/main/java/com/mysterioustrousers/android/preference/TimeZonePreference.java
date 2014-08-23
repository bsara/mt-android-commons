package com.mysterioustrousers.android.preference;



import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;



public class TimeZonePreference extends ListPreference {

  private String _timeZoneId;



  //region Constructors


  public TimeZonePreference(Context context) {
    super(context);
    this.init();
  }


  public TimeZonePreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.init();
  }


  private void init() {
    final Locale currentLocale = this.getContext().getResources().getConfiguration().locale;

    final String[] timeZoneIds = TimeZone.getAvailableIDs();
    String[] timeZoneDisplayNames = new String[ timeZoneIds.length ];

    for (int i = 0; i < timeZoneIds.length; i++) {
      timeZoneDisplayNames[ i ] = TimeZone.getTimeZone(timeZoneIds[ i ]).getDisplayName(currentLocale);
    }

    this.setEntries(timeZoneDisplayNames);
    this.setEntryValues(timeZoneIds);
  }


  // endregion



  @Override
  protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
    if (defaultValue == null) {
      defaultValue = Calendar.getInstance().getTimeZone().getID();
    }
    super.onSetInitialValue(restoreValue, defaultValue);
  }
}