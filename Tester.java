
import java.util.ArrayList;  // Import ArrayList class
import java.util.Date;       // Import Date class
import java.util.List;       // Import List interface
import java.util.Scanner;     // Import Scanner class
import com.mycompany.finproject1.Advisor;  // Import Advisor class from finproject1 package
import com.mycompany.finproject1.Student;  // Import Student class from finproject1 package
import com.mycompany.finproject1.Course;   // Import Course class from finproject1 package

// Tester class
public class Tester {
    private static List<Advisor> advisorArray = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method for menu
    public static void main(String[] args) {
        char choice;

        do {
            System.out.println("Menu:");
            System.out.println("a. Add an advisor");
            System.out.println("b. Edit an advisor");
            System.out.println("c. Delete an advisor");
            System.out.println("d. Display an advisor's basic information and advisees");
            System.out.println("e. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 'a':
                    addAdvisor();
                    break;
                case 'b':
                    editAdvisor();
                    break;
                case 'c':
                    deleteAdvisor();
                    break;
                case 'd':
                    displayAdvisorInfo();
                    break;
                case 'e':
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 'e');
    }

    // Method to add advisor
    private static void addAdvisor() {
        System.out.println("Enter advisor details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        double id = scanner.nextDouble();
        System.out.print("Phone: ");
        double phone = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Hire Date (day): ");
        int hireDay = scanner.nextInt();
        System.out.print("Hire Date (Month): ");
        int hireMonth = scanner.nextInt();
        System.out.print("Hire Date (Year): ");
        int hireYear = scanner.nextInt();
        Date hireDate = new Date(hireDay, hireMonth, hireYear);

        // Creating a list of students for the advisor
        System.out.println("How many Student do you want?");
        int j = scanner.nextInt();
        List<Student> advisees = new ArrayList<>();
        for (int i =0; i < j; i++) {
            advisees.add(createStudent());
        }

        Advisor advisor = new Advisor(name, id, phone, email, address, title, salary, hireDate, advisees);
        advisorArray.add(advisor);
        System.out.println("Advisor added successfully.");
    }

    // Method to create student information
    private static Student createStudent() {
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.println("ID: ");
        double id = scanner.nextDouble();
        System.out.println("Phone: ");
        double phone = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Major: ");
        String major = scanner.nextLine();
        System.out.println("Tuition: ");
        double tuition = scanner.nextDouble();

        //Creating a list of courses for the student
        System.out.println("How many courses do you want?");
        int j = scanner.nextInt();
        List<Course> courses = new ArrayList<>();
        for (int i = 0;i <  j; i++) {
            courses.add(createCourse());
        }

        System.out.println("Admitted Date (day): ");
        int admittedDay = scanner.nextInt();
        System.out.println("Admitted Date (Month): ");
        int admittedMonth = scanner.nextInt();
        System.out.println("Admitted Date (Year): ");
        int admittedYear = scanner.nextInt();
        Date admittedDate = new Date(admittedDay, admittedMonth, admittedYear);

        return new Student(name, id, phone, email, address, major, tuition, courses, admittedDate);
    }

    // Method to create course information
    private static Course createCourse() {
        System.out.println("Enter course details:");
        System.out.print("Course Number: ");
        int courseNumber = scanner.nextInt();
        System.out.print("Credits: ");
        double credits = scanner.nextDouble();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        return new Course(courseNumber, credits, price);
    }
    //
    private static Advisor findAdvisorById(double advisorId) {
        for (Advisor advisor : advisorArray) {
            if (advisor.getId() == advisorId) {
                return advisor;
            }
        }
        return null; //
    }


    // Method to edit advisor details
    private static void editAdvisor() {
        System.out.print("Enter advisor ID to edit: ");
        double advisorId = scanner.nextDouble();
        Advisor selectedAdvisor = findAdvisorById(advisorId);

        if (selectedAdvisor != null) {
            System.out.println("Enter new details:");

            //User input to update advisor details
            System.out.print("Name: ");
            selectedAdvisor.setName(scanner.nextLine());
            System.out.print("ID: ");
            selectedAdvisor.setId(scanner.nextDouble());
            System.out.print("Phone: ");
            selectedAdvisor.setPhone(scanner.nextDouble());
            scanner.nextLine();  // Consume newline character
            System.out.print("Email: ");
            selectedAdvisor.setEmail(scanner.nextLine());
            System.out.print("Address: ");
            selectedAdvisor.setAddress(scanner.nextLine());
            System.out.print("Title: ");
            selectedAdvisor.setTitle(scanner.nextLine());
            System.out.print("Salary: ");
            selectedAdvisor.setSalary(scanner.nextDouble());

            System.out.println("Advisor details updated successfully.");
        } else {
            System.out.println("Advisor not found.");
        }
    }

    //Method to delete advisor details
    private static void deleteAdvisor() {
        System.out.print("Enter advisor ID to delete: ");
        double advisorId = scanner.nextDouble();
        Advisor selectedAdvisor = findAdvisorById(advisorId);

        if (selectedAdvisor != null) {
            advisorArray.remove(selectedAdvisor);
            System.out.println("Advisor deleted successfully.");
        } else {
            System.out.println("Advisor not found.");
        }
    }

    private static void displayAdvisorInfo() { //Method to display advisor information
        System.out.print("Enter advisor ID: ");
        double advisorId = scanner.nextDouble();
        Advisor selectedAdvisor = null;

        for (Advisor advisor : advisorArray) {
            if (advisor.getId() == advisorId) {
                selectedAdvisor = advisor;
                break;
            }
        }

        if (selectedAdvisor != null) {
            System.out.println("Advisor Information:");
            selectedAdvisor.display();
        } else {
            System.out.println("Advisor not found.");
        }
    }
}
/*
Sample output
Menu:
a. Add an advisor
b. Edit an advisor
c. Delete an advisor
d. Display an advisor's basic information and advisees
e. Exit
Enter your choice: a
Enter advisor details:
Name: Professor Tan
ID: 23455
Phone: 2345673
Email: tan@psu.edu
Address: 25 yearsly mill rd
Title: Teacher
Salary: 2000
Hire Date (day): 10
Hire Date (Month): 01
Hire Date (Year): 2002
How many Student do you want?
1
Enter student details:
Name: ID:
1233
Phone:
2673733
Email:
mcu@psu.edu
Address:
25 yearsly mill rd
Major:
cmpsci
Tuition:
15000
How many courses do you want?
1
Enter course details:
Course Number: 100
Credits: 3
Price: 100
Admitted Date (day):
10
Admitted Date (Month):
01
Admitted Date (Year):
2022
Advisor added successfully.
Menu:
a. Add an advisor
b. Edit an advisor
c. Delete an advisor
d. Display an advisor's basic information and advisees
e. Exit
Enter your choice: d
Enter advisor ID: 23455
Advisor Information:
Title: Teacher
Salary: 2000.0
Hired date: Mon Jul 26 00:00:00 EST 1915
Advisees:
Name:
ID: 1233.0
Phone Number: 2673733.0
Email address: mcu@psu.edu
Address: 25 yearsly mill rd
Major: cmpsci
Tuition per Semester: $15000.0
Courses:
Course Number: 100
Number of Credits: 3.0
Price: 100.0
Total Tuition: $15100.0
Menu:
a. Add an advisor
b. Edit an advisor
c. Delete an advisor
d. Display an advisor's basic information and advisees
e. Exit
Enter your choice: b
Enter advisor ID to edit: 23455
Enter new details:
Name: ID: 26222
Phone: 2453773
Email: tan@psu.edu
Address: 28 yearsly mill rd
Title: teacher
Salary: 2000
Advisor details updated successfully.
Menu:
a. Add an advisor
b. Edit an advisor
c. Delete an advisor
d. Display an advisor's basic information and advisees
e. Exit
Enter your choice: c
Enter advisor ID to delete: 243
Advisor not found.
Menu:
a. Add an advisor
b. Edit an advisor
c. Delete an advisor
d. Display an advisor's basic information and advisees
e. Exit
Enter your choice: c
Enter advisor ID to delete: 26222
Advisor deleted successfully.
Menu:
a. Add an advisor
b. Edit an advisor
c. Delete an advisor
d. Display an advisor's basic information and advisees
e. Exit
Enter your choice: d
Enter advisor ID: 26222
Advisor not found.
Menu:
a. Add an advisor
b. Edit an advisor
c. Delete an advisor
d. Display an advisor's basic information and advisees
e. Exit
Enter your choice: e
Exiting the application. Goodbye!

 */