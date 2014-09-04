package com.mysterioustrousers.net;



import java.net.MalformedURLException;
import java.net.URL;

import com.timgroup.jgravatar.Gravatar;
import com.timgroup.jgravatar.GravatarDefaultImage;

import org.apache.commons.lang3.StringUtils;



/**
 * WARNING! This class is not thread safe. You must implement such measures yourself.
 */
public final class GravatarFactory {

  // region Singleton Implementation


  private static GravatarFactory s_instance;


  /**
   * WARNING! This class is not thread safe. You must implement such measures yourself.
   */
  public static GravatarFactory getInstance() {
    if (s_instance == null) {
      s_instance = new GravatarFactory();
    }
    return s_instance;
  }


  // endregion



  private Gravatar _gravatar;
  private GravatarDefaultImage _currentDefaultImage;



  private GravatarFactory() {
    super();

    _gravatar = null;
    _currentDefaultImage = Gravatar.DEFAULT_DEFAULT_IMAGE;
  }


  private void setGravatarIfNull() {
    if (_gravatar == null) {
      _gravatar = new Gravatar();
    }
  }


  public URL getGravatarURL(String email) throws MalformedURLException {
    return this.getGravatarURL(email, null);
  }


  public URL getGravatarURL(String email, com.mysterioustrousers.net.GravatarDefaultImage defaultImage) throws MalformedURLException {
    if (StringUtils.isBlank(email)) {
      return null;
    }


    this.setGravatarIfNull();


    _gravatar.setDefaultImage(this.convertDefaultImageToJGravatarObject(defaultImage));

    URL gravatarURL = new URL(_gravatar.getUrl(email));

    _gravatar.setDefaultImage(_currentDefaultImage);


    return gravatarURL;
  }


  public void setDefaultImage(com.mysterioustrousers.net.GravatarDefaultImage defaultImage) {
    this.setGravatarIfNull();

    GravatarDefaultImage convertedDefaultImage = this.convertDefaultImageToJGravatarObject(defaultImage);

    _gravatar.setDefaultImage(convertedDefaultImage);
    _currentDefaultImage = convertedDefaultImage;
  }


  private GravatarDefaultImage convertDefaultImageToJGravatarObject(com.mysterioustrousers.net.GravatarDefaultImage mtDefaultImage) {
    switch (mtDefaultImage) {
      case GRAVATAR_ICON:
        return GravatarDefaultImage.GRAVATAR_ICON;
      case IDENTICON:
        return GravatarDefaultImage.IDENTICON;
      case MONSTERID:
        return GravatarDefaultImage.MONSTERID;
      case WAVATAR:
        return GravatarDefaultImage.WAVATAR;
      case HTTP_404:
        return GravatarDefaultImage.HTTP_404;
    }
    return null;
  }
}