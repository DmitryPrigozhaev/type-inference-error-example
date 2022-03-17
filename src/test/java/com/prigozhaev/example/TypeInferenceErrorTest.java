package com.prigozhaev.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Tests exhibit a type inference error when the expected result
 * differs from the actual result.
 *
 * @author Dmitry Prigozhaev
 * on 17.03.2022
 */
class TypeInferenceErrorTest {

  /**
   * JSON example:
   *
   * <pre>
   * [
   *     {
   *         "id": 1,
   *         "description": "description"
   *     }
   * ]
   * </pre>
   */
  private static final String JSON = "[{\"id\":1,\"description\":\"description\"}]";

  @DisplayName("The returned object should be an OutputObject type")
  @Test
  void returnedObjectShouldBeAnOutputObjectType() {
    // when
    List<OutputObject> result = JsonConverter.convert(JSON);

    // then
    assertAll("Checking the expected behavior",
      () -> assertEquals(1, result.size()),
      () -> assertInstanceOf(OutputObject.class, result.get(0))
    );
  }

  @DisplayName("The returned object should not be an Map type")
  @Test
  void returnedObjectShouldNotBeAnMapType() {
    // when
    List<OutputObject> result = JsonConverter.convert(JSON);

    // then
    assertAll("Checking the unexpected behavior",
      () -> assertEquals(1, result.size()),
      () -> assertFalse(result.get(0) instanceof Map)
    );
  }
}
