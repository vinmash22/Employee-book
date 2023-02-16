import java.util.Arrays;

public class Main {
    public static void printAList(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (i == employees.length - 1) {
                System.out.println(employees[i]);
                break;
            }
            System.out.println(employees[i] + " ");
        }
    }

    public static void printFullName(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (i == employees.length - 1) {
                System.out.println(employees[i].getFullName());
                break;
            }
            System.out.println(employees[i].getFullName() + " ");
        }
    }

    public static void calculateSalary(Employee[] employees) {

        double sum = 0;
        double averageSalary = 0;
        for (Employee element : employees) {

            sum += element.getSalary();
            averageSalary = sum / employees.length;
        }
        System.out.println("Сумма затрат на зарплаты за месяц составила " + sum + " рублей");
        System.out.println("Средняя зарплата за месяц " + averageSalary + " рублей");

    }

    public static void calculateMinMaxSalary(Employee[] employees) {
        double max = employees[0].getSalary();
        double min = employees[0].getSalary();
        for (Employee element : employees) {
            if (element.getSalary() > max) {
                max = element.getSalary();
            }
            if (element.getSalary() < min) {
                min = element.getSalary();
            }
        }
        System.out.println("Максимальная зарплата составила " + max + " рублей");
        System.out.println("Минимальная зарплата составила " + min + " рублей");
    }

    public static void indexSalary(Employee[] employees) {

        int percent = 7;
        double indexedSalary = 0;
        for (Employee element : employees) {

            indexedSalary = element.getSalary() + element.getSalary() * percent / 100;
            System.out.println("Сотрудник " + element.getFullName() + ", проиндексированная зарплата: " + indexedSalary + " рублей");
        }
    }

//            анализ по сотрудникам одного отдела

    public static void calculateMinSalaryInTheDepartment(Employee[] employees, int departmentNumber) {
        double max = employees[0].getSalary();
        double min = employees[0].getSalary();

        for (Employee element : employees) {
            if (element.getDepartment() == departmentNumber) {
                if (element.getSalary() > max) {
                    max = element.getSalary();
                }
                if (element.getSalary() < min) {
                    min = element.getSalary();
                }
            }
        }
        System.out.println("Максимальная зарплата по отделу " + departmentNumber + " составила " + max + " рублей");
        System.out.println("Минимальная зарплата по отделу " + departmentNumber + " составила " + min + " рублей");
    }

    public static void printAListInTheDepartment(Employee[] employees, int departmentNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departmentNumber) {
                if (i == employees.length - 1) {
                    System.out.println("Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
                    break;
                }
                System.out.println("Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
            }
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        Employee Ivanov = new Employee("Иванов И.И.", 1, 64320);
        Employee Petrov = new Employee("Петров И.В.", 2, 59480);
        Employee Sidorov = new Employee("Сидоров А.Н.", 3, 66112);
        Employee Nekrasova = new Employee("Некрасова Е.А.", 4, 66112);
        Employee Burundukova = new Employee("Бурундукова Д.Е.", 5, 47543);
        Employee Kuznetsova = new Employee("Кузнецова П.Е.", 3, 78313);
        Employee Gribov = new Employee("Грибов А.А.", 1, 65423);
        Employee Bednov = new Employee("Беднов А.В.", 4, 78313);
        Employee Gracheva = new Employee("Грачева Е.В.", 5, 65423);
        Employee Semenova = new Employee("Семенова Л.А.", 2, 59480);

        employees[0] = Ivanov;
        employees[1] = Petrov;
        employees[2] = Sidorov;
        employees[3] = Nekrasova;
        employees[4] = Burundukova;
        employees[5] = Kuznetsova;
        employees[6] = Gribov;
        employees[7] = Bednov;
        employees[8] = Gracheva;
        employees[9] = Semenova;

        System.out.println("Список сотрудников:");
        printAList(employees);
        System.out.println(" ");
        calculateSalary(employees);
        calculateMinMaxSalary(employees);
        System.out.println(" ");
        System.out.println("ФИО сотрудников:");
        printFullName(employees);
        System.out.println(" ");
        Ivanov.setSalary(78319);
        System.out.println("Сотрудник " + Ivanov.getFullName() + ", измененная зарплата: " + Ivanov.getSalary() + " рублей");
        System.out.println(" ");
        calculateSalary(employees);
        calculateMinMaxSalary(employees);
        System.out.println(" ");
        indexSalary(employees);
//        анализ по сотрудникам одного отдела
        int departmentNumber = 1;
        System.out.println(" ");
        System.out.println("Список сотрудников отдела " +departmentNumber+ ":");
        printAListInTheDepartment(employees, departmentNumber);
        calculateMinSalaryInTheDepartment(employees, departmentNumber);
    }
}