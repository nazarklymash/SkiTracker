package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class Menu {
    private final ArrayList<Student> students;
    private final Scanner scanner;
    private final StudentService studentService;

    public Menu(ArrayList<Student> students, Scanner scanner, StudentService studentService){
        this.students = students;
        this.scanner = scanner;
        this.studentService = studentService;
    }

    

    public void run(){
        boolean isRunning = true;
        while (isRunning){
            studentService.printMenu();
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    studentService.addStudent();
                    break;
                
                case "2":
                    studentService.showStudents();
                    break;

                case "3":
                    studentService.removeStudent();
                    break;

                case "4":
                    studentService.addStudentSession();
                    break;

                case "5":
                    studentService.showStudentSessions();
                    break;

                case "6":
                    studentService.editStudentSession();
                    break;

                case "7":
                    studentService.removeStudentSession();
                    break;

                case "0":
                    isRunning = false;
                    System.out.println("Info: Exiting from menu...");
                    break;

                default:
                    System.out.println("Error: Incorrect choice (1, 2, 3, 4, 5 or 0)");
                    break;
            }
        }
    }
}
