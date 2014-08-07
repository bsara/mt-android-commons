package com.mysterioustrousers.android.widget;



import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListView;



public class ExtendedListView extends ListView {

  private OnItemDoubleClickListener _onItemDoubleClickListener;

  private GestureDetector _gestureDetector;



  // region Constructors


  public ExtendedListView(Context context) {
    super(context);
    this.init();
  }


  public ExtendedListView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.init();
  }


  public ExtendedListView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.init();
  }


  private void init() {
    _gestureDetector = new GestureDetector(this.getContext(), new GestureDetector.SimpleOnGestureListener() {
      @Override
      public boolean onDoubleTap(MotionEvent e) {
        if (_onItemDoubleClickListener != null) {
          int position = ExtendedListView.this.pointToPosition(Math.round(e.getX()), Math.round(e.getY()));
          return _onItemDoubleClickListener.onItemDoubleClick(ExtendedListView.this, ExtendedListView.this.getChildAt(position), position, ExtendedListView.this.getAdapter().getItemId(position));
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



  // region Getters/Setters


  public final OnItemDoubleClickListener getOnItemDoubleClickListener() {
    return _onItemDoubleClickListener;
  }


  public void setOnItemDoubleClickListener(OnItemDoubleClickListener listener) {
    _onItemDoubleClickListener = listener;
  }


  // endregion



  public interface OnItemDoubleClickListener extends ExtendedAdapterView.OnItemDoubleClickListener<ExtendedListView> {}
}