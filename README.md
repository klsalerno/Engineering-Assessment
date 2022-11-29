# Engineering-Test

Engineering-Test is a Java project that takes orders for breakfast, lunch, and dinner.

## About the System

* The system returns the names of menu items in the order:
    * `Meal, Side, Drink`
* Each order **must** contain a main and side
* If a drink is not ordered, water is returned
* Breakfast allows multiple cups of coffee, and lunch allows multiple sides
    * Multiple items are indicated after the name of the item with: `(number)`
* A dinner order **must** include dessert, and water is always provided at dinner

## Dependencies

JUnit is a unit testing framework for Java. It is used to evaluate test cases for the project.

Inheritance is used to create a general `Meal` object that is the superclass to
specific meal types `Breakfast`, `Lunch`, and `Dinner`

## Testing

The `MenuOrderingTest` class provides test cases for the ordering system.
JUnit must be imported in the class to be used.

The `assert` method from JUnit is used in the testing class to check for correct output.
Annotations from JUnit used in the testing class are `@Before`, `@After`, and `@Test`

```Java
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
```

Gradle is used to run and test from the Terminal:
```
./gradlew run
./gradlew test
```
