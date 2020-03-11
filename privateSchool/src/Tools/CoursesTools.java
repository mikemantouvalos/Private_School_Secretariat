/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import DataAccess.CourseDAO;
import Entities.Course;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CoursesTools {

    public static void addNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the course title of the course you want to add ?");
        String title = scanner.nextLine();
        System.out.println("what is the stream of the course you want to add ?");
        String stream = scanner.nextLine();
        System.out.println("What is the type of the course you want to add ?");
        String type = scanner.nextLine();
        System.out.println("what is the start date of the course you want add? ex. (dd/MM/yyyy) ");
        LocalDate startDate = Utils.InsertDate();
        System.out.println("what is the end date of the course you want add? ex. (dd/MM/yyyy) ");
        LocalDate endDate = Utils.InsertDate();

        Course newCourse = new Course(title, stream, type, startDate, endDate);
        CourseDAO cdao = new CourseDAO();

        if (cdao.create(newCourse)) {
            System.out.println("Student was added succesfully!\n");
        }

        System.out.println("Would you like to add another Course? Y/N\n");
        if (Utils.yesOrNo()) {
            addNewCourse();
        }
    }
    
    
    public static void  printAllCourses (){
        
        CourseDAO cdao = new CourseDAO();
        List<Course> list = cdao.findAll();
        for (Course x : list){
            System.out.println(x.toString());
        }

    }

}
