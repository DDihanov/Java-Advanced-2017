package Encapsulation.Lab.P2Salary;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void increaseSalary(int bonus){
        if(this.age > 30){
            this.salary += this.salary * bonus / 100;
        }else{
            this.salary += this.salary * bonus /200;
        }
    }

//    @Override
//    public String toString() {
//        return this.firstName + " " + this.lastName + " is a " + this.age + " years old.";
//    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " get " + this.salary + " leva";
    }
}
