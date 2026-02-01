<think>
First, the user wants me to rewrite the entire Markdown file in a "most organized way of documentation." The original content is a project overview for a Java OOP Capstone project.


## Assessing User Request  
- The user wants the entire Markdown file rewritten for better organization as project documentation.
</think># Smart Subscription & Payment Management System (Java OOP Capstone)

## 📖 Project Overview

**Author:** Jose Myrson O. Beros  
**Purpose:** This project is designed for learning Object-Oriented Programming (OOP) concepts in Java. It serves as an educational capstone to demonstrate and apply 100% OOP principles, including classes & objects, encapsulation, inheritance, abstraction, interfaces, polymorphism, method & constructor overloading, and method overriding. The project is purely for learning purposes and does not represent a real-world production system.

This Java-based backend system manages users, subscriptions, and payments for a digital service platform (e.g., streaming, gym membership, SaaS tools). It emphasizes practical implementation of OOP to build a modular, maintainable, and extensible codebase.

---

## 🧩 System Scope

The system will manage the following key components:

- **Users:** Customers and Admins with distinct roles and functionalities.
- **Subscription Plans:** Various plans with different pricing, durations, and discounts.
- **Payment Processing:** Multiple payment methods with secure transaction handling.
- **Transaction History:** Records of all payments and subscriptions.
- **Notifications:** Simulated email/SMS notifications for users.

---

## 🏗️ Core System Requirements

The system is divided into modular components, each focusing on specific OOP principles. Below are the detailed requirements for each class and module.

### 1️⃣ Common User Requirements

**Class: User** (Parent Class)  
**Purpose:** Represents a base user in the system, providing common attributes and behaviors for all user types.

**Fields:**
- `int userId`
- `String name`
- `String email`
- `String password`
- `boolean active`

**Constructors:**
- Default constructor
- Parameterized constructor

**Methods:**
- `login()`: Authenticates the user.
- `logout()`: Logs out the user.
- `updateProfile()`: Allows updating user profile information.
- `displayUserInfo()`: Displays user details.

**Encapsulation:**
- All fields are private.
- Use getters and setters for access.
- Validate critical data:
  - Password must be ≥ 8 characters.
  - Email must contain `@`.

**OOP Principles Applied:** Encapsulation, Abstraction (through methods), and serves as a base for inheritance.

---

### 2️⃣ Customer Requirements

**Class: Customer (extends User)**  
**Purpose:** Represents a customer who can subscribe to plans, manage subscriptions, and view transaction history.

**Additional Fields:**
- `Subscription activeSubscription`
- `List<Transaction> transactionHistory`

**Methods:**
- `subscribePlan()`: Selects and activates a subscription plan.
- `cancelSubscription()`: Cancels the current active subscription.
- `viewTransactions()`: Displays the customer's payment history.

**Behavior:**
- Customers can only view plans and subscribe to them.
- Maintain their own transaction history.
- Receive notifications about subscription updates or payments.

**Polymorphism / OOP Coverage:**
- `activeSubscription` can reference any `Subscription` subclass (e.g., MonthlySubscription).
- Transaction payments are stored using `PaymentMethod` interface references, demonstrating polymorphism.

**OOP Principles Applied:** Inheritance (from User), Polymorphism (via Subscription and PaymentMethod), Encapsulation.

---

### 3️⃣ Admin Requirements

**Class: Admin (extends User)**  
**Purpose:** Represents an administrator who manages subscription plans and oversees users.

**Methods:**
- `createSubscriptionPlan()`: Creates a base plan and generates variants (e.g., Monthly, Yearly, Student Discount).
- `updateSubscriptionPlan()`: Updates details like name, price, or other attributes of existing plans.
- `viewAllUsers()`: Lists all registered users in the system.

**Behavior:**
- Admins create and manage all subscription plans.
- Handle plan updates, discounts, and durations.
- Send notifications to customers if plan details change.

**Polymorphism / OOP Coverage:**
- `Subscription` objects are stored in `ArrayList<Subscription>`, allowing for polymorphic behavior.
- Admin methods generate multiple subclass objects (e.g., MonthlySubscription, YearlySubscription).
- Uses method overloading for creating or updating plans if needed.

**OOP Principles Applied:** Inheritance (from User), Polymorphism (via Subscription subclasses), Method Overloading.

---

### 4️⃣ Subscription & Payment (Shared Components)

**Abstract Class: Subscription**  
**Purpose:** Defines the structure for all subscription plans, enforcing common behavior.

- **Fields:** `String planName`, `double price`, `int durationInDays`
- **Abstract Methods:** `calculateFinalPrice()`, `getPlanDetails()`
- **Concrete Method:** `isActive()`: Checks if the subscription is currently active.

**Implementations (Subclasses for Admin-Created Plans):**
- `MonthlySubscription`: For monthly billing cycles.
- `YearlySubscription`: For annual billing with potential discounts.
- `StudentDiscountSubscription`: Applies discounts for students.

**Interface: PaymentMethod**  
**Purpose:** Defines payment processing behavior, allowing multiple implementations.

- **Methods:** `processPayment(double amount)`, `generateReceipt()`
- **Implementations:** `CreditCardPayment`, `GCashPayment`, `BankTransferPayment`

**Notifications**  
**Class: NotificationService**  
**Purpose:** Handles sending messages to users.

- Overloaded methods for sending notifications to customers and optionally admins (e.g., via email or SMS simulation).

**Transactions**  
**Class: Transaction**  
**Purpose:** Records payment details.

- **Fields:** `transactionId`, `amount`, `LocalDateTime date`, `PaymentMethod paymentMethod`
- **Constructor Overloading:** `Transaction()`, `Transaction(double)`, `Transaction(double, PaymentMethod)`

**OOP Principles Applied:** Abstraction (via abstract class and interface), Polymorphism (interface implementations), Inheritance (Subscription subclasses), Method Overloading (in constructors and notifications).

---

### 5️⃣ Exception Handling

**Purpose:** Ensures robust error handling throughout the system.

- **Custom Exceptions:**
  - `InvalidPaymentException`: Thrown for payment failures.
  - `SubscriptionExpiredException`: Thrown for expired subscriptions.
  - `AuthenticationException`: Thrown for invalid login attempts.
- **Usage:** Implement try-catch blocks for:
  - Payment processing failures.
  - Invalid login attempts.
  - Accessing expired or inactive subscriptions.

**OOP Principles Applied:** Exception handling promotes encapsulation and modularity by isolating error logic.

---

### 6️⃣ Suggested Package Structure

Organize the codebase into packages for better maintainability and adherence to OOP principles.

```
com.project.subscription
│
├── users
│   ├── User.java
│   ├── Customer.java
│   └── Admin.java
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
├── exception
│   ├── InvalidPaymentException.java
│   ├── SubscriptionExpiredException.java
│   └── AuthenticationException.java
│
└── manager
    └── SubscriptionManager.java
```

---

### 7️⃣ Subscription Manager (New Requirement)

**Class: SubscriptionManager**  
**Purpose:** Acts as a centralized, shared resource (simulating a database) that stores all subscription plans. It bridges the gap between the Admin (who creates plans) and the Customer (who views/buys plans).

**Fields:**
- `private static List<Subscription> allPlans`: A shared list holding all active subscription objects.

**Methods:**
- `addPlan(Subscription s)`: Adds a new plan to the list (used by Admin).
- `getAvailablePlans()`: Returns the list of plans (used by Customer).
- `findPlan(String name)`: Searches for a specific plan by name (used during subscription).
- `updatePlan(String name, ...)`: Updates details of existing plans (used by Admin).

**OOP Principles Applied:**
- **Encapsulation:** The list is private; external classes must use methods to access it.
- **Static Implementation:** Uses static methods to allow global access without passing instances, mimicking a persistent database service.

---

This documentation provides a comprehensive guide for implementing the system. Focus on applying OOP principles in each component to reinforce learning. For any clarifications or code examples, refer to the package structure and class details above. Remember, this is an educational project—experiment, refactor, and learn! 🚀