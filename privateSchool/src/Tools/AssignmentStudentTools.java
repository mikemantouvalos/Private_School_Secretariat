

package Tools;

import DataAccess.AssignmentsPerStudentPerCourseDAO;


public class AssignmentStudentTools {
    
      public static void printAssignmentsPerStudent() {
        AssignmentsPerStudentPerCourseDAO apsDAO = new AssignmentsPerStudentPerCourseDAO();
        apsDAO.findAssignmentByStudentByCourse();
    }
      
      
    
    

}
