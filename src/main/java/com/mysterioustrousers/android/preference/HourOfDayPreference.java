package com.mysterioustrousers.android.preference;



import java.util.Calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;

import com.mysterioustrousers.android.R;



public class HourOfDayPreference extends StandardDialogPreference {

  private String[] _hourStrings;
  private String[] _ampmStrings;

  private NumberPicker _hourView;
  private NumberPicker _ampmView;



  // region Constructors


  public HourOfDayPreference(Context context, AttributeSet attrs) {
    super(context, attrs, 0);
    this.init();
  }


  public HourOfDayPreference(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.init();
  }


  private void init() {
    _hourStrings = this.getContext().getResources().getStringArray(DateFormat.is24HourFormat(this.getContext()) ? R.array.customPref_hourOfDay_hours_24 : R.array.customPref_hourOfDay_hours_12);
    _ampmStrings = this.getContext().getResources().getStringArray(R.array.customPref_hourOfDay_ampm);

    _hourView = null;
    _ampmView = null;

    this.setDialogLayoutResource(R.layout.pref_hourofday);
  }


  // endregion



  // region Event Handlers


  @Override
  protected void onBindDialogView(View view) {
    super.onBindDialogView(view);

    final boolean isUsing24HourFormat = DateFormat.is24HourFormat(this.getContext());

    _hourView = (NumberPicker)view.findViewById(R.id.customPref_hourOfDay_hour);
    _hourView.setMinValue(0);
    _hourView.setMaxValue(isUsing24HourFormat ? 24 : 12);
    _hourView.setDisplayedValues(_hourStrings);

    _ampmView = (NumberPicker)view.findViewById(R.id.customPref_hourOfDay_ampm);
    if (!isUsing24HourFormat) {
      _ampmView.setVisibility(View.VISIBLE);
      _ampmView.setMinValue(0);
      _ampmView.setMaxValue(1);
      _ampmView.setDisplayedValues(_ampmStrings);
    } else {
      _ampmView.setVisibility(View.GONE);
    }
  }


  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);

    if (positiveResult) {
      Calendar calendar = Calendar.getInstance();

      int hour = _hourView.getValue();
      if (DateFormat.is24HourFormat(this.getContext()) && _ampmView.getValue() == 1) {
        hour += 12;
      }

      calendar.set(Calendar.HOUR_OF_DAY, hour);
      calendar.set(Calendar.MINUTE, 0);

      if (callChangeListener(calendar.getTimeInMillis())) {
        this.persistString(Long.toString(calendar.getTimeInMillis()));
        this.notifyChanged();
      }
    }
  }


  @Override
  protected Object onGetDefaultValue(TypedArray a, int index) {
    return (a.getString(index));
  }


  // endregion



  // region Getters/Setters


  @Override
  public CharSequence getSummary() {
    if (DateFormat.is24HourFormat(this.getContext())) {
      return _hourStrings[ _hourView.getValue() ];
    }
    if (_hourView.getValue() > 12) {
      return String.format("%s %s", _hourStrings[ _hourView.getValue() - 12 ], _ampmStrings[ 1 ]);
    }
    return String.format("%s %s", _hourStrings[ _hourView.getValue() ], _ampmStrings[ 0 ]);
  }


  // endregion
}