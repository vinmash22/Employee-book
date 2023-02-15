import java.util.Arrays;

public class Main {
    public static void ptintAList(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (i == employees.length - 1) {
                System.out.println(employees[i]);
                break;
            }
            System.out.println(employees[i] + " ");
        }
    }
    public static void calculateSalary(Employee[] employees) {

        double sum = 0;
        for (Employee element : employees) {

            sum += element.getSalary();
        }
        System.out.println("Сумма трат за месяц составила " + sum + " рублей");
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        Employee Ivanov = new Employee("Иванов ИИ", 1, 45237);
        Employee Petrov = new Employee("Петров ИИ", 1, 44480);
        employees[0] = Ivanov;
        employees[1] = Petrov;
        ptintAList (employees);
        calculateSalary(employees);


    }
}