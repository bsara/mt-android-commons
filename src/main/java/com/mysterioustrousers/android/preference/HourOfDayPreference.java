package com.mysterioustrousers.android.preference;



import android.content.Context;
import android.preference.DialogPreference;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;

import com.mysterioustrousers.android.R;



public class HourOfDayPreference extends DialogPreference {

  private String[] _hourStrings;
  private String[] _ampmStrings;

  private NumberPicker _hourView;
  private NumberPicker _ampmView;

  private int _value;



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
    _hourView.setMaxValue(isUsing24HourFormat ? 23 : 11);
    _hourView.setDisplayedValues(_hourStrings);

    _ampmView = (NumberPicker)view.findViewById(R.id.customPref_hourOfDay_ampm);
    if (isUsing24HourFormat) {
      _ampmView.setVisibility(View.GONE);
    } else {
      _ampmView.setVisibility(View.VISIBLE);
      _ampmView.setMinValue(0);
      _ampmView.setMaxValue(1);
      _ampmView.setDisplayedValues(_ampmStrings);

      if (_value > 12) {
        _hourView.setValue(_value - 12);
        _ampmView.setValue(1);
        return;
      }
      _ampmView.setValue(0);
    }
    _hourView.setValue(_value);
  }


  @Override
  protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
    if (restorePersistedValue) {
      _value = this.getPersistedInt(18);
      return;
    }
    _value = 18;
    this.persistInt(_value);
  }


  @Override
  protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);

    if (positiveResult) {
      int hour = _hourView.getValue();

      if (!DateFormat.is24HourFormat(this.getContext()) && _ampmView.getValue() == 1) {
        hour += 12;
      }

      this.persistInt(hour);
    }
  }


  // endregion



  // region Getters/Setters


  @Override
  public CharSequence getSummary() {
    if (DateFormat.is24HourFormat(this.getContext())) {
      return _hourStrings[ _value ];
    }
    if (_value > 12) {
      return String.format("%s %s", _hourStrings[ _value - 12 ], _ampmStrings[ 1 ]);
    }
    return String.format("%s %s", _hourStrings[ _value ], _ampmStrings[ 0 ]);
  }


  // endregion
}