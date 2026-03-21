import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final ArrayList<Student> students;
    private final Scanner scanner;

    public Menu(ArrayList<Student> students, Scanner scanner){
        this.students = students;
        this.scanner = scanner;
    }

    public void run(){
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                
                case "2":
                    showStudents();
                    break;

                case "3":
                    removeStudent();
                    break;

                case "4":
                    addStudentSession();
                    break;

                case "5":
                    showStudentSessions();
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

    private void addStudent(){
        try {
        System.out.println("Info: Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Info: Enter age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Info: Enter level: ");
        int level = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Info: Enter objective level: ");
        int objLevel = 0;
        boolean isCorrect = false;
        while (!isCorrect){
            objLevel = Integer.parseInt(scanner.nextLine().trim());
            if (objLevel <= level){
                System.out.println("Warn: Objective level has to be > than current level");
                continue;
            } else {
                isCorrect = true;
            }
        }
        
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setLevel(level);
        student.setObjLevel(objLevel);

        students.add(student);
        System.out.println("Info: Student was successfully added");
        } catch (NumberFormatException e){
            System.out.println("Error: Invalid number format: " + e.getMessage());
        } catch (IllegalArgumentException e ){
            System.out.println("Error: Input error: " + e.getMessage());
        }
    }
    
    private void showStudents(){

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

    private void showStudentSessions(){
        try {

            if (!students.isEmpty()){

                showStudents();
                int id = students.size();
                System.out.println("Info: Enter the ID of student of which you want to see the sessions or 0 to exit show sessions menu: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 0){
                    System.out.println("Info: Exiting show session menu...");
                    return;
                }

                if (choice < 1 || choice > id){
                    System.out.println("Error: Incorrect ID of student (1 <= ID <= " + id + ")");
                    return;
                }
        
                Student student = students.get(choice - 1);
                ArrayList<TrainingSession> sessions = student.getSessions();

                if (sessions.isEmpty()){
                    System.out.println("Info: session list is empty, nothing to show");
                    return;
                }

                System.out.println("== List of sessions for student with ID = " + choice + " ==");
                for (TrainingSession session : sessions){

                    String date = session.getDate();
                    int timeOfSession = session.getTimeOfSession();
                    String typeOfSession = session.getTypeOfSession();
                    String notes = session.getNotes();

                    System.out.println("Date: " + date + ", duration: " + timeOfSession  + ", type of session: " + typeOfSession + ", Notes: " + notes);
                }

            } else {
                System.out.println("Info: List of students is empty, nothing to show");
            }

        } catch (NumberFormatException e ){
            System.out.println("Input error: try again: " + e.getMessage());
        }
    }

    

    private void removeStudent(){
        try {

            if (!students.isEmpty()){

                showStudents();
                int id = students.size();
                System.out.println("Info: Enter the ID of student you want to remove or 0 to exit remove menu: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 0){
                    System.out.println("Info: Exiting remove menu...");
                    return;
                }

                if (choice < 1 || choice > id){
                    System.out.println("Error: Incorrect ID of student (1 <= ID <= " + id + ")");
                    return;
                }
        
                students.remove(choice - 1);

            } else {
                System.out.println("Info: List of students is empty, nothing to remove");
            }

        } catch (NumberFormatException e ){
            System.out.println("Input error: try again: " + e.getMessage());
        }
    }

    private void addStudentSession(){
        try {

            if (!students.isEmpty()){

                showStudents();
                int id = students.size();
                System.out.println("Info: Enter the ID of student to add the session: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 0){
                    System.out.println("Info: Exiting session adding menu...");
                    return;
                }

                if (choice < 1 || choice > id){
                    System.out.println("Error: Incorrect ID of student (1 <= ID <= " + id + ")");
                    return;
                }
        
                Student student = students.get(choice - 1);
                TrainingSession session = new TrainingSession();

                System.out.println("Type the date of session: ");
                String date = scanner.nextLine().trim();
                System.out.println("Type the time durability of session: ");
                int timeOfSession = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("Type the type of session: ");
                String typeOfSession = scanner.nextLine().trim();
                System.out.println("Type the notes (if you want): ");
                String notes = scanner.nextLine().trim();

                session.setDate(date);
                session.setTimeOfSession(timeOfSession);
                session.setTypeOfSession(typeOfSession);
                session.setNotes(notes);

                student.addSession(session);

                System.out.println("Info: Session was added successfully: " + session.toString());

            } else {
                System.out.println("Warn: List of students is empty, cant add the session");
            }

        } catch (NumberFormatException e ){
            System.out.println("Input error: try again: " + e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Input error: try again: " + e.getMessage());
        }
    }


    private void printMenu(){
        System.out.println("\n SkiTracker Menu");
        System.out.println("Type 1 to add the student");
        System.out.println("Type 2 to show the students");
        System.out.println("Type 3 to remove the student");
        System.out.println("Type 4 to create the training session");
        System.out.println("Type 5 to show the training sessions of student");
        System.out.println("Type 0 to exit");
    }
}
