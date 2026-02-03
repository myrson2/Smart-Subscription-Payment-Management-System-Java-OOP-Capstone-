# Smart Subscription & Payment Management System

### Java OOP Capstone Project

---

## 📌 Project Overview

**Author:** Jose Myrson O. Beros  
**Project Type:** Console-Based Java Application  
**Purpose:** Educational / Portfolio (OOP-Focused)

---

The **Smart Subscription & Payment Management System** is a Java-based backend application designed to demonstrate the practical application of **Object-Oriented Programming (OOP)** principles.

The system simulates a digital subscription platform (such as streaming services, gyms, or SaaS tools) where:

- **Admins** manage users and subscription plans  
- **Customers** subscribe to plans, make payments, and track transactions  

This project prioritizes **clean architecture**, **proper separation of concerns**, and **scalable system design**, rather than real-world production complexity.

---

## 🎯 Learning Objectives

This project aims to:

- Apply **core OOP principles** in a complete Java system
- Design a **clean and modular package structure**
- Practice **manager-based and delegation architecture**
- Demonstrate **inheritance, polymorphism, abstraction, and encapsulation**
- Produce a **portfolio-ready Java capstone project**

---

## 🧩 System Scope

The system manages the following components:

- User accounts (Admins and Customers)
- Subscription plans (Monthly, Yearly, Discounted)
- Payment processing (multiple payment methods)
- Transactions and payment history
- Simulated notifications
- Centralized data handling using Manager classes

---

## 🏗️ High-Level Architecture

```

Users (Admin / Customer)
↓
Manager Layer
(UserManager / SubscriptionManager)
↓
Core Domain Objects
(Subscription, Transaction, Payment)

```

### Design Rules

✔ Users **do not store shared data**  
✔ Managers act as an **in-memory database**  
✔ Business logic is **delegated, not duplicated**

---

## 📂 Package Structure

```

com.project.subscription
│
├── users
│   ├── User.java
│   ├── Admin.java
│   └── Customer.java
│
├── manager
│   ├── UserManager.java
│   └── SubscriptionManager.java
│
├── subscription
│   ├── Subscription.java
│   ├── MonthlySubscription.java
│   ├── YearlySubscription.java
│   └── StudentDiscountSubscription.java
│
├── payment
│   ├── PaymentMethod.java
│   ├── CreditCardPayment.java
│   ├── GCashPayment.java
│   └── BankTransferPayment.java
│
├── transaction
│   └── Transaction.java
│
├── notification
│   └── NotificationService.java
│
└── exception
├── AuthenticationException.java
├── InvalidPaymentException.java
└── SubscriptionExpiredException.java

```

---

## 1️⃣ User Module

### Abstract Class: `User`

**Purpose:**  
Defines shared attributes and behavior for all system users.

#### Fields
- `int userId`
- `String name`
- `String email`
- `String password`
- `boolean active`

#### Methods
- `login()`
- `logout()`
- `updateProfile()`
- `displayUserInfo()`
- `performRoleAction()` *(abstract)*

#### OOP Concepts Applied
- Encapsulation
- Abstraction
- Inheritance

---

## 2️⃣ Customer Module

### Class: `Customer` (extends `User`)

**Purpose:**  
Represents a system user who subscribes to plans and makes payments.

#### Additional Fields
- `Subscription activeSubscription`
- `List<Transaction> transactionHistory`

#### Methods
- `subscribePlan(Subscription plan, PaymentMethod payment)`
- `cancelSubscription()`
- `viewTransactions()`

#### Behavior
- Can view available subscription plans
- Can subscribe and make payments
- Maintains personal transaction history

#### OOP Concepts Applied
- Inheritance
- Polymorphism (Subscription & PaymentMethod)
- Encapsulation

---

## 3️⃣ Admin Module

### Class: `Admin` (extends `User`)

**Purpose:**  
Acts as the system controller responsible for managing users and subscription plans.

Admins **do not store data directly**. All shared data is delegated to Manager classes.

#### Methods
- `createSubscriptionPlan(...)`
- `updateSubscriptionPlan(...)`
- `viewAllUsers()`

#### Behavior
- Creates and updates subscription plans
- Views all registered users
- Triggers notifications on plan changes

#### OOP Concepts Applied
- Polymorphism
- Method Overloading
- Delegation Pattern

---

## 4️⃣ User Registration Module

### Overview

User registration is **centralized in the `UserManager`** to ensure proper validation and separation of concerns.

✔ Supports Admin and Customer registration  
✔ Enforces unique email validation  
✔ Prevents direct user instantiation  

---

### Class: `UserManager`

**Purpose:**  
Manages all user creation, validation, and authentication.

#### Field
- `private static List<User> allUsers`

#### Registration Methods
- `registerCustomer(String name, String email, String password)`
- `registerAdmin(String name, String email, String password)`

#### Responsibilities
- Validate user input
- Ensure email uniqueness
- Create correct user type
- Store users centrally

---

### Registration Rules

| Rule              | Enforced By |
|------------------|-------------|
| Unique email     | UserManager |
| Required fields | UserManager |
| Role validation | UserManager |
| Default active  | UserManager |

---

## 5️⃣ Subscription Module

### Abstract Class: `Subscription`

**Purpose:**  
Defines the blueprint for all subscription plans.

#### Fields
- `String planName`
- `double price`
- `int durationInDays`

#### Methods
- `calculateFinalPrice()` *(abstract)*
- `getPlanDetails()` *(abstract)*
- `isActive()`

#### Implementations
- `MonthlySubscription`
- `YearlySubscription`
- `StudentDiscountSubscription`

#### OOP Concepts Applied
- Abstraction
- Inheritance
- Polymorphism

---

## 6️⃣ Payment & Transaction Module

### Interface: `PaymentMethod`

**Purpose:**  
Defines a common contract for all payment types.

#### Methods
- `processPayment(double amount)`
- `generateReceipt()`

#### Implementations
- `CreditCardPayment`
- `GCashPayment`
- `BankTransferPayment`

---

### Class: `Transaction`

**Purpose:**  
Represents a record of payment and subscription activity.

#### Fields
- `String transactionId`
- `double amount`
- `LocalDateTime date`
- `PaymentMethod paymentMethod`

#### Features
- Immutable transaction records
- Constructor overloading

---

## 7️⃣ Notification Module

### Class: `NotificationService`

**Purpose:**  
Simulates system notifications.

#### Features
- Overloaded notification methods
- Supports admin and customer notifications

---

## 8️⃣ Data Management Layer

### Class: `SubscriptionManager`

**Purpose:**  
Acts as centralized storage for all subscription plans.

#### Field
- `private static List<Subscription> allPlans`

#### Methods
- `addPlan(Subscription plan)`
- `getAvailablePlans()`
- `findPlan(String name)`
- `updatePlan(String name, ...)`

---

## 🔐 Access Control Rules

| Role     | Permissions |
|---------|-------------|
| Admin   | Create/update plans, view users |
| Customer| View plans, subscribe, pay |
| Manager| Store and protect shared data |

---

## 🧠 OOP Principles Summary

| Principle     | Applied Through |
|--------------|----------------|
| Encapsulation | Private fields and validation |
| Inheritance   | User & Subscription hierarchies |
| Polymorphism  | Interfaces and base references |
| Abstraction   | Abstract classes & interfaces |
| Delegation    | Admin → Manager classes |
| SRP           | One responsibility per class |

---

## ⏳ Project Constraints

- Console-based only
- In-memory data storage
- No external libraries
- No database integration

---

## 🚀 Future Enhancements

- Database integration
- GUI or Web interface
- Real payment gateway APIs
- Reporting and analytics
- Advanced role-based access control

---

## 📄 License

This project is intended strictly for **educational and portfolio purposes**.

---
