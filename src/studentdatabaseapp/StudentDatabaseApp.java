package studentdatabaseapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        //list of students
        List<Student> students = new ArrayList<>();

        //Ask how many new users we want to add
        Scanner scnr = new Scanner(System.in);
        System.out.print("How many students would you like to add: ");
        int numberStudentsToAdd = scnr.nextInt();

        //Create n number of new students
        for (int i=0; i<numberStudentsToAdd; i++) {
            students.add(new Student());
        }

        //Print list of students and show their info
        for (Student student : students) {
            student.payBalance();
            System.out.println(student.showStudentInfo());
        }

    }

}
