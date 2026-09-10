# Assignment 1 — Builder Pattern

## 1. Domain Description
This project demonstrates the **Builder Pattern** applied to a **Car Manufacturing System**.

Constructing a `Car` involves optional parameters and configurations (e.g., seats, engine, GPS, trip computer). The Builder pattern replaces telescoping constructors with a flexible step-by-step assembly process, enforces object validation, and allows pre-configured setups using a `CarDirector`.

---

## 2. Architecture & Components
* **Product (`Car`):** An immutable object representing the final car with properties: `seats`, `engine`, `hasGps`, and `hasTripComputer`.
* **Builder (`Car.Builder`):** A static inner class providing step-by-step assembly methods with fluent method chaining.
* **Director (`CarDirector`):** Orchestrates common build sequences (*Sports Car*, *City Car*, *Base Car*).
* **Client (`Main`):** Tests the creation of products using both the `CarDirector` and validates invalid states.

---

## 3. Clean Code Principles Applied

### Principle 1: Meaningful, Intention-Revealing Names
Classes, variables, and methods clearly state their purpose without needing extra comments.
```java
// Annotated Excerpt from CarDirector.java:
public void constructSportsCar(Car.Builder builder) {
    builder.setSeats(2)
           .setEngine("V8 Turbo")
           .setGps(true)
           .setTripComputer(true);
}
```
### Principle 2: Small Methods (Do One Thing)
Each method in the builder and director serves a single responsibility and supports method chaining.
```java // Annotated Excerpt from Car.java:
public Builder setSeats(int seats) {
    this.seats = seats;
    return this; // Focuses solely on setting seats and returning builder instance
}
```
### Principle 3: Validated Construction (Fail-Fast)
The build() method verifies that the object is in a valid state before creation, throwing descriptive runtime exceptions on invalid input.
```java
// Annotated Excerpt from Car.java:
public Car build() {
    if (seats <= 0) {
        throw new IllegalStateException("Cannot build Car: Seats count must be greater than 0");
    }
    if (engine == null || engine.isBlank()) {
        throw new IllegalStateException("Cannot build Car: Engine must not be empty");
    }
    return new Car(this);
}
```
### Principle 4: Prefer Exceptions to Returning Error Codes
Invalid states throw clear IllegalStateException rather than returning null or negative error codes.
```java
// Annotated Excerpt from Main.java:
try {
    new Car.Builder().setSeats(0).setEngine("Test Engine").build();
} catch (IllegalStateException e) {
    System.out.println(e.getMessage()); // Handles clear exception
}
```

Principle 5: Encapsulation & Immutability
The Car class is final, fields are private final, and the constructor is private, enforcing modification only via Builder during creation.
```java
// Annotated Excerpt from Car.java:
public final class Car {
    private final int seats;
    private final String engine;

    private Car(Builder builder) { // Private constructor prevents direct instantiation
        this.seats = builder.seats;
        this.engine = builder.engine;
    }
}
```
4. How to Run & Output
How to Run
Clone the repository.

Open in Java IDE (IntelliJ IDEA recommended).

Run src/Main.java.

Example Output
```java
Sports Car:
Car{seats=2, engine='V8 Turbo', hasGps=true, hasTripComputer=true}

City Car:
Car{seats=4, engine='1.6L Eco', hasGps=true, hasTripComputer=false}

Base Car:
Car{seats=5, engine='Standard Engine', hasGps=false, hasTripComputer=false}

Validation test:
Cannot build Car: Seats count must be greater than 0
```
