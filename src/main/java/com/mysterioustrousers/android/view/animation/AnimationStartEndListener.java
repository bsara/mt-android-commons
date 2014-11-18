package com.mysterioustrousers.android.view.animation;



import android.view.animation.Animation;



public abstract class AnimationStartEndListener implements Animation.AnimationListener {

  @Override
  public abstract void onAnimationStart(Animation anim);


  @Override
  public abstract void onAnimationEnd(Animation anim);


  @Override
  public void onAnimationRepeat(Animation anim) {
    // Intentionally left blank
  }
}