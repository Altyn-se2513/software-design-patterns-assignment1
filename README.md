Assignment 1: Builder Pattern with Clean Code Principles
Overview
This project demonstrates the implementation of the Builder Pattern in Java (`Car.Builder`) while applying core software engineering practices from Clean Code.
Clean Code Principles Applied
Single Responsibility & Small Functions: Every method in the `Builder` is short, performs a single task, and has one level of abstraction
No Flag Arguments: Instead of passing boolean parameters (e.g., `setGps(boolean)`), descriptive methods like `enableGps()` and `enableTripComputer()` are used to improve code readability
Immutability The `Car` object is completely immutable. Its fields are `final` and can only be assigned via the private constructor called by the `Builder`.
Argument Validation: Input checks (e.g., `seats > 0` and non-null `engine`) are handled during step-by-step configuration.

Project Structure
Car.java — Product class with a static nested `Builder`
Main.java — Client code demonstrating fluent object construction (Method Chaining)
