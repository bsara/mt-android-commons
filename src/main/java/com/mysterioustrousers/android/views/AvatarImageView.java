package com.mysterioustrousers.android.views;



import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.mysterioustrousers.android.R;



public class AvatarImageView extends View {

  private Drawable _image;



  // region Constructors


  public AvatarImageView(Context context) {
    super(context);
    this.init(null, 0);
  }


  public AvatarImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.init(attrs, 0);
  }


  public AvatarImageView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.init(attrs, defStyle);
  }


  private void init(AttributeSet attrs, int defStyle) {
    this.setImage(null);


    final TypedArray styledAttrs = getContext().obtainStyledAttributes(attrs, R.styleable.AvatarImageView, defStyle, 0);


    if (styledAttrs.hasValue(R.styleable.AvatarImageView_avatarImage)) {
      _image = styledAttrs.getDrawable(R.styleable.AvatarImageView_avatarImage);
    }
    if (_image == null) {
      _image = this.getResources().getDrawable(R.drawable.ic_anonymous);
    }
    _image.setCallback(this);



    styledAttrs.recycle();
  }


  // endregion



  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    /*

    // TODO: consider storing these as member variables to reduce
    // allocations per draw cycle.
    int paddingLeft = getPaddingLeft();
    int paddingTop = getPaddingTop();
    int paddingRight = getPaddingRight();
    int paddingBottom = getPaddingBottom();

    int contentWidth = getWidth() - paddingLeft - paddingRight;
    int contentHeight = getHeight() - paddingTop - paddingBottom;

    // Draw the text.
    canvas.drawText(mExampleString,
                    paddingLeft + (contentWidth - mTextWidth) / 2,
                    paddingTop + (contentHeight + mTextHeight) / 2,
                    _TextPaint);

    // Draw the example drawable on top of the text.
    if (mExampleDrawable != null) {
      mExampleDrawable.setBounds(paddingLeft, paddingTop,
                                 paddingLeft + contentWidth, paddingTop + contentHeight);
      mExampleDrawable.draw(canvas);
    }
    */
  }



  // region Getters & Setters


  public Drawable getImage() {
    return _image;
  }


  public void setImage(Drawable image) {
    _image = image;
  }


  public void setImage(int resourceId) {
    _image = this.getResources().getDrawable(resourceId);
  }


  // endregion
}