package Tools;

import DataAccess.AssignmentDAO;
import DataAccess.CourseDAO;
import DataAccess.StudentDAO;
import DataAccess.TrainerDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Utils {

    public static int typeTheCourseYouWantToAccess() {
        System.out.println("The Available courses are :\n");
        CourseDAO.printAllCourses();
        System.out.println("");
        System.out.println("Choose one of the following Courses by Code... \n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }

    public static int typeTheTrainerYouWantToAccess() {
        System.out.println("The Available trainers are :\n");
        TrainerDAO.printAllTrainers();
        System.out.println("");
        System.out.println("Choose one of the following Trainers by Code... \n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }

    public static int typeTheAssignmentYouWantToAccess() {
        System.out.println("The Available Assignments are :\n");
        AssignmentDAO.printAllAssignments();
        System.out.println("");
        System.out.println("Choose one of the following Assignments by Code... \n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }

    public static int typeTheStudentYouWantToAccess() {
        System.out.println("The Available Students are :\n");
        StudentDAO.printAllStudents();
        System.out.println("");
        System.out.println("Choose  one of the following students by Code... \n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }

    public static boolean yesOrNo() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        if (input.equals("y") || (input.equals("Y"))) {
            return true;
        } else if (input.equals("n") || (input.equals("N"))) {
            return false;
        }
        System.out.println("Invalid input, Type 'y' for yes, 'n' for no.");
        yesOrNo();
        return false;
    }

    public static LocalDate InsertDate() {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(input, formatter);
            return date;
        } catch (DateTimeParseException ex) {
            System.out.println("invalid date, Please try again.. Make sure the format of the date is : (dd/MM/YY) ");
            System.out.println("Type the date :");
            return InsertDate();
        } 
        
    }

}






/*
Exception in thread "main" java.time.format.DateTimeParseException: Text '35/4/1990' could not be parsed at index 3
	at java.base/java.time.format.DateTimeFormatter.parseResolved0(DateTimeFormatter.java:2046)
	at java.base/java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:1948)
	at java.base/java.time.LocalDate.parse(LocalDate.java:428)
	at Tools.Utils.InsertDate(Utils.java:79)
	at Tools.StudentTools.addNewStudent(StudentTools.java:27)
	at Tools.Menu.addMenu(Menu.java:55)
	at Tools.Menu.firstMenu(Menu.java:22)
	at privateschool.PrivateShool.main(PrivateShool.java:145)
C:\Users\mike\Dropbox\programming\java\bootcamp\individual project\privateSchool\nbproject\build-impl.xml:1330: The following error occurred while executing this line:
C:\Users\mike\Dropbox\programming\java\bootcamp\individual project\privateSchool\nbproject\build-impl.xml:936: Java returned: 1
BUILD FAILED (total time: 22 seconds)
*/
