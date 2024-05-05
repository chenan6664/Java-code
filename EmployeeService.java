public class EmployeeService {
    private EmployeeMapper employeeMapper;

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeMapper.deleteEmployee(id);
    }
}