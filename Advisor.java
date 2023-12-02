// Advisor class
package com.mycompany.finproject1;
import java.util.Date;
import java.util.List;


public class Advisor extends com.mycompany.finproject1.People {
    private String title;                //advisor's title
    private double salary;               //advisor's salary
    private Date hireDate;               //date when the advisor was hired
    private List<Student> advisees;      //list of students advised by the advisor

    //Constructs an Advisor object
    public Advisor(String name, double id, double phone, String email, String address, String title, double salary, Date hireDate, List<Student> advisees) {
        super(name, id, phone, email, address);
        this.title = title;
        this.salary = salary;
        this.hireDate = hireDate;
        this.advisees = advisees;
    }

    //Setters and Getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public List<Student> getAdvisees() {
        return advisees;
    }

    public void setAdvisees(List<Student> advisees) {
        this.advisees = advisees;
    }

    // Displays the advisor information
    @Override
    public void display() {
        System.out.println("Title: " + getTitle());
        System.out.println("Salary: " + getSalary());
        System.out.println("Hired date: " + getHireDate());

        System.out.println("Advisees:");
        if (advisees != null) {
            for (Student advisee : advisees) {
                advisee.display();
            }
        } else {
            System.out.println("No advisees.");
        }
    }
}

