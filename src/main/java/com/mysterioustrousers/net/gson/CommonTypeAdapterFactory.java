package com.mysterioustrousers.net.gson;



import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mysterioustrousers.lang.StringEnumUtils;



public class CommonTypeAdapterFactory implements TypeAdapterFactory {

  @SuppressWarnings("unchecked")
  @Override
  public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
    Class rawType = type.getRawType();

    if (rawType.isEnum()) {
      return this.createEnumAdapter(rawType);
    }

    return null;
  }



  // region Enum Adapters


  private <T extends Enum<T>> TypeAdapter<T> createEnumAdapter(final Class<T> enumClass) {
    return this.getStringEnumTypeAdapter(enumClass);
  }


  private <T extends Enum<T>> TypeAdapter<T> getStringEnumTypeAdapter(final Class<T> enumClass) {
    return new TypeAdapter<T>() {
      @Override
      public void write(JsonWriter out, T value) throws IOException {
        if (value == null) {
          out.nullValue();
          return;
        }
        out.value(StringEnumUtils.toString(value));
      }


      @Override
      public T read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
          in.nextNull();
          return null;
        }
        return StringEnumUtils.parseString(enumClass, in.nextString());
      }
    };
  }


  // endregion
}