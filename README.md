# Assignment 1 — Builder Pattern

## 1. Domain Description

This project demonstrates the **Builder Pattern** applied to a **Car Manufacturing System**.

Constructing a `Car` object involves multiple optional parameters and configurations (e.g., number of seats, engine type, GPS installation, trip computer). Using standard constructors with many parameters leads to the "telescoping constructor" anti-pattern, making the code hard to read and error-prone.

The Builder pattern provides a flexible, step-by-step assembly process using a fluent API, enforces validity checks upon object construction, and allows pre-configured configurations using a `CarDirector`.

---

## 2. Architecture & Components

* **Product (`Car`):** A complex, immutable object representing the final car with properties like seats, engine, GPS, and trip computer.
* **Builder (`Car.Builder`):** A static inner class providing step-by-step assembly methods with fluent method chaining.
* **Director (`CarDirector`):** Orchestrates common build sequences (e.g., *Sports Car*, *City Car*, *Base Car*).
* **Client (`Main`):** Tests the creation of products using both the `CarDirector` and manual custom configurations.

---

## 3. Clean Code Principles Applied

Below are 5 Clean Code principles explicitly identified and justified in this implementation:

### Principle 1: Meaningful, Intention-Revealing Names
Classes, variables, and methods clearly indicate their intent without needing unnecessary comments.

* **Before:**
```java
public class C {
    private int s;
    private String e;
    public C b() { ... }
}

after
public class Car {
    private final int seats;
    private final String engine;
    public Car build() { ... }
}
Principle 2: Small, Single-Responsibility Methods
Each method in the builder serves a single purpose (setting a specific field or enabling a feature) and returns this to support method chaining.

Annotated Code Excerpt:
// Method focuses solely on setting the seats and supporting fluent API
public Builder setSeats(int seats) {
    this.seats = seats;
    return this;
}
Principle 3: Validated Construction (Fail-Fast)
The build() method verifies that the object is in a valid state before creation, throwing descriptive runtime exceptions on invalid state.

Annotated Code Excerpt:
public Car build() {
    // Validates object state before instantiation
    if (seats <= 0) {
        throw new IllegalStateException("Cannot build Car: Seats count must be greater than 0");
    }
    if (engine == null || engine.isBlank()) {
        throw new IllegalStateException("Cannot build Car: Engine cannot be empty");
    }
    return new Car(this);
}
Principle 4: No Magic Numbers or Magic Strings
Default values and limits are explicitly declared and clear within the builder context.

Before:
if (s <= 0) throw new RuntimeException("Err 1");
after
if (seats <= 0) {
    throw new IllegalArgumentException("Seats count must be greater than 0");
}
Principle 5: Encapsulation & Immutability
The Car class is marked as final, all fields are private final, and there are no public setters. The constructor is private, enforcing object creation exclusively through the Builder.

Annotated Code Excerpt:
public final class Car {
    private final int seats;
    private final String engine;

    // Private constructor prevents direct instantiation
    private Car(Builder builder) {
        this.seats = builder.seats;
        this.engine = builder.engine;
    }
}


4. How to Run
Clone the repository
Open the project in IntelliJ IDEA.
Locate src/Main.java and execute the main method.
