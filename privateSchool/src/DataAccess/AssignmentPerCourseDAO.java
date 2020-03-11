package DataAccess;

import ConnectionDB.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignmentPerCourseDAO extends ConnectionDB {

    private static String insertAssignmentsPerCourse = "insert into assignmentpercourse (aid,cid) values (?,?);";
    private static String findAllAssignmentsPerCourses = "SELECT * FROM assignmentpercourse";
    private static String findAssignmentsByCourseId = "select ass.title, ass.description, ass.subdate, ass.oralmark, ass.totalmark \n"
            + "from assignmentpercourse ac, assignment ass, course c\n"
            + "where ac.aid = ass.id \n"
            + "and ac.cid = c.id\n"
            + "and c.id = ?;";

    public void findAssignmentByCourseId() {
        int courseId = Tools.Utils.typeTheCourseYouWantToAccess();
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(findAssignmentsByCourseId);
            pstm.setInt(1, courseId);
            rs = pstm.executeQuery();
            System.out.println("Assignments are : \n");
            while (rs.next()) {

                String title = rs.getString(1);
                String description = rs.getString(2);
                LocalDate subdate = rs.getDate(3).toLocalDate();
                int oralmark = rs.getInt(4);
                int totalmark = rs.getInt(5);
                System.out.println("title :" + title + " Description : " + description + " subdate : " + subdate + " oralmark :" + oralmark + " totalmark: " + totalmark);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }

    }

    public boolean addAssignmentToCourse() {
        int courseId = Tools.Utils.typeTheCourseYouWantToAccess();
        int assignmentId = Tools.Utils.typeTheAssignmentYouWantToAccess();
        System.out.println("***Course id : " + courseId + ", Assignment id : " + assignmentId + " Was selected!***\n");
        getConnection();
        PreparedStatement pstm = null;
        boolean added = false;
        try {
            pstm = conn.prepareStatement(insertAssignmentsPerCourse);
            pstm.setInt(1, assignmentId);
            pstm.setInt(2, courseId);

            try {

                int result = pstm.executeUpdate();
                if (result > 0) {
                    System.out.println("***Assignment added to course successfully***");
                } else {
                    System.out.println("***Assignment was not added to course***");
                }

            } catch (SQLException e) {
                System.out.println("\n***Incorrect Selection*** Not such a Assignent or course exists. Please try again...\n");
                return addAssignmentToCourse();
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstm);
        }
        return added;
    }
}
