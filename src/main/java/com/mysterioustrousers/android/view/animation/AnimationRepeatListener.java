package com.mysterioustrousers.android.view.animation;



import android.view.animation.Animation;



public abstract class AnimationRepeatListener implements Animation.AnimationListener {

  @Override
  public abstract void onAnimationRepeat(Animation anim);


  @Override
  public void onAnimationStart(Animation anim) {
    // Intentionally left blank
  }


  @Override
  public void onAnimationEnd(Animation anim) {
    // Intentionally left blank
  }
}