public class PayrollSystemTest {
    public static void main(String[] args) {
        // Create instances of each employee type
        HourlyEmployee hourlyEmployee = new HourlyEmployee(101, "John Doe", "Part-time Instructor", 20.0, 40);
        SalariedEmployee salariedEmployee = new SalariedEmployee(102, "Jane Smith", "Professor", 5000.0);
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(103, "Alice Johnson", "Dean", 12000.0, 20.0);

        // Display details for each employee
        System.out.println("Hourly Employee Details:");
        hourlyEmployee.displayInfo();
        System.out.println("\nSalaried Employee Details:");
        salariedEmployee.displayInfo();
        System.out.println("\nExecutive Employee Details:");
        executiveEmployee.displayInfo();
        
        // Calculate and display total payroll
        double totalPayroll = hourlyEmployee.calculateWeeklySalary() + salariedEmployee.calculateWeeklySalary() + executiveEmployee.calculateWeeklySalary();
        System.out.println("\nTotal Weekly Payroll: " + totalPayroll);
    }
}
