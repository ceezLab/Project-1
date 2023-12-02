// Course class
package com.mycompany.finproject1;
public class Course {
    private int courseNumber;   //course number
    private double credits;     //number of credits for the course
    private double price;       //price of the course

    //Constructs a Course object
    public Course(int courseNumber, double credits, double price) {
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.price = price;
    }

    //Setters and Getters
    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double getPrice() {
        return price;
    }

    //Calculates the price of the course based on the number of credits.
    public void calcPrice() {
        this.price = credits * 500;
    }

    // Displays the course information
    public void display() {
        System.out.println("Course Number: " + courseNumber);
        System.out.println("Number of Credits: " + credits);
        System.out.println("Price: " + getPrice());
    }
}

