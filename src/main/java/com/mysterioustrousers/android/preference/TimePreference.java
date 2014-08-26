package com.mysterioustrousers.android.preference;



import java.util.Calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

import org.apache.commons.lang3.time.DateFormatUtils;



public class TimePreference extends StandardDialogPreference {

  private TimePicker _timeView;
  private Calendar   _calendar;



  // region Constructors


  public TimePreference(Context ctxt, AttributeSet attrs) {
    super(ctxt, attrs);
    this.init();
  }


  public TimePreference(Context ctxt, AttributeSet attrs, int defStyle) {
    super(ctxt, attrs, defStyle);
    this.init();
  }


  private void init() {
    _calendar = Calendar.getInstance();
  }


  // endregion



  // region Event Handlers


  @Override
  protected View onCreateDialogView() {
    _timeView = new TimePicker(getContext());
    _timeView.setIs24HourView(DateFormat.is24HourFormat(getContext()));

    return _timeView;
  }



  @Override
  protected void onBindDialogView(View v) {
    super.onBindDialogView(v);
    _timeView.setCurrentHour(_calendar.get(Calendar.HOUR_OF_DAY));
    //picker.setCurrentMinute(calendar.get(Calendar.MINUTE));
  }


  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);

    if (positiveResult) {
      _calendar.set(Calendar.HOUR_OF_DAY, _timeView.getCurrentHour());
      _calendar.set(Calendar.MINUTE, _timeView.getCurrentMinute());

      this.setSummary(getSummary());
      if (callChangeListener(_calendar.getTimeInMillis())) {
        this.persistString(Long.toString(_calendar.getTimeInMillis()));
        this.notifyChanged();
      }
    }
  }


  // endregion



  // region Getters/Setters


  @Override
  protected Object onGetDefaultValue(TypedArray a, int index) {
    return a.getString(index);
  }


  @Override
  public CharSequence getSummary() {
    return (_calendar == null) ? null : DateFormatUtils.ISO_TIME_FORMAT.format(_calendar);
  }


  // endregion
}
