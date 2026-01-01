# Smart Subscription & Payment Management System (Java OOP Capstone)

## 📌 Project Overview

**Client Brief:**

> We need a Java-based backend system that manages users, subscriptions, and payments for a digital service platform (e.g., streaming, gym membership, SaaS tools). The system must be **scalable, maintainable, and flexible**, following **Object-Oriented Programming (OOP) best practices**.

This project is designed to **100% apply Java OOP fundamentals**, including:

* Classes & Objects
* Encapsulation
* Inheritance
* Abstraction
* Interfaces
* Polymorphism
* Method & Constructor Overloading
* Method Overriding

---

## 🎯 Learning Objectives

By completing this project, you will be able to:

* Differentiate **primitive data types vs objects**
* Design **real-world Java classes**
* Apply **encapsulation** using access modifiers
* Use **inheritance** to reduce code duplication
* Implement **abstraction and interfaces**
* Apply **polymorphism** for flexible behavior
* Write **reusable and maintainable Java code**

---

## 🧩 System Scope

The system will manage:

* Users (customers & admins)
* Subscription plans
* Payment processing
* Transaction history
* Notifications (email/SMS simulation)

---

## 🏗️ Core System Requirements

## 1️⃣ OOP Fundamentals (Classes, Objects, Constructors, Methods)

### 1.1 User Management

#### Class: `User`

**Fields:**

* `int userId`
* `String name`
* `String email`
* `String password`
* `boolean active`

**Constructors:**

* Default constructor
* Parameterized constructor

**Methods:**

* `login()`
* `logout()`
* `updateProfile()`
* `displayUserInfo()`

> ✔ Demonstrates objects, constructors, fields, and methods

---

## 2️⃣ Encapsulation & Inheritance

### 2.1 Encapsulation Requirements

* All fields must be `private`
* Use `getter` and `setter` methods
* Validate critical data (email, password length, balance)

Example:

* Password must be at least **8 characters**
* Email must contain `@`

---

### 2.2 Inheritance Structure

#### Parent Class: `User`

#### Child Classes:

##### `Customer extends User`

**Additional Fields:**

* `Subscription activeSubscription`
* `List<Transaction> transactionHistory`

**Additional Methods:**

* `subscribePlan()`
* `cancelSubscription()`

##### `Admin extends User`

**Additional Methods:**

* `createSubscriptionPlan()`
* `updateSubscriptionPlan()`
* `viewAllUsers()`

> ✔ Demonstrates inheritance and code reuse

---

## 3️⃣ Abstraction

### 3.1 Abstract Class Requirement

#### Abstract Class: `Subscription`

**Fields:**

* `String planName`
* `double price`
* `int durationInDays`

**Abstract Methods:**

* `calculateFinalPrice()`
* `getPlanDetails()`

**Concrete Method:**

* `isActive()`

---

### 3.2 Subscription Implementations

#### Classes:

* `MonthlySubscription`
* `YearlySubscription`
* `StudentDiscountSubscription`

Each class must:

* Extend `Subscription`
* Override `calculateFinalPrice()`

> ✔ Demonstrates abstraction and method overriding

---

## 4️⃣ Interfaces and Polymorphism

### 4.1 Payment Interface

#### Interface: `PaymentMethod`

**Methods:**

* `processPayment(double amount)`
* `generateReceipt()`

---

### 4.2 Payment Implementations

#### Classes:

* `CreditCardPayment`
* `GCashPayment`
* `BankTransferPayment`

Each class must:

* Implement `PaymentMethod`
* Provide its own payment logic

> ✔ Demonstrates interface implementation

---

### 4.3 Polymorphism Requirement

* Store payment objects using `PaymentMethod` reference
* Execute `processPayment()` dynamically

Example:

```text
PaymentMethod payment = new GCashPayment();
payment.processPayment(999.99);
```

> ✔ Demonstrates runtime polymorphism

---

## 5️⃣ Method & Constructor Overloading

### 5.1 Method Overloading

#### Class: `NotificationService`

Overloaded Methods:

* `sendNotification(String message)`
* `sendNotification(String message, String email)`
* `sendNotification(String message, String email, String phone)`

---

### 5.2 Constructor Overloading

#### Class: `Transaction`

Constructors:

* `Transaction()`
* `Transaction(double amount)`
* `Transaction(double amount, PaymentMethod method)`

> ✔ Demonstrates compile-time polymorphism

---

## 6️⃣ Transaction & History Tracking

#### Class: `Transaction`

**Fields:**

* `int transactionId`
* `double amount`
* `LocalDateTime date`
* `PaymentMethod paymentMethod`

**Methods:**

* `printReceipt()`

Customers must:

* Maintain a list of transactions
* View payment history

---

## 7️⃣ Exception Handling (Required)

Custom Exceptions:

* `InvalidPaymentException`
* `SubscriptionExpiredException`
* `AuthenticationException`

Use `try-catch` blocks where:

* Payments fail
* Invalid login occurs
* Subscription is inactive

---

## 8️⃣ Project Constraints

* Java (Console-based or simple GUI)
* No database required (use `ArrayList`)
* Follow **SOLID OOP principles** where possible
* Clean package structure required

---

## 📂 Suggested Package Structure

```
com.project.subscription
│
├── users
│   ├── User
│   ├── Customer
│   └── Admin
│
├── subscription
│   ├── Subscription
│   ├── MonthlySubscription
│   └── YearlySubscription
│
├── payment
│   ├── PaymentMethod
│   ├── CreditCardPayment
│   └── GCashPayment
│
├── transaction
│   └── Transaction
│
├── notification
│   └── NotificationService
│
└── exceptions
```

---

## 🏁 Final Deliverables

* Complete Java source code
* UML class diagram
* README explaining OOP concepts used
* Sample execution screenshots

---

## ⭐ Evaluation Criteria

| Criteria                                | Weight |
| --------------------------------------- | ------ |
| OOP Implementation                      | 40%    |
| Code Structure & Cleanliness            | 20%    |
| Proper Use of Interfaces & Polymorphism | 20%    |
| Exception Handling                      | 10%    |
| Documentation                           | 10%    |

---

## 🚀 Outcome

After completing this project, you will have:

* A **portfolio-ready Java OOP project**
* Strong mastery of **OOP concepts**
* A foundation for **Spring Boot & enterprise Java**

---

> ✅ This project fully satisfies **100% of your OOP, Encapsulation, Inheritance, Interfaces, and Polymorphism requirements**.
