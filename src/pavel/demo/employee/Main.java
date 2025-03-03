package pavel.demo.employee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Vasek", "Pupkin", LocalDateTime.of(2010, 9, 30, 0, 0)));
        employees.add(new Employee("Durik", "Maturkov", LocalDateTime.of(2015, 7, 27, 0, 0)));
        employees.add(new Employee("Grisha", "Morzhov", LocalDateTime.of(2016, 3, 11, 0, 0)));
        employees.add(new Employee("Debil", "Debilich", LocalDateTime.of(2024, 4, 15, 0, 0)));
        employees.add(new Employee("Victor", "Guvno", LocalDateTime.of(2025, 1, 1, 0, 0)));

        printOrderedList(employees, "name");
        System.out.println();
        printOrderedList(employees, "s");
    }

    public static void printOrderedList(List<Employee> employees, String sortField) {

        int currentYear = LocalDateTime.now().getYear();

        class MyEmployee {

            Employee containedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee employee) {
                this.containedEmployee = employee;
                this.yearsWorked = currentYear - employee.hireDate().getYear();
                this.fullName = String.join(" ", employee.firstName() , employee.lastName());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<MyEmployee> list = new ArrayList<>();
        for (Employee employee : employees) {
            list.add(new MyEmployee(employee));
        }

        var comparator = new Comparator<MyEmployee>() {

            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortField.equalsIgnoreCase("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);

        for (MyEmployee myEmpl: list){
            System.out.println(myEmpl);
        }
    }
}
