

package Tools;

import DataAccess.StudentPerCourseDAO;



public class StudentCourseTools {
    
   public static void  printStudentsPerCourse(){
       StudentPerCourseDAO spcDAO = new StudentPerCourseDAO();
       spcDAO.findStudentByCourseId();
   }
   
   
     public static void addStudentToCourse() {
        StudentPerCourseDAO dao = new StudentPerCourseDAO();
        dao.addStudentToCourse();
    }
   
   

}
