import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";
    private Connection connection;

    public EmployeeManagementSystem() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.employees = new ArrayList<>();
    }

    private List<Employee> employees;

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // 如果找不到对应ID的员工，则返回null
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.set(i, employee);
                return;
            }
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        // 添加员工
        Employee emp1 = new Employee(1, "John Doe");
        Employee emp2 = new Employee(2, "Jane Smith");
        system.addEmployee(emp1);
        system.addEmployee(emp2);

        // 根据ID查询员工
        int searchId = 1;
        Employee foundEmployee = system.getEmployeeById(searchId);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee.getName());
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        // 更新员工信息
        Employee updatedEmployee = new Employee(2, "Jane Johnson");
        system.updateEmployee(updatedEmployee);

        // 打印剩余的员工信息
        System.out.println("Remaining employees:");
        for (Employee employee : system.employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName());
        }
    }
}