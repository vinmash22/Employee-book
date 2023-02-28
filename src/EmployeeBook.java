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
            if (employees[i].getFullName().equals(fullName)){
                System.out.println("Найден сотрудник: " + employees[i]);
                return;
            }
        }
        System.out.println(fullName + " не найден");
    }

    public void changeEmployee(String fullName, double changedSalary, int changeDepartment) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                System.out.println("Найден сотрудник: " + employees[i]);
                employees[i].setSalary(changedSalary);
                employees[i].setDepartment(changeDepartment);
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
            if (element != null) {

                sum += element.getSalary();
                averageSalary = sum / employees.length;
            }
        }
        System.out.println("Сумма затрат на зарплаты за месяц составила " + sum + " рублей");
        System.out.println("Средняя зарплата за месяц " + averageSalary + " рублей");

    }

    public void findMaxSalary() {
        Employee empWithMinSalary = null;
        for (Employee element : employees) {
            if (element != null && empWithMinSalary == null || element != null && element.getSalary() > empWithMinSalary.getSalary()) {
                empWithMinSalary = element;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + empWithMinSalary + " рублей");
    }

    public void findMinSalary() {
        Employee empWithMinSalary = null;
        for (Employee element : employees) {
            if (element != null && (empWithMinSalary == null || element.getSalary() < empWithMinSalary.getSalary())) {
                empWithMinSalary = element;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + empWithMinSalary + " рублей");
    }

    public void indexSalary() {

        int percent = 7;
        double indexedSalary = 0;
        for (Employee element : employees) {
            if (element != null) {

                indexedSalary = element.getSalary() + element.getSalary() * percent / 100;
                element.setSalary(indexedSalary);
                System.out.println("Сотрудник " + element.getFullName() + ", проиндексированная зарплата: " + element.getSalary() + " рублей");
            }
        }
    }

    //            анализ по сотрудникам одного отдела
    public void findMaxSalaryInTheDepartment(int departmentNumber) {
        Employee empWithMinSalary = null;
        for (Employee element : employees) {
            if (element != null && element.getDepartment() == departmentNumber) {
                if (empWithMinSalary == null || element.getSalary() > empWithMinSalary.getSalary()) {
                    empWithMinSalary = element;
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + empWithMinSalary + " рублей");
    }

    public void findMinSalaryInTheDepartment(int departmentNumber) {
        Employee empWithMinSalary = null;
        for (Employee element : employees) {
            if (element != null && element.getDepartment() == departmentNumber) {
                if (empWithMinSalary == null || element.getSalary() < empWithMinSalary.getSalary()) {
                    empWithMinSalary = element;
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + empWithMinSalary + " рублей");
    }


    public void printAListInTheDepartment(int departmentNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {
                System.out.println("Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
            }
        }
    }

    public void calculateSalaryInTheDepartment(int departmentNumber) {

        double sum = 0;
        double averageSalary = 0;
        int i = 0;
        for (Employee element : employees) {
            if (element != null && element.getDepartment() == departmentNumber) {
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
            if (element != null && element.getDepartment() == departmentNumber) {

                indexedSalary = element.getSalary() + element.getSalary() * percent / 100;
                element.setSalary(indexedSalary);
                System.out.println("Сотрудник " + element.getFullName() + ", проиндексированная зарплата: " + element.getSalary() + " рублей");
            }
        }
    }

    //    сравниваем зарплату сотрудников с заданным числом
    public void calculateSalaryLessThenANumber(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < number) {
                System.out.println(employees[i].getId() + ". Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
            }
        }
    }

    public void calculateSalaryMoreThenANumber(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > number) {
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
                if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {

                    System.out.println("Сотрудник " + employees[i].getFullName() + ", зарплата: " + employees[i].getSalary() + " рублей");
                }
            }
            departmentNumber++;
        }
    }
}
