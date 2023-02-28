import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Иванов И.И.", 1, 64320);
        employeeBook.addEmployee("Петров И.В.", 2, 59480);
        employeeBook.addEmployee("Сидоров А.Н.", 3, 66112);
        employeeBook.addEmployee("Некрасова Е.А.", 4, 66112);
        employeeBook.addEmployee("Бурундукова Д.Е.", 5, 47543);
        employeeBook.addEmployee("Кузнецова П.Е.", 3, 78313);
        employeeBook.addEmployee("Грибов А.А.", 1, 65423);
        employeeBook.addEmployee("Беднов А.В.", 4, 78315);
        employeeBook.addEmployee("Грачева Е.В.", 5, 65423);
        employeeBook.addEmployee("Семенова Л.А.", 2, 59480);

        System.out.println("Список сотрудников:");
        employeeBook.printAList();
        System.out.println(" ");
//      удаляем сотрудника
        employeeBook.removeEmployee("Петров И.В.");
        System.out.println(" ");
        System.out.println("ФИО сотрудников:");
        employeeBook.printFullName();
        System.out.println(" ");
        employeeBook.calculateSalary();
        employeeBook.findMaxSalary();
        employeeBook.findMinSalary();

        System.out.println(" ");
        employeeBook.indexSalary();

//        анализ по сотрудникам одного отдела
        int departmentNumber = 1;
        int percent = 7;
        System.out.println(" ");
        System.out.println("Список сотрудников отдела " + departmentNumber + ":");
        employeeBook.printAListInTheDepartment(departmentNumber);
        System.out.println(" ");
        employeeBook.findMinSalaryInTheDepartment(departmentNumber);
        employeeBook.findMaxSalaryInTheDepartment(departmentNumber);
        employeeBook.calculateSalaryInTheDepartment(departmentNumber);
        System.out.println(" ");
        employeeBook.indexSalaryInTheDepartment(departmentNumber, percent);
//    сравниваем зарплату сотрудников с заданным числом
        System.out.println(" ");
        double number = 70000;
        System.out.println("Список сотрудников с зарплатой меньше " + number + ":");
        employeeBook.calculateSalaryLessThenANumber(number);
        System.out.println(" ");
        System.out.println("Список сотрудников с зарплатой больше " + number + ":");
        employeeBook.calculateSalaryMoreThenANumber(number);

//     ищем сотрудника
        System.out.println();
        employeeBook.findEmployee("Беднов А.В.");
//      удаляем сотрудника
        employeeBook.removeEmployee("Беднов А.В.");
        employeeBook.findEmployee("Беднов А.В.");
//      добавляем нового сотрудника
        employeeBook.addEmployee("Сташкова А.А.", 4, 78313);

//      меняем зарплату
        double changedSalary = 93214;
        int changeDepartment = 5;
        System.out.println();
        employeeBook.changeEmployee("Сташкова А.А.", changedSalary, changeDepartment);

//      печатаем сотрудников по отделам
        System.out.println();
        employeeBook.printFullNameInTheDepartment();
    }
}