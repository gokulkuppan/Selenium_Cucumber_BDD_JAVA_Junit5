# OOP Concepts in Test Automation Framework

## Overview
This package contains working examples of Object-Oriented Programming (OOP) concepts used in Test Automation with Selenium.

## Key OOP Concepts Covered:

### 1. **Inheritance** (Example 1 & 2)
- **BasePage Pattern**: Common functionality inherited by all page classes
- **Why**: Eliminates code duplication, provides reusable methods
- **Real Example**: HomePage extends BasePage to inherit common web actions

### 2. **Encapsulation** (Example 3)
- **Private Fields + Public Methods**: Data hiding with controlled access
- **Why**: Protects page elements, provides clean API for test steps
- **Real Example**: WebElements are private, accessed through public methods

### 3. **Abstraction** (Example 4)
- **Abstract Classes**: Define contract without full implementation
- **Why**: Forces child classes to implement specific behaviors
- **Real Example**: Abstract BasePage with abstract methods for page-specific logic

### 4. **Polymorphism** (Example 5)
- **Method Overriding**: Child classes provide specific implementation
- **Why**: Same method name, different behavior based on context
- **Real Example**: Different pages override getPageTitle() differently

### 5. **Interface** (Example 6)
- **WebDriver Interface**: Contract for different browser implementations
- **Why**: Switch between Chrome, Firefox, Edge without changing code
- **Real Example**: WebDriver interface with ChromeDriver, FirefoxDriver implementations

## Files Structure:
1. `Example1_InheritanceBasics.java` - Basic inheritance demonstration
2. `Example2_POMInheritance.java` - Page Object Model inheritance pattern
3. `Example3_Encapsulation.java` - Data hiding and access control
4. `Example4_Abstraction.java` - Abstract classes in POM
5. `Example5_Polymorphism.java` - Method overriding in page classes
6. `Example6_Interface.java` - Interface implementation (WebDriver pattern)
7. `OOPSConceptsMainDemo.java` - Main class to execute all examples

## How to Run:
Execute `OOPSConceptsMainDemo.java` main method to see all concepts in action.

