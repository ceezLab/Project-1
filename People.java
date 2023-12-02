// People class
package com.mycompany.finproject1;
public abstract class People implements Payable {
    private String name;        //person's name
    private double id;          //person's ID
    private double phone;       //person's phone number
    private String email;       //person's email address
    private String address;     //person's address

    // Constructs a People object
    public People(String name, double id, double phone, String email, String address) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Gets the person's ID.
    public double getId() {
        return id;
    }

    // Sets the person's ID.
    public void setId(double id) {
        this.id = id;
    }

    // Gets the person's name.
    public String getName() {
        return name;
    }

    // Sets the person's name.
    public void setName(String name) {
        this.name = name;
    }

    // Gets the person's phone number.
    public double getPhone() {
        return phone;
    }

    // Sets the person's phone number.
    public void setPhone(double phone) {
        this.phone = phone;
    }

    // Gets the person's email address.
    public String getEmail() {
        return email;
    }

    // Sets the person's email address.
    public void setEmail(String email) {
        this.email = email;
    }

    // Gets the person's address.
    public String getAddress() {
        return address;
    }

    // Sets the person's address.
    public void setAddress(String address) {
        this.address = address;
    }

    // Overrides the payment method from the Payable interface.
    @Override
    public void payment() {
    }

    // Displays the person's information
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Phone Number: " + getPhone());
        System.out.println("Email address: " + getEmail());
        System.out.println("Address: " + getAddress());
    }
}


