

package Tools;

import java.util.Scanner;


public class Menu {
    
    
     public static void firstMenu(Scanner sc){
        System.out.println("Welcome to Bootcamp! \n");
        System.out.println(
                "\n '1' To add data." +
                "\n '2' To print data."); 

        
        while(!sc.hasNextInt()){
            System.out.println("You must enter a number!");
            sc.next();
        }
        int input = sc.nextInt();

       switch (input) {
            case 1:
                Menu.addMenu(sc);
                break;
            case 2:
                Menu.printMenu(sc);
                break;
            default:
                System.out.println("Wrong input, try again...");
                firstMenu(sc);
                break;

        }
    }
     
     
     public static void addMenu(Scanner sc) {
       
        System.out.println( "\n"+
                " choose 1 to add Courses  \n" +
                " choose 2 to add Students  \n" +
                " choose 3 to add Assignments  \n" +
                " choose 4 to add Trainers  \n" +
                " choose 5 to add a Student to a Course  \n" +
                " choose 6 to add a Trainer to a Course  \n" +
                " choose 7 to add an Assignment to a Course  \n" +
                " choose 0 to return to Main menu.  \n");
        
        while(!sc.hasNextInt()){
            System.out.println("You must enter a number!");
            sc.next();
        }
        int input = sc.nextInt();

        switch (input) {
            case 1:
                CoursesTools.addNewCourse();
                addMenu(sc);
                break;
             case 2:
                StudentTools.addNewStudent();
                addMenu(sc);
                break;
            case 3:
                AssignmentTools.addNewAssignment();
                addMenu(sc);
                break;
            case 4:
                TrainerTools.addNewTrainer();
                addMenu(sc);
                break;
            case 5:
                StudentCourseTools.addStudentToCourse();
                addMenu(sc);
                break;
            case 6:
                TrainersCourseTools.addTrainerToCourse();
                addMenu(sc);
                break;
            case 7:
                AssignmentCourseTools.addAssignmentToCourse();
                addMenu(sc);
                break;    
            case 0:
                firstMenu(sc);
                break;
            default:
                System.out.println("Wrong input, try again...");
                addMenu(sc);
                break;

        }
     }
        

        
        public static void printMenu(Scanner sc) {
            
        System.out.println("\n" + "choose '1' to print all the Courses\n" +
                "choose '2' to print all the Students \n" +
                "choose '3' to print all the Trainers \n" +
                "choose '4' to print all the Assignments \n" +
                "choose '5  to print all Students Per Course \n" +
                "choose '6' to print all Trainers Per Course  \n" +
                "choose '7' to print all Assignments Per Course  \n" +
                "choose '8' to print all Assignments Per Student  \n" +
                "choose '9' to print all the students that have more than one Course. \n" +
                "choose '0' to return to first menu");

        while(!sc.hasNextInt()){
            System.out.println("You must enter a number!");
            sc.next();
        }
        int input = sc.nextInt();

        switch (input) {
            case 1:
                CoursesTools.printAllCourses();
                printMenu(sc);
                break;
            case 2:
                StudentTools.printAllStudents();
                printMenu(sc);
                break;
            case 3:
                 TrainerTools.printAllTrainers();
                printMenu(sc);
                break;
            case 4:
                 AssignmentTools.printAllAssignments();
                printMenu(sc);
                break;
            case 5:
                StudentCourseTools.printStudentsPerCourse();
                printMenu(sc);
                break;
            case 6:
                TrainersCourseTools.printTrainersPerCourse();
                printMenu(sc);
                break;
            case 7:
                AssignmentCourseTools.printAssignmentsPerCourse();
                printMenu(sc);
                break;
            case 8:
                AssignmentStudentTools.printAssignmentsPerStudent();
                printMenu(sc);
                break;
            case 9:
                StudentThatBelongToMultCourses.printStudentsThatBelongToMoreThanOneCourses();
                printMenu(sc);
                break;
            case 0:
                firstMenu(sc);
                break;
            default:
                System.out.println("wrong input, try again...");
                printMenu(sc);
        }

    }
        

}

