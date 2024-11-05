class SalariedEmployee extends Employee {
    protected double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        setMonthlySalary(monthlySalary);
    }

    // Setter with data validation
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Monthly salary must be positive.");
        }
        this.monthlySalary = monthlySalary;
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.15; // Example 15% bonus
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Bonus: " + calculateBonus());
    }
}
