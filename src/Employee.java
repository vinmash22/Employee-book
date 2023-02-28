public class Employee {
    private String fullName;
    private int department;
    private double salary;
    public static int idCounter;
    private int id;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        idCounter++;
        this.id = idCounter;
    }


    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
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
        return id + " ФИО: " + fullName + ", отдел: " + department + ", зарплата: " + salary;
    }
}

