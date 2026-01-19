# Smart Subscription & Payment Management System (Java OOP Capstone)

## 📌 Project Overview

This Java-based backend system manages users, subscriptions, and payments for a digital service platform (e.g., streaming, gym membership, SaaS tools). The system applies **100% Object-Oriented Programming (OOP)** principles including:

* Classes & Objects
* Encapsulation
* Inheritance
* Abstraction
* Interfaces
* Polymorphism
* Method & Constructor Overloading
* Method Overriding

---

## 🧩 System Scope

The system will manage:

* Users (Customers & Admins)
* Subscription Plans
* Payment Processing
* Transaction History
* Notifications (email/SMS simulation)

---

# 🏗️ Core System Requirements (Separated)

## 1️⃣ Common User Requirements

**Class: User** (Parent)

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

**Encapsulation:**

* All fields private
* Use getters and setters
* Validate critical data:

  * Password ≥ 8 characters
  * Email contains `@`

---

## 2️⃣ Customer Requirements

**Class: Customer (extends User)**

**Additional Fields:**

* `Subscription activeSubscription`
* `List<Transaction> transactionHistory`

**Methods:**

* `subscribePlan()` → Select and activate a subscription
* `cancelSubscription()` → Cancel the current subscription
* `viewTransactions()` → View payment history

**Behavior:**

* Customers only **view plans and subscribe**
* Can maintain their **own transaction history**
* Receives **notifications** about subscription updates or payments

**Polymorphism / OOP Coverage:**

* `activeSubscription` can reference any `Subscription` subclass
* Transaction payments stored using `PaymentMethod` interface references

---

## 3️⃣ Admin Requirements

**Class: Admin (extends User)**

**Methods:**

* `createSubscriptionPlan()` → Create base plan and generate variants (Monthly, Yearly, Student Discount)
* `updateSubscriptionPlan()` → Update name, price, or other plan details
* `viewAllUsers()` → List all registered users

**Behavior:**

* Admin creates and manages **all subscription plans**
* Handles plan **updates**, discounts, and durations
* Responsible for **notifications to customers** if plan details change

**Polymorphism / OOP Coverage:**

* `Subscription` objects stored in `ArrayList<Subscription>`
* Admin method generates multiple **subclass objects** (Monthly, Yearly, StudentDiscount)
* Uses **method overloading** if required for creating or updating plans

---

## 4️⃣ Subscription & Payment (Shared)

**Abstract Class: Subscription**

* Fields: `String planName`, `double price`, `int durationInDays`
* Abstract Methods: `calculateFinalPrice()`, `getPlanDetails()`
* Concrete Method: `isActive()`

**Implementations (for Admin-created plans):**

* `MonthlySubscription`
* `YearlySubscription`
* `StudentDiscountSubscription`

**Interface: PaymentMethod**

* Methods: `processPayment(double amount)`, `generateReceipt()`
* Implementations: `CreditCardPayment`, `GCashPayment`, `BankTransferPayment`

**Notifications**

* Class: `NotificationService`
* Overloaded methods for sending messages to **customers and optionally admins**

**Transactions**

* Class: `Transaction`
* Fields: `transactionId`, `amount`, `LocalDateTime date`, `PaymentMethod paymentMethod`
* Constructor overloading: `Transaction()`, `Transaction(double)`, `Transaction(double, PaymentMethod)`

---

## 5️⃣ Exception Handling

* Custom exceptions:

  * `InvalidPaymentException`
  * `SubscriptionExpiredException`
  * `AuthenticationException`
* Use try-catch for:

  * Payment failures
  * Invalid login attempts
  * Expired/inactive subscriptions

---

## 6️⃣ Suggested Package Structure

```text
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
│   ├── YearlySubscription
│   └── StudentDiscountSubscription
│
├── payment
│   ├── PaymentMethod
│   ├── CreditCardPayment
│   ├── GCashPayment
│   └── BankTransferPayment
│
├── transaction
│   └── Transaction
│
├── n
```
