/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

import DataAccess.StudentDAO;
import Entities.Student;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class StudentTools {
    
    public static void  addNewStudent (){
        Scanner scanner = new Scanner (System.in);
        System.out.println("What is the first name of the student you want to add ?");
        String fname = scanner.nextLine();
        System.out.println("What is the last name of the student you want to add ?");
        String lname = scanner.nextLine();
        System.out.println("What is the tuition fees of the student you want to add ?");
        while(!scanner.hasNextInt()){
            System.out.println("You must enter a number!");
            scanner.next();
        }
        int fees = scanner.nextInt();
        System.out.println("what is the date of birth of the student you want add? ex. (dd/MM/yyyy) ");
        LocalDate dobLocalDate = Utils.InsertDate();
      
        Student newStudent = new Student (fname,lname,dobLocalDate,fees);
        StudentDAO sdao = new StudentDAO();
        
        if(sdao.create(newStudent)){
            System.out.println("Student was added succesfully!\n");
        }
        
        System.out.println("Would you like to add another Student? Y/N\n");
        if(Utils.yesOrNo()){
            addNewStudent();
        }
    }
    
    public static void  printAllStudents (){
        
        StudentDAO sdao = new StudentDAO();
        List<Student> list = sdao.findAll();
        for (Student x : list){
            System.out.println(x.toString());
        }

    }
    
    

}