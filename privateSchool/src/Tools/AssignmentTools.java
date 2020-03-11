

package Tools;

import DataAccess.AssignmentDAO;
import Entities.Assignment;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;





public class AssignmentTools {
    
 public static void  addNewAssignment (){
        Scanner scanner = new Scanner (System.in);
        System.out.println("What is the title of the assignment you want to add ?");
        String title = scanner.nextLine();
        System.out.println("What is description of the assignment you want to add ?");
        String desc = scanner.nextLine();
        System.out.println("what is the submission date of the assignment you want add? ex. (dd/MM/yyyy) ");
        LocalDate subdate = Utils.InsertDate();
        System.out.println("What is the oral mark of the assignment you want to add ?");
        while(!scanner.hasNextInt()){
            System.out.println("You must enter a number!");
            scanner.next();
        }
        int oral = scanner.nextInt();
        System.out.println("What is the total mark of the assignment you want to add ?");
        while(!scanner.hasNextInt()){
            System.out.println("You must enter a number!");
            scanner.next();
        }
        int total = scanner.nextInt();
       

        Assignment newAssignment = new Assignment (title,desc,subdate,oral,total);
        AssignmentDAO assDao = new AssignmentDAO();
        
        if(assDao.create(newAssignment)){
            System.out.println("Assignment was added succesfully!\n");
        }
        
        System.out.println("Would you like to add another Assignment? Y/N\n");
        if(Utils.yesOrNo()){
            addNewAssignment();
        }
    }
 
 
 public static void  printAllAssignments (){
        
        AssignmentDAO assdao = new AssignmentDAO();
        List<Assignment> list = assdao.findAll();
        for (Assignment x : list){
            System.out.println(x.toString());
        }

    }
}
