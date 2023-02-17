public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String fullName, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить сотрудника, закончилось место");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                System.out.println(employees[i].getFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size = size - 1;
                return;
            }
        }
    }

    public void findEmployee(String fullName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                System.out.println("Найден сотрудник: " + employees[i]);
                return;
            }
        }
        System.out.println(fullName + " не найден");
    }

    public void changeEmployee(String fullName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                System.out.println("Найден сотрудник: " + employees[i]);
                employees[i].setSalary(94256);
                employees[i].setDepartment(5);
//       тут хотела сделать проверку: если номер отдела, который мы хотим установить, совпадает с текущим номером отдела,
//       то написать, что сотрудник уже в этом отделе, аналогично с зп, думала через if сделать. Не успеваю продумать этот момент:(
                System.out.println("Сотрудник " + employees[i].getFullName() + "переведен в отдел: " + employees[i].getDepartment() + " с  зарплатой: " + employees[i].getSalary());
                return;
            }
        }
        System.out.println(fullName + " не найден");
    }

    public void printAList() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.println(employees[i]);
                break;
            }
            System.out.println(employees[i] + " ");
        }
    }

    public void printFullName() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.println(employees[i].getFullName());
                break;
            }
            System.out.println(employees[i].getFullName() + " ");
        }
    }

    public void calculateSalary() {

        double sum = 0;
        double averageSalary = 0;
        for (Employee element : employees) {

            sum += element.getSalary();
            averageSalary = sum / employees.length;
        }
        System.out.println("Сумма затрат на зарплаты за месяц составила " + sum + " рублей");
        System.out.println("Средняя зарплата за месяц " + averageSalary + " рублей");

    }

    public void calculateMinMaxSalary() {
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

    public void indexSalary() {

        int percent = 7;
        double indexedSalary = 0;
        for (Employee element : employees) {

            indexedSalary = element.getSalary() + element.getSalary() * percent / 100;
            System.out.println("Сотрудник " + element.getFullName() + ", проиндексированная зарплата: " + indexedSalary + " рублей");
        }
    }
//            анализ по сотрудникам одного отдела

    public void calculateMinSalaryInTheDepartment(int departmentNumber) {
        double min = employees[0].getSalary();

        for (Employee element : employees) {
            if (element.getDepartment() == departmentNumber) {
                if (element.getSalary() < min) {
                    min = element.getSalary();
                }
            }
        }
        System.out.println("Минимальная зарплата по отделу " + departmentNumber + " составила " + min + " рублей");
    }

    public void calculateMaxSalaryInTheDepartment(int departmentNumber) {
        double max = employees[0].getSalary();

        for (Employee element : employees) {
            if (element.getDepartment() == departmentNumber) {
                if (element.getSalary() > max) {
                    max = element.getSalary();
                }
            }
        }
        System.out.println("Максимальная зарплата по отделу " + departmentNumber + " составила " + max + " рублей");
    }

    public void printAListInTheDepartment(int departmentNumber) {
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

    public void calculateSalaryInTheDepartment(int departmentNumber) {

        double sum = 0;
        double averageSalary = 0;
        int i = 0;
        for (Employee element : employees) {
            if (element.getDepartment() == departmentNumber) {
                sum += element.getSalary();
                i++;
                averageSalary = sum / i;
            }

        }
        System.out.println("Сумма затрат на зарплаты за месяц составила " + sum + " рублей");
        System.out.println("Средняя зарплата за месяц " + averageSalary + " рублей");

    }

    public void indexSalaryInTheDepartment(int departmentNumber, int percent) {

        double indexedSalary = 0;
        for (Employee element : employees) {
            if (element.getDepartment() == departmentNumber) {

                indexedSalary = element.getSalary() + element.getSalary() * percent / 100;
                System.out.println("Сотрудник " + element.getFullName() + ", проиндексированная зарплата: " + indexedSalary + " рублей");
            }
        }
    }

    //    сравниваем зарплату сотрудников с заданным числом
    public void calculateSalaryLessThenANumber(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < number) {
                System.out.println(employees[i].getId() + ". Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
            }
        }
    }

    public void calculateSalaryMoreThenANumber(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > number) {
                System.out.println(employees[i].getId() + ". Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
            }
        }
    }

    //         печатаем список сотрудников по отделам
    public void printFullNameInTheDepartment() {
        int departmentNumber = 1;
        while (departmentNumber < 6) {
            System.out.println();
            System.out.println("Список сотрудников отдела: " + departmentNumber);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartment() == departmentNumber) {

                    if (i == employees.length - 1) {
                        System.out.println("Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
                        break;
                    }
                    System.out.println("Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
                }
            }
            departmentNumber++;
        }
    }
}
