package com.mysterioustrousers.android.preference;



import java.util.Calendar;
import java.util.TimeZone;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.ListPreference;
import android.util.AttributeSet;

import com.mysterioustrousers.android.R;

import org.apache.commons.lang3.StringUtils;



public class TimeZonePreference extends ListPreference {



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
    this.setEntries(TimeZone.getAvailableIDs());
    this.setEntryValues(this.getEntries());
  }


  // endregion



  @Override
  protected Object onGetDefaultValue(TypedArray a, int index) {
    return StringUtils.defaultIfBlank(a.getString(index), Calendar.getInstance().getTimeZone().getID());
  }


  @Override
  public CharSequence getSummary() {
    return StringUtils.defaultIfBlank(this.getValue(), this.getContext().getResources().getString(R.string.customPref_timeZone_item_none));
  }
}