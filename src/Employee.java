public class Employee {
    private String employee;
    private int department;
    private double salary;
    public static int idCounter;
    private int id;

    public Employee(String employee, int department, double salary) {
        this.employee = employee;
        this.department = department;
        this.salary = salary;
        idCounter++;
        this.id = getIdCounter();
    }

    private int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getEmployee() {
        return employee;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return id + " ФИО: " + employee + ", отдел: " + department + ", зарплата: " + salary;
    }
}

