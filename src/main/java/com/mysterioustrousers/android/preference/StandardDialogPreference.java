package com.mysterioustrousers.android.preference;



import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;

import com.mysterioustrousers.android.R;



public abstract class StandardDialogPreference extends DialogPreference {


  public StandardDialogPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.init();
  }


  public StandardDialogPreference(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.init();
  }


  private void init() {
    this.setNegativeButtonText(getContext().getString(R.string.customPref_dialog_button_negative));
    this.setPositiveButtonText(getContext().getString(R.string.customPref_dialog_button_positive));
  }
}
