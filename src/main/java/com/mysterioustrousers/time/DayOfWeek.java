package com.mysterioustrousers.time;



import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.IntegerValidator;



/**
 * This enum is not needed in Java 1.8+. Instead use java.time.DayOfWeek.
 */
public enum DayOfWeek {
  SUNDAY(1),
  MONDAY(2),
  TUESDAY(3),
  WEDNESDAY(4),
  THURSDAY(5),
  FRIDAY(6),
  SATURDAY(7);


  private final int _value;



  private DayOfWeek(int value) {
    _value = value;
  }



  public static DayOfWeek parseString(String str) {
    if (StringUtils.isBlank(str)) {
      return null;
    }
    return EnumUtils.getEnum(DayOfWeek.class, str.trim().toUpperCase());
  }


  public static DayOfWeek parseInt(int intValue) {
    if (!IntegerValidator.getInstance().isInRange(intValue, DayOfWeek.SUNDAY.toInt(), DayOfWeek.SATURDAY.toInt())) {
      return null;
    }

    if (intValue == DayOfWeek.SUNDAY.toInt()) {
      return DayOfWeek.SUNDAY;
    }
    if (intValue == DayOfWeek.MONDAY.toInt()) {
      return DayOfWeek.MONDAY;
    }
    if (intValue == DayOfWeek.TUESDAY.toInt()) {
      return DayOfWeek.TUESDAY;
    }
    if (intValue == DayOfWeek.WEDNESDAY.toInt()) {
      return DayOfWeek.WEDNESDAY;
    }
    if (intValue == DayOfWeek.THURSDAY.toInt()) {
      return DayOfWeek.THURSDAY;
    }
    if (intValue == DayOfWeek.FRIDAY.toInt()) {
      return DayOfWeek.FRIDAY;
    }
    if (intValue == DayOfWeek.SATURDAY.toInt()) {
      return DayOfWeek.SATURDAY;
    }

    return null;
  }


  public int toInt() {
    return _value;
  }


  @Override
  public String toString() {
    switch (this) {
      case SUNDAY:
        return "Sunday";
      case MONDAY:
        return "Monday";
      case TUESDAY:
        return "Tuesday";
      case WEDNESDAY:
        return "Wednesday";
      case THURSDAY:
        return "Thursday";
      case FRIDAY:
        return "Friday";
      case SATURDAY:
        return "Saturday";
    }
    return null;
  }
}