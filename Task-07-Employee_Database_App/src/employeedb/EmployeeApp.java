package employeedb;

import java.util.Scanner;

public class EmployeeApp {
    public static void main(String[] args) {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== Employee Database Menu ===");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();
                        dao.addEmployee(new Employee(name, dept, salary));
                        break;
                    case 2:
                        for (Employee emp : dao.getAllEmployees()) {
                            System.out.println(emp.getId() + " | " + emp.getName() + " | " +
                                    emp.getDepartment() + " | " + emp.getSalary());
                        }
                        break;
                    case 3:
                        System.out.print("Enter employee ID: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();
                        dao.updateEmployee(uid, newSalary);
                        break;
                    case 4:
                        System.out.print("Enter employee ID: ");
                        int did = sc.nextInt();
                        dao.deleteEmployee(did);
                        break;
                    case 5:
                        System.out.println("👋 Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("⚠️ Invalid choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
