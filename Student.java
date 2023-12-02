package com.mycompany.finproject1;// Student class
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//package com.mycompany.finproject1;
public class Student extends com.mycompany.finproject1.People {
    private String major;            //student's major
    private double tuition;          //tuition per semester
    private List<Course> courses;     //list of courses taken by the student
    private Date admittedDate;       //date when the student was admitted

    //Constructs a Student object
    public Student(String name, double id, double phone, String email, String address, String major, double tuition, List<Course> courses, Date admittedDate) {
        super(name, id, phone, email, address);
        this.major = major;
        this.tuition = tuition;
        this.courses = courses;
        this.admittedDate = admittedDate;
    }

    //Setters and Getters
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Date getAdmittedDate() {
        return admittedDate;
    }

    public void setAdmittedDate(Date admittedDate) {
        this.admittedDate = admittedDate;
    }

    public double calculateTotalTuition() {
        double totalTuition = tuition;
        for (Course course : courses) {
            totalTuition += course.getPrice();
        }
        return totalTuition;
    }

    // Displays the student information
    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + getMajor());
        System.out.println("Tuition per Semester: $" + getTuition());
        System.out.println("Courses:");
        for (Course course : courses) {
            course.display();
        }
        System.out.println("Total Tuition: $" + calculateTotalTuition());
    }
}
