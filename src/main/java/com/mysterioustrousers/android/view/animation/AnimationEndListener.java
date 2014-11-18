package com.mysterioustrousers.android.view.animation;



import android.view.animation.Animation;



public abstract class AnimationEndListener implements Animation.AnimationListener {

  @Override
  public abstract void onAnimationEnd(Animation anim);


  @Override
  public void onAnimationStart(Animation anim) {
    // Intentionally left blank
  }


  @Override
  public void onAnimationRepeat(Animation anim) {
    // Intentionally left blank
  }
}