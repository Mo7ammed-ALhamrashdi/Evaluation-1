package entities;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private String subject;
    private int experienceYears;
    private double salary;
    private List<String> classesTaught;

    public Teacher(String id , String firstName , String lastName,
                   String dateOfBirth, String gender,
                   String phoneNumber, String email, String address,
                   String subject, int experienceYears,
                   double salary) {

        super(id, firstName, lastName,
                dateOfBirth, gender,
                phoneNumber, email, address);

        this.subject = subject;
        setExperienceYears(experienceYears);
        this.salary = salary;
        this.classesTaught = new ArrayList<>();
    }

    public String getSubject() {
        return subject;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getClassesTaught() {
        return classesTaught;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setExperienceYears(int experienceYears) {

        if (experienceYears < 0) {

            System.out.println(
                    "Experience cannot be below 0. Keeping it at 0."
            );

            this.experienceYears = 0;
            return;
        }

        this.experienceYears = experienceYears;
    }

    public void addClass(String className) {
        classesTaught.add(className);
    }

    // Overloading
    public void updateSalary(double salary) {
        setSalary(salary);
    }

    // Overloading
    public void updateSalary(double salary , String reason) {
        setSalary(salary);

        System.out.println(
                "Salary updated. Reason: " + reason
        );
    }

    // Overriding
    @Override
    public void displayInfo() {

        System.out.println(
                "Teacher: " +
                        getFirstName() + " " +
                        getLastName() +
                        " | subject: " +
                        subject +
                        " | experience: " +
                        experienceYears +
                        " years"
        );
    }
}