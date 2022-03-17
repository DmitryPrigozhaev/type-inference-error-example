package com.prigozhaev.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * A simple class used for the type inference error example.
 * Performs the work of converting JSON to a list of JAVA objects.
 *
 * @author Dmitry Prigozhaev
 * on 17.03.2022
 */
public final class JsonConverter {

  private static final ObjectMapper mapper = new ObjectMapper();

  /**
   * Some public method used to convert a JSON to a Java Object.
   *
   * <p>The type of the returned object is implicitly passed by
   * the calling method.
   *
   * @param <T>  the return type to convert the response to
   * @param json the JSON to convert to object
   * @return the {@link List} of {@code T} objects
   */
  public static <T> List<T> convert(String json) {
    List<T> result = null;
    try {
      result = mapper.readValue(json, new TypeReference<List<T>>() {
      });
    } catch (IOException e) {
      // ignore
    }
    return result;
  }

  /**
   * Utility class can't be instantiated.
   */
  private JsonConverter() {
    throw new IllegalStateException("Utility class");
  }
}
