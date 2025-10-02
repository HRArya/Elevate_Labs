package employeedb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() throws Exception {
        // Change DB URL, username, password as per your MySQL setup
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = "hello";

        // Load JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
    }

    public void addEmployee(Employee emp) throws Exception {
        String sql = "INSERT INTO employees(name, department, salary) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getDepartment());
        stmt.setDouble(3, emp.getSalary());
        stmt.executeUpdate();
        System.out.println("✅ Employee added successfully!");
    }

    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
            );
            list.add(emp);
        }
        return list;
    }

    public void updateEmployee(int id, double newSalary) throws Exception {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, newSalary);
        stmt.setInt(2, id);
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("✅ Employee updated successfully!");
        } else {
            System.out.println("⚠️ Employee not found!");
        }
    }

    public void deleteEmployee(int id) throws Exception {
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("✅ Employee deleted successfully!");
        } else {
            System.out.println("⚠️ Employee not found!");
        }
    }
}
