import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreams {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Varun", 3500));
        employeeList.add(new Employee(2, "Nikhil", 3600));
        employeeList.add(new Employee(3, "Abhi", 3700));
        employeeList.add(new Employee(4, "abc", 3200));
        employeeList.add(new Employee(5, "def", 3800));
        employeeList.add(new Employee(6, "ghi", 3100));
        employeeList.add(new Employee(7, "jkl", 2700));


        List<Employee> collect = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(5).collect(Collectors.toList());
        System.out.println(collect);
    }
}
class Employee{
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}