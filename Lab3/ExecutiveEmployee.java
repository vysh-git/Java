class ExecutiveEmployee extends SalariedEmployee {
   private double bonusPercentage;

   public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
       super(employeeId, employeeName, designation, monthlySalary);
       if (bonusPercentage < 0 || bonusPercentage > 100) {
           throw new IllegalArgumentException("Bonus percentage must be between 0 and 100.");
       }
       this.bonusPercentage = bonusPercentage;
   }

   @Override
   public double calculateBonus() {
       double baseBonus = super.calculateBonus(); // Using super to call the base class bonus
       return baseBonus + (monthlySalary * 12 * (bonusPercentage / 100));
   }

   @Override
   public void displayInfo() {
       super.displayInfo();
       System.out.println("Bonus Percentage: " + bonusPercentage + "%");
       System.out.println("Total Bonus: " + calculateBonus());
   }
}

