# OOP Basics - Simple Java Examples for Practice

This package contains simple, easy-to-understand examples of Object-Oriented Programming (OOP) concepts in Java. These examples use real-world scenarios (not related to test automation) to make learning OOP fun and practical!

## 📚 What's Included

### 1️⃣ Example1_InheritanceBasics.java
**Concept**: Inheritance
**Scenario**: Animals (Dog, Cat, Bird) inheriting from Animal class
- Learn how child classes inherit properties and methods from parent class
- Understand code reusability
- See how `extends` keyword works

**Key Learning**:
- Parent class: `Animal` (common behaviors: eat, sleep)
- Child classes: `Dog`, `Cat`, `Bird` (specific behaviors: bark, meow, chirp)

---

### 2️⃣ Example2_Encapsulation.java
**Concept**: Encapsulation
**Scenario**: Bank Account with protected data
- Learn data hiding with private variables
- Understand controlled access with getters/setters
- See data validation in action

**Key Learning**:
- Private fields: `balance`, `pin` (protected from direct access)
- Public methods: `deposit()`, `withdraw()` (controlled operations with validation)
- Security: PIN verification, balance checks

---

### 3️⃣ Example3_Polymorphism.java
**Concept**: Polymorphism (both types)
**Scenario**: Shapes and Calculator
- **Method Overriding**: Different shapes implement `draw()` differently
- **Method Overloading**: Same method name with different parameters

**Key Learning**:
- Runtime Polymorphism: Shape → Circle, Rectangle, Triangle
- Compile-time Polymorphism: Calculator with multiple `add()` methods
- One interface, multiple implementations

---

### 4️⃣ Example4_Abstraction.java
**Concept**: Abstraction (Abstract Classes & Interfaces)
**Scenario**: Vehicles and Media Players
- Abstract classes: Define common structure with some implementation
- Interfaces: Define contracts without implementation

**Key Learning**:
- Abstract class: `Vehicle` (partial abstraction)
- Concrete classes: `Car`, `Motorcycle` (must implement abstract methods)
- Interface: `Playable`, `Recordable` (complete abstraction)
- Multiple interface implementation: `VideoCamera`

---

### 5️⃣ Example5_AllConcepts.java
**Concept**: All OOP Concepts Together
**Scenario**: Library Management System
- See how all four OOP pillars work together in a real system
- Understand how concepts complement each other

**Key Learning**:
- **Inheritance**: Book, DVD, Magazine extend LibraryItem
- **Encapsulation**: Private fields with controlled access
- **Polymorphism**: Each item type displays details differently
- **Abstraction**: Abstract LibraryItem class

---

## 🚀 How to Run

### Option 1: Run All Examples Together
```bash
# Run from project root
mvn clean compile
java -cp target/test-classes com.myProject.oopsBasics.RunAllExamples
```

### Option 2: Run Individual Examples
You can run each example separately:
```bash
# Example 1
java -cp target/test-classes com.myProject.oopsBasics.Example1_InheritanceBasics

# Example 2
java -cp target/test-classes com.myProject.oopsBasics.Example2_Encapsulation

# Example 3
java -cp target/test-classes com.myProject.oopsBasics.Example3_Polymorphism

# Example 4
java -cp target/test-classes com.myProject.oopsBasics.Example4_Abstraction

# Example 5
java -cp target/test-classes com.myProject.oopsBasics.Example5_AllConcepts
```

### Option 3: Using IDE
1. Open any example file in your IDE
2. Right-click on the class name
3. Select "Run" or "Run main()"

---

## 📖 Learning Path

**Recommended Order**:
1. Start with Example 1 (Inheritance) - Foundation
2. Move to Example 2 (Encapsulation) - Data protection
3. Then Example 3 (Polymorphism) - Flexibility
4. Next Example 4 (Abstraction) - Hiding complexity
5. Finally Example 5 (All Together) - See the big picture

---

## 🎯 The Four Pillars of OOP

| Pillar | Purpose | Real-world Analogy |
|--------|---------|-------------------|
| **Inheritance** | Code reusability | Children inherit traits from parents |
| **Encapsulation** | Data protection | Medicine in a capsule (hidden contents) |
| **Polymorphism** | Flexibility | One person, many roles (student, son, friend) |
| **Abstraction** | Hiding complexity | Driving a car (use without knowing engine details) |

---

## 💡 Tips for Practice

1. **Read the code comments**: Each example has detailed explanations
2. **Run the examples**: See the output to understand behavior
3. **Modify and experiment**: Change values, add new methods, break things!
4. **Create your own**: Try creating similar examples with different scenarios

---

## 🎓 Common Interview Questions Covered

✅ What is inheritance and why use it?
✅ What's the difference between private and protected?
✅ Explain method overloading vs method overriding
✅ When to use abstract class vs interface?
✅ What is encapsulation and its benefits?
✅ How does polymorphism improve code flexibility?
✅ Can a class implement multiple interfaces?
✅ What is the `super` keyword used for?

---

## 📝 Quick Reference

### Keywords Used:
- `extends` - Inheritance
- `super` - Call parent class constructor/methods
- `abstract` - Abstract classes and methods
- `interface` - Define contracts
- `implements` - Implement interfaces
- `@Override` - Override parent methods
- `private` - Hide from outside
- `protected` - Accessible to child classes
- `public` - Accessible everywhere

---

## 🎉 Happy Learning!

These examples are designed to be simple, clear, and practical. Don't just read them - run them, modify them, and create your own variations. That's how you truly learn OOP!

**Remember**: OOP is not just about syntax - it's about designing better, more maintainable software! 🚀

