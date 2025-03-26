

## 📌 Project Overview
This is a **Core Java + JDBC-based Online Car Rental System** that allows users to browse, book, and rent cars. The project includes authentication, booking management, payments, and an admin panel.

## 📂 Folder Structure
```
📂 CarRentalSystem/
│
├── 📂 src/ (Java Source Code)
│   ├── DBConnection.java
│   ├── RegisterUser.java
│   ├── LoginUser.java
│   ├── BookCar.java
│   ├── PaymentProcessing.java
│   ├── AdminPanel.java
│   ├── InvoiceGenerator.java
│
├── 📂 webapp/ (Frontend - HTML, CSS)
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── booking.html
│   ├── payment.html
│   ├── confirmation.html
│   ├── styles.css
│
├── 📂 database/ (SQL Scripts)
│   ├── CarRentalDB.sql
│
├── 📂 lib/ (JAR Dependencies)
│   ├── mysql-connector-java.jar
│
├── 📂 config/ (Configuration Files)
│   ├── database.properties
│
├── 📄 README.md (Project Documentation & Setup Guide)
├── 📄 .gitignore (Ignore compiled files)
```

## ⚡ Setup Instructions
### 1️⃣ Install Required Software
- Install **Java (JDK 8+)**
- Install **MySQL Server & Workbench**
- Install **Apache Tomcat (Optional for deployment)**

### 2️⃣ Set Up MySQL Database
1. Open **MySQL Workbench** or **phpMyAdmin**
2. Run `CarRentalDB.sql` to create tables

### 3️⃣ Configure Database Connection
- Open `config/database.properties`
- Update credentials if needed

### 4️⃣ Compile & Run Java Backend
```sh
cd path/to/CarRentalSystem/src
javac *.java
java RegisterUser  # Run User Registration
java LoginUser     # Run Login System
java BookCar       # Run Car Booking
java PaymentProcessing # Run Payment System
```

### 5️⃣ Open Frontend in Browser
- Navigate to `webapp/`
- Open `index.html` in Chrome/Edge

### 🎯 Project is Ready!
Your Online Car Rental System is fully functional! 🚀