package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;
import util.Helpers;
import model.TrainingSession;

public class StudentService {
    private Scanner scanner;
    private ArrayList<Student> students;

    public StudentService(Scanner scanner, ArrayList<Student> students){
        this.scanner = scanner;
        this.students = students;
    }
    
    public void addStudent(){
        try {
        System.out.println("Info: Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Info: Enter age: ");
        int age = Helpers.readInt(scanner);

        System.out.println("Info: Enter level: ");
        int level = Helpers.readInt(scanner);

        System.out.println("Info: Enter objective level: ");
        int objLevel = 0;
        boolean isCorrect = false;
        while (!isCorrect){
            objLevel = Helpers.readInt(scanner);
            if (objLevel <= level){
                System.out.println("Warn: Objective level has to be > than current level");
                continue;
            } else {
                isCorrect = true;
            }
        }
        
        Student student = new Student(age, name, level, objLevel);

        students.add(student);
        System.out.println("Info: Student was successfully added");
        } catch (IllegalArgumentException e ){
            System.out.println("Error: Input error: " + e.getMessage());
        }
    }
    
    public void showStudents(){

        if (!students.isEmpty()){   
            int id = 0;
            System.out.println("Info: List of students: ");

            for (Student student : students){

                String name = student.getName();
                int age = student.getAge();
                int level = student.getLevel();
                int objLevel = student.getObjLevel();
                
                System.out.println("Info: ID: " + (id + 1) + ", Name: " + name + ", Age: " + age + ", Level: " + level + ", objective level: " + objLevel);
                id++;
            }

        } else {

            System.out.println("Info: There is no students to show");

        }
    }

    public void showStudentSessions(){
            if (!students.isEmpty()){

                showStudents();
                int choice = Helpers.readChoice(students.size(), scanner);
                if (choice < 0){
                    return;
                }
        
                Student student = students.get(choice - 1);
                ArrayList<TrainingSession> sessions = student.getSessions();

                printSessions(sessions);

            } else {
                System.out.println("Info: List of students is empty, nothing to show");
            }
    }

    

    public void removeStudent(){
            if (!students.isEmpty()){

                showStudents();
                int choice = Helpers.readChoice(students.size(), scanner);
                if (choice < 0){
                    return;
                }
        
                students.remove(choice - 1);

            } else {
                System.out.println("Info: List of students is empty, nothing to remove");
            }

    }

    public void addStudentSession(){
        try{

            if (!students.isEmpty()){

                showStudents();
                int choice = Helpers.readChoice(students.size(), scanner);
                if (choice < 0){
                    return;
                }
        
                Student student = students.get(choice - 1);
                

                System.out.println("Type the date of session: ");
                String date = scanner.nextLine().trim();
                System.out.println("Type the time durability of session: ");
                int timeOfSession = Helpers.readInt(scanner);
                System.out.println("Type the type of session: ");
                String typeOfSession = scanner.nextLine().trim();
                System.out.println("Type the notes (if you want): ");
                String notes = scanner.nextLine().trim();

                TrainingSession session = new TrainingSession(date, timeOfSession, typeOfSession, notes);

                student.addSession(session);

                System.out.println("Info: Session was added successfully: " + session.toString());

            } else {
                System.out.println("Warn: List of students is empty, cant add the session");
            
            }
            } catch (IllegalArgumentException e){
            System.out.println("Input error: try again: " + e.getMessage());
        }
    }

    public void printMenu(){
        System.out.println("\n SkiTracker Menu");
        System.out.println("Type 1 to add the student");
        System.out.println("Type 2 to show the students");
        System.out.println("Type 3 to remove the student");
        System.out.println("Type 4 to create the training session");
        System.out.println("Type 5 to show the training sessions of student");
        System.out.println("Type 6 to edit the session of student");
        System.out.println("Type 0 to exit");
    }

    public void printSessions(ArrayList<TrainingSession> sessions){
        if (sessions.isEmpty()){
            System.out.println("Info: session list is empty, nothing to show");
            return;
        }
        int id = 0;
        System.out.println("== List of sessions of student ==");
        for (TrainingSession session : sessions){

            String date = session.getDate();
            int timeOfSession = session.getTimeOfSession();
            String typeOfSession = session.getTypeOfSession();
            String notes = session.getNotes();
            id++;
            System.out.println("ID: " + id + ", Date: " + date + ", duration: " + timeOfSession  + ", type of session: " + typeOfSession + ", Notes: " + notes);
        }
    }

    public void editStudentSession(){
        try {
          if (!students.isEmpty()){
            showStudents();
            int choice = Helpers.readChoice(students.size(), scanner);
            if (choice == -1){
                System.out.println("Error: Wrong ID was typed");
                return;
            }
            Student student = students.get(choice-1);

            ArrayList<TrainingSession> sessions = student.getSessions();
            printSessions(sessions);
            if (sessions.isEmpty()){
                return;
            }
            System.out.println("Info: type the id of session: ");
            choice = Helpers.readChoice(sessions.size(), scanner);
            if (choice == -1){
                System.out.println("Error: Wrong ID was typed");
                return;
            }
            TrainingSession chosenSession = sessions.get(choice - 1);
            
            boolean inMenu = true;
            int loopChoice;
            while(inMenu){

                System.out.println("Choose what you want to edit: ");
                System.out.println("Type 1 to edit date");
                System.out.println("Type 2 to edit durability");
                System.out.println("Type 3 to edit type of session");
                System.out.println("Type 4 to edit notes");
                System.out.println("Type 5 to exit the session edit menu");

                loopChoice = Helpers.readChoice(5, scanner);
                if (loopChoice == -1){
                    System.out.println("Error: Wrong ID was typed");
                    return;
                }
                switch (loopChoice) {

                    case 1:
                        chosenSession.setDate(scanner.nextLine());
                        break;

                    case 2: 
                        chosenSession.setTimeOfSession(Helpers.readInt(scanner));
                        break;
                    
                    case 3:
                        chosenSession.setTypeOfSession(scanner.nextLine());
                        break;

                    case 4:
                        chosenSession.setNotes(scanner.nextLine());
                        break;
                    
                    case 5:
                        inMenu = false;
                        break;
                    
                    default:
                        System.err.println("Error: the choice is from 1 to 5");
                        break;
                }
                
            }
        } else {
            System.out.println("Warn: Nothing to choose, there is no students");
            return;
        }
        } catch (NumberFormatException e){

            System.err.println("Error: incorrect number format: " + e.getMessage());

        } catch (IllegalArgumentException e){

            System.err.println("Error: Illegal argument was typed: " + e.getMessage());
        
        }
        
    
        
    }

    public void removeStudentSession(){
            if (!students.isEmpty()){

                showStudents();
                int choice = Helpers.readChoice(students.size(), scanner);
                if (choice == -1){
                    System.err.println("Error: Incorrect ID");
                    return;
                }

                Student student = students.get(choice - 1);

                if (student.getSessions().isEmpty()){
                    System.out.println("Warn: The list of sessions is empty, nothing to remove");
                    return;
                }

                printSessions(student.getSessions());

                choice = Helpers.readChoice(student.getSessions().size(), scanner);
                
                if (choice == -1){
                    System.err.println("Error: Incorrect ID");
                    return;
                }

                student.getSessions().remove(choice-1);
                System.out.println("Info: Session was successfully deleted");

            } else {
                System.out.println("Warn: the list of students is empty, nothing to remove");
            }
    }
}
