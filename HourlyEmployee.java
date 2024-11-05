class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    // Setters with data validation
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate must be positive.");
        }
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0 || hoursWorked > 168) {
            throw new IllegalArgumentException("Hours worked must be between 0 and 168.");
        }
        this.hoursWorked = hoursWorked;
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.1; // Example 10% bonus
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Bonus: " + calculateBonus());
    }
}
