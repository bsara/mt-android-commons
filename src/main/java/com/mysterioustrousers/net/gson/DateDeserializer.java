package com.mysterioustrousers.net.gson;



import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;



public class DateDeserializer implements JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
    if (json == null) {
      return null;
    }


    String dateString = StringUtils.trim(json.getAsString());
    if (StringUtils.isBlank(dateString)) {
      return null;
    }
    if (dateString.toUpperCase().equals("NOW")) {
      return new Date();
    }
    dateString = dateString.replace("Z", "+00:00");


    final String isoDateTimeFormatFull = DateFormatUtils.ISO_DATETIME_FORMAT.getPattern() + ".SSS";

    try {
      return DateUtils.parseDate(dateString,
                                 "yyyy-MM-dd HH:mm:ss",
                                 isoDateTimeFormatFull,
                                 isoDateTimeFormatFull + "z",
                                 isoDateTimeFormatFull + "zzzz",
                                 isoDateTimeFormatFull + "Z",
                                 isoDateTimeFormatFull + "ZZZZ",
                                 isoDateTimeFormatFull + "ZZZZZ",
                                 DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_DATE_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_DATE_TIME_ZONE_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_TIME_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_TIME_TIME_ZONE_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_TIME_NO_T_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_TIME_NO_T_TIME_ZONE_FORMAT.getPattern(),
                                 DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_TIME_NO_T_FORMAT.getPattern(),
                                 DateFormatUtils.ISO_TIME_NO_T_FORMAT.getPattern());
    } catch (ParseException e) {
      throw new JsonParseException(e);
    }
  }
}