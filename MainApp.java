import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        // 测试功能
        Employee emp1 = new Employee(1, "John Doe");
        employeeService.addEmployee(emp1);

        Employee emp2 = employeeService.getEmployeeById(1);
        System.out.println("Employee found: " + emp2.getName());

        emp2.setName("Jane Smith");
        employeeService.updateEmployee(emp2);
        
    }
}