/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;


import DataAccess.TrainerDAO;
import Entities.Trainer;
import java.util.List;
import java.util.Scanner;


public class TrainerTools {
    
    
     public static void  addNewTrainer (){
        Scanner scanner = new Scanner (System.in);
        System.out.println("What is the first name of the trainer you want to add ?");
        String fname = scanner.nextLine();
        System.out.println("What is the last name of the trainer you want to add ?");
        String lname = scanner.nextLine();
        System.out.println("What is the subject  of the trainer you want to add ?");
        String subject = scanner.nextLine();


        Trainer newTrainer = new Trainer (fname,lname,subject);
        TrainerDAO tdao = new TrainerDAO();
        
        if(tdao.create(newTrainer)){
            System.out.println("Trainer was added succesfully!\n");
        }
        
        System.out.println("Would you like to add another Trainer? Y/N\n");
        if(Utils.yesOrNo()){
            addNewTrainer();
        }
    }
     
     
     public static void  printAllTrainers (){
        
        TrainerDAO tdao = new TrainerDAO();
        List<Trainer> list = tdao.findAll();
        for (Trainer x : list){
            System.out.println(x.toString());
        }

    }
    

}
