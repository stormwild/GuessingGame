# GuessingGame

## Notes

Creating a Helper class with initialization.

To initialize a class with static methods use a static block initializer

```java
static {
    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    for (int i = 0; i < fonts.length; i++) {
      availableFonts.put(fonts[i], fonts[i]);
    }
  }
```

- [How to Use Static Initializers in Java](https://www.dummies.com/programming/java/how-to-use-static-initializers-in-java/)


Enable language features like lambda by specifying release

```xml
<properties>
    <maven.compiler.release>7</maven.compiler.release>
</properties>
```

- [Setting the Java Version in Maven](https://www.baeldung.com/maven-java-version)

## References

- [Java equivalent to C# extension methods](https://stackoverflow.com/questions/4359979/java-equivalent-to-c-sharp-extension-methods)
- [Java Singleton Design Pattern Best Practices with Examples](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples)
