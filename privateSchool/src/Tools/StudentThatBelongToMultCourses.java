
package Tools;

import DataAccess.StudentsWithMoreThanOneCourseDAO;

public class StudentThatBelongToMultCourses {

    public static void printStudentsThatBelongToMoreThanOneCourses() {
        StudentsWithMoreThanOneCourseDAO aaaaDAO = new StudentsWithMoreThanOneCourseDAO();
        aaaaDAO.findAll();
    }

}
