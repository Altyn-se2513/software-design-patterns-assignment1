Assignment 1
## 1. Domain Description
This project demonstrates the **Builder** pattern applied to a **Custom Food / Burger Order System**. 

Creating a complex order (e.g., selecting custom buns, patties, multiple toppings, sauces, combo extras, and dietary preferences) requires step-by-step construction. Using standard constructors leads to a "telescoping constructor" anti-pattern with too many parameter combinations and high risk of error. 

The Builder pattern provides a clear, step-by-step assembly process with method chaining (fluent API), explicit state validation, and multiple pre-configured presets managed by a **Director**.

## 2. Architecture & Components

* **Product (`Order`):** Represents the complex object being built with multiple configurable fields.
* **Builder (`OrderBuilder`):** Handles step-by-step assembly and returns `this` for fluent method chaining.
* **Director (`OrderDirector`):** Orchestrates predefined build sequences for common orders (e.g., *Vegan Combo*, *Ultimate Meat Feast*).
* **Client (`Main`):** Demonstrates custom build steps, fluent API usage, director execution, and exception handling on invalid inputs.

## 3. Clean Code Principles Applied

Below are 5 Clean Code principles explicitly identified and justified in this implementation:

### Principle 1: Meaningful, Intention-Revealing Names
Classes, methods, and fields use domain-specific names that clearly state their purpose without requiring extra code comments.

* **Before:**
```java
public class Ord {
    private String b;
    private int q;
    public Ord mk() { ... }
}
* **After:**
public class Order {
    private final String bunType;
    private final int pattyQuantity;
    public Order build() { ... }
}

Principle 2: Small, Single-Responsibility Methods
Every setter method in the Builder performs exactly one operation (setting a single property) and returns this to support method chaining.

Annotated Code Excerpt
// Focuses only on setting the patty count and returning the builder instance
public OrderBuilder setPattyQuantity(int pattyQuantity) {
    this.pattyQuantity = pattyQuantity;
    return this; // Enables fluent API chaining
}
Principle 3: Validated Construction (Fail-Fast)
The build() method enforces business integrity by validating all required properties before creating the object, throwing descriptive exceptions on invalid state.

Annotated Code Excerpt:
public Order build() {
    // Throws clear exceptions if mandatory conditions fail
    if (bunType == null || bunType.isBlank()) {
        throw new IllegalStateException("Order build failed: Bun type must be specified.");
    }
    if (pattyQuantity <= 0) {
        throw new IllegalArgumentException("Order build failed: Patty quantity must be at least 1.");
    }
    return new Order(this);
}
Principle 4: No Magic Numbers or Magic Strings
Constants are extracted into private static final fields or clear validation variables to prevent obscure literals in the logic.

Before:

if (p > 5) {
    throw new IllegalArgumentException("Error 400");

}

after

private static final int MAX_PATTIED_LIMIT = 5;

if (pattyQuantity > MAX_PATTIED_LIMIT) {
    throw new IllegalArgumentException("Patty quantity exceeds maximum limit of " + MAX_PATTIED_LIMIT);
}

Principle 5: Encapsulation & Immutability
Product properties are declared as private final without public setters. Once the object is constructed by the Builder, its state cannot be altered, ensuring thread safety and data consistency.

Annotated Code Excerpt:
public class Order {
    // Fields are immutable after construction
    private final String bunType;
    private final int pattyQuantity;

    // Package-private constructor forces instantiation strictly through the Builder
    Order(OrderBuilder builder) {
        this.bunType = builder.getBunType();
        this.pattyQuantity = builder.getPattyQuantity();
    }
}

4. How to Run
Clone the repository:
git clone [https://github.com/Altyn-se2513/software-design-patterns-assignment1.git](https://github.com/Altyn-se2513/software-design-patterns-assignment1.git)
Open the project in IntelliJ IDEA.
Locate src/Main.java and execute the main method to see the output.
