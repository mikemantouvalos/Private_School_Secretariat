package Tools;


import DataAccess.TrainerPerCourseDAO;

public class TrainersCourseTools {

    public static void printTrainersPerCourse() {
        TrainerPerCourseDAO tpcDAO = new TrainerPerCourseDAO();
        tpcDAO.findTrainerByCourseId();
    }
    
    
    public static void addTrainerToCourse() {
        TrainerPerCourseDAO dao = new TrainerPerCourseDAO();
        dao.addTrainerToCourse();
    }
    

}
