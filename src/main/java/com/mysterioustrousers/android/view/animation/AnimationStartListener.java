package com.mysterioustrousers.android.view.animation;



import android.view.animation.Animation;



public abstract class AnimationStartListener implements Animation.AnimationListener {

  @Override
  public abstract void onAnimationStart(Animation anim);


  @Override
  public void onAnimationEnd(Animation anim) {
    // Intentionally left blank
  }


  @Override
  public void onAnimationRepeat(Animation anim) {
    // Intentionally left blank
  }
}