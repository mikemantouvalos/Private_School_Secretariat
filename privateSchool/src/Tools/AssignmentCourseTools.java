

package Tools;

import DataAccess.AssignmentPerCourseDAO;


public class AssignmentCourseTools {
    
    public static void printAssignmentsPerCourse() {
        AssignmentPerCourseDAO apcDAO = new AssignmentPerCourseDAO();
        apcDAO.findAssignmentByCourseId();
    }
    
    
    public static void addAssignmentToCourse() {
        AssignmentPerCourseDAO dao = new AssignmentPerCourseDAO();
        dao.addAssignmentToCourse();
    }
    
    

}
