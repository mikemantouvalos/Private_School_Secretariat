package DataAccess;

import ConnectionDB.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainerPerCourseDAO extends ConnectionDB {

    private static String insertTrainerPerCourse = "insert into trainerpercourse (tid,cid) values (?,?);";
    private static String findAllTrainerPerCourses = "SELECT * FROM assignment";
    private static String findTrainersByCourseId = "select t.name, t.lname  \n"
            + "from trainerPercourse tp, trainer t, course c \n"
            + "where tp.tid = t.id \n"
            + "and tp.cid = c.id\n"
            + "and c.id = ?";

    public void findTrainerByCourseId() {
        int courseId = Tools.Utils.typeTheCourseYouWantToAccess();
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(findTrainersByCourseId);
            pstm.setInt(1, courseId);
            rs = pstm.executeQuery();
            System.out.println("Trainers are : \n");
            while (rs.next()) {

                String name = rs.getString(1);
                String lname = rs.getString(2);

                System.out.println(name + " " + lname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
    }

    public boolean addTrainerToCourse() {
        int courseId = Tools.Utils.typeTheCourseYouWantToAccess();
        int trainerId = Tools.Utils.typeTheTrainerYouWantToAccess();
         System.out.println("***Course id : " + courseId + ", Trainer id : " + trainerId + " Was selected!***\n");
        getConnection();
        PreparedStatement pstm = null;
        boolean added = false;
        try {
            pstm = conn.prepareStatement(insertTrainerPerCourse);
            pstm.setInt(1, trainerId);
            pstm.setInt(2, courseId);
            
            try {

                int result = pstm.executeUpdate();
                if (result > 0) {
                    System.out.println("***Trainer added to course successfully***");
                } else {
                    System.out.println("***Trainer was not added to course***");
                }

            } catch (SQLException e) {
                System.out.println("\n***Incorrect Selection*** Not such a trainer or course exists. Please try again...\n");
                return addTrainerToCourse();
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
              closeConnections(pstm);
        }
        return added;
    }

//    @Override
//    public boolean create(Assignment ass) {
//        getConnection();
//        PreparedStatement pst = null;
//        boolean added = false;
//
//        try {
//            pst = conn.prepareStatement(insertAssignment);
//            pst.setString(1, ass.getTitle());
//            pst.setString(2, ass.getDescription());
//            pst.setDate(3, Date.valueOf(ass.getSubDateTime()));
//            pst.setInt(4, ass.getOralMark());
//            pst.setInt(5, ass.getTotalMark());
//
//            int result = pst.executeUpdate();
//
//            if (result > 0) {
//                created = true;
//            } else {
//                System.out.println("values of trainer : " + ass.getTitle() + " wasn't added to db");
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closeConnections(pst);
//        }
//        return created;
//    }
}
