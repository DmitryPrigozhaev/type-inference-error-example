# An example of a typecast error

Application tests show an error with implicit type casting: the expected behavior does not match the actual one.

However, the project compiles successfully.

### Description

A simple JSON converter is used as an example. The input is JSON of the following format:

```json
[
  {
    "id": 1,
    "description": "description"
  }
]
```

Expected conversion of incoming JSON object to Java object:

```java
public class OutputObject {

  private final Long id;
  private final String description;

  // ...

}
```

The converter method is built using generics, the expected type of the converter and the return value of the `List`
object are implicitly passed by the calling method:

```java
public final class JsonConverter {
  public static <T> List<T> convert(String json) {
    // ... 
  }
}
```

However, instead of the expected object type, the method actually returns an object of type `LinkedHashMap`.

See tests for details.
