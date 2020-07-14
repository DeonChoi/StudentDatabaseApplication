package studentdatabaseapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private String fullName;
    private String gradeLevel;
    private String gradeLevelAsWord;
    private String studentId;
    private static int idCounter = 1001;
    private String coursesEnrolled = "";
    private int balance = 0;
    private static int courseCost = 600;

    //Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.firstName = scnr.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = scnr.nextLine();

        System.out.print("1 = Freshman\n2 = Sophomore\n3 = Junior\n4 = Senior\nEnter student grade level: ");
        this.gradeLevel = scnr.nextLine();

        setFullName();
        setStudentId();
        setGradeLevelAsWord();
        setCoursesEnrolled();

    }

    //Set full name
    public void setFullName() {
        this.fullName = this.firstName + " " + this.lastName;
    }

    //Set grade level as string -> freshman, sophomore, junior, senior
    public void setGradeLevelAsWord() {
        switch(this.gradeLevel) {
            case "1":
                this.gradeLevelAsWord = "Freshman";
                break;
            case "2":
                this.gradeLevelAsWord = "Sophomore";
                break;
            case "3":
                this.gradeLevelAsWord = "Junior";
                break;
            case "4":
                this.gradeLevelAsWord = "Senior";
                break;
            default:
                this.gradeLevelAsWord = "";
                break;
        }
    }

    //Generate an ID
    private void setStudentId() {
        //Grade Level + idCounter as a String
        this.studentId =  this.gradeLevel + "" + this.idCounter;
        idCounter++;
    }

    //Enroll in Courses
    public void setCoursesEnrolled() {
        //Get inside a loop, user hits 0 when done enrolling
        Scanner scnr = new Scanner(System.in);
        String courseToEnroll;

        do {
            System.out.print("Enter the course to enroll in, Q to quit: ");
            courseToEnroll = scnr.nextLine();

            if (!courseToEnroll.equals("Q")) {
                this.coursesEnrolled += "\n" + courseToEnroll;
                this.balance += this.courseCost;
            } else {
                break;
            }

        } while (!courseToEnroll.equals("Q"));

        System.out.println("\n");

    }

    //View Balance
    public int getBalance() {
        return this.balance;
    }

    //Pay tuition
    public void payBalance() {
        System.out.println(this.fullName + ", your current balance is $" + getBalance());

        Scanner scnr = new Scanner(System.in);
        System.out.print("How much would you like to apply towards your balance: $");
        int payment = scnr.nextInt();

        this.balance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        System.out.println("Your remaining balance is $" + this.balance);
    }

    //Show info of student: should see their name, ID, courses enrolled, and balance.
    public String showStudentInfo() {
        String info = "Student: " + this.fullName + "\n" +
                    "Grade Level: " + this.gradeLevelAsWord + "\n" +
                "Student ID: " + this.studentId + "\n" +
                "Enrolled In: " + this.coursesEnrolled + "\n" +
                "Student Balance: $" + this.balance + "\n";
        return info;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public static int getIdCounter() {
        return idCounter;
    }

}
