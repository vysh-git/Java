abstract class Employee {
    protected int employeeId;
    protected String employeeName;
    protected String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public abstract double calculateWeeklySalary();
    
    public double calculateBonus() {
        // Base bonus could be 10% of weekly salary for simplicity
        return calculateWeeklySalary() * 0.10;
    }

    public abstract double calculateAnnualEarnings();

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }
}

