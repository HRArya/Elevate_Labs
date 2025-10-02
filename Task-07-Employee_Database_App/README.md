# 📂 Task 07 – Employee Database App  

### 📌 Objective  
Build a **Java Database Application** that connects to **MySQL** using JDBC and performs **CRUD operations** (Create, Read, Update, Delete) on an Employee table.  

---

## ⚙️ Tools & Technologies  
- **Java 17+** (or any modern JDK)  
- **JDBC (Java Database Connectivity)**  
- **MySQL 8.x** (or PostgreSQL, with minor changes)  
- **VS Code / IntelliJ / Eclipse**  
- **MySQL Connector JAR** (`mysql-connector-j-8.x.x.jar`)  

---

## 🏗️ Project Structure  

```
Task-07-Employee_Database_App/
│
├── src/
│   └── employeedb/
│       ├── Employee.java        # Model class for Employee
│       ├── EmployeeDAO.java     # Handles JDBC connection + CRUD methods
│       └── EmployeeApp.java     # Main app (CLI menu)
│
├── lib/
│   └── mysql-connector-j-8.x.x.jar   # MySQL JDBC Driver
│
├── out/                        # Compiled .class files (after javac)
│
└── README.md                   # Project documentation
```

---

## 📂 Database Setup  

1. Open MySQL shell or Workbench.  
2. Create a database and table:  

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL
);
```

3. Update your **DB credentials** inside `EmployeeDAO.java`:  

```java
String url = "jdbc:mysql://localhost:3306/employee_db";
String username = "root";
String password = "your_password_here";
```

---

## ▶️ How to Run  

### 1. Compile the project
```bash
javac -cp "lib/mysql-connector-j-8.x.x.jar" -d out src/employeedb/*.java
```

### 2. Run the application
```bash
java -cp "out;lib/mysql-connector-j-8.x.x.jar" employeedb.EmployeeApp
```

---

## 📖 Features  
- ➕ **Add Employee** – Insert new employee details into DB.  
- 📋 **View Employees** – Fetch and display employee list.  
- ✏️ **Update Employee** – Update employee’s position/salary.  
- ❌ **Delete Employee** – Remove employee by ID.  
- 🔗 **Persistent Data** – Stored in MySQL.  

---

## 🏆 Outcome  
✔️ Learned **Java–MySQL connectivity** with JDBC.  
✔️ Implemented **real-world CRUD operations**.  
✔️ Improved understanding of **PreparedStatement & ResultSet**.  

---

## 📸 Sample Run  

```
=== Employee Database App ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Choose an option:
```

---

## 🚀 Future Improvements  
- Add **search by ID/Name**.  
- Include **transaction management**.  
- Build a **JavaFX/Swing GUI** version.  
