
package DataAccess;

import ConnectionDB.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentPerCourseDAO extends ConnectionDB {

    private static String insertStudentPerCourse = "insert into studentpercourse (sid,cid) values (?,?);";
    private static String findAllStudentsPerCourses = "SELECT * FROM studentpercourse";
    private static String findStudentsByCourseId = "select s.id, s.fname, s.lname, s.dob, s.tuitionFees \n"
            + "from studentpercourse spc, student s, course c\n"
            + "where spc.cid = c.id \n"
            + "and spc.sid = s.id\n"
            + "and c.id = ?;";

    public void findStudentByCourseId() {
        int courseId = Tools.Utils.typeTheCourseYouWantToAccess();
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(findStudentsByCourseId);
            pstm.setInt(1, courseId);
            rs = pstm.executeQuery();
            System.out.println("Students are : \n");
            while (rs.next()) {
                int code = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                LocalDate dob = rs.getDate(4).toLocalDate();
                int tuitionFees = rs.getInt(5);

                System.out.println("id: " + code + ", name: " + fname + ",last name:" + lname + ",date of birth: " + dob + ",tuition Fees: " + tuitionFees);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
    }

    public boolean addStudentToCourse() {
        int courseId = Tools.Utils.typeTheCourseYouWantToAccess();
        int studentId = Tools.Utils.typeTheStudentYouWantToAccess();
        System.out.println("***Course id : " + courseId + ", Student id : " + studentId + " Was selected!***\n");
        getConnection();
        PreparedStatement pstm = null;
        boolean added = false;
        try {
            pstm = conn.prepareStatement(insertStudentPerCourse);
            pstm.setInt(1, studentId);
            pstm.setInt(2, courseId);

            try {

                int result = pstm.executeUpdate();
                if (result > 0) {
                    System.out.println("***Student added to course successfully***");
                } else {
                    System.out.println("***Student was not added to course***");
                }

            } catch (SQLException e) {
                System.out.println("\n***Incorrect Selection*** Not such a student or course exists. Please try again...\n");
                return addStudentToCourse();
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrainerPerCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pstm);
        }
        return added;
    }

    public void findAll() {
        int courseId = Tools.Utils.typeTheCourseYouWantToAccess();
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(findAllStudentsPerCourses);
            pstm.setInt(1, courseId);
            rs = pstm.executeQuery();
            System.out.println("Students are : \n");
            while (rs.next()) {
                int code = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                LocalDate dob = rs.getDate(4).toLocalDate();
                int tuitionFees = rs.getInt(5);

                System.out.println("id: " + code + ", name: " + fname + ",last name:" + lname + ",date of birth: " + dob + ",tuition Fees: " + tuitionFees);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }

    }
}
