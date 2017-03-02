package Inheritance.P03_Mankind;

public class Worker extends Human{
    private double salary;
    private double workingHours;

    public Worker(String firstName, String lastName, double salary, double workingHours) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setWorkingHours(workingHours);
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if(salary<10){
            throw new IllegalArgumentException("\"Expected value mismatch!Argument: weekSalary");
        }
        this.salary = salary;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    private void setWorkingHours(double workingHours) {
        if(workingHours<1 || workingHours > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    @Override
    protected void setLastName(String lastName) {
        if(lastName.length() <= 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Week Salary: %.2f\n" +
                        "Hours per day: %.2f\n" +
                        "Salary per hour: %.2f\n",
                this.getSalary(), this.getWorkingHours(), this.getSalary() / (this.getWorkingHours() * 7));
    }
}
