package com.mysterioustrousers.android.widget;



import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;



public abstract class ExtendedAdapterView<T extends Adapter> extends AdapterView<T> {

  protected OnItemDoubleClickListener<ExtendedAdapterView<T>> _onItemDoubleClickListener;


  protected GestureDetector _gestureDetector;



  // region Constructors


  public ExtendedAdapterView(Context context) {
    super(context);
    this.init();
  }


  public ExtendedAdapterView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.init();
  }


  public ExtendedAdapterView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.init();
  }


  private void init() {
    _gestureDetector = new GestureDetector(this.getContext(), new GestureDetector.SimpleOnGestureListener() {
      @Override
      public boolean onDoubleTap(MotionEvent e) {
        if (_onItemDoubleClickListener != null) {
          int position = ExtendedAdapterView.this.getDoubleClickedItemPosition(e);
          return _onItemDoubleClickListener.onItemDoubleClick(ExtendedAdapterView.this, ExtendedAdapterView.this.getChildAt(position), position, ExtendedAdapterView.this.getAdapter().getItemId(position));
        }
        return false;
      }
    });
  }


  // endregion



  @Override
  public boolean onTouchEvent(MotionEvent e) {
    return (_gestureDetector.onTouchEvent(e) || super.onTouchEvent(e));
  }



  protected abstract int getDoubleClickedItemPosition(MotionEvent e);



  // region Getters/Setters


  public final OnItemDoubleClickListener<ExtendedAdapterView<T>> getOnItemDoubleClickListener() {
    return _onItemDoubleClickListener;
  }


  public void setOnItemDoubleClickListener(OnItemDoubleClickListener<ExtendedAdapterView<T>> listener) {
    _onItemDoubleClickListener = listener;
  }


  // endregion



  public interface OnItemDoubleClickListener<T extends AdapterView<? extends Adapter>> {

    boolean onItemDoubleClick(T parent, View view, int position, long id);
  }
}