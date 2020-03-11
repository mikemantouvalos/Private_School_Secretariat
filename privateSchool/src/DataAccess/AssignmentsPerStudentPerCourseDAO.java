/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import ConnectionDB.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AssignmentsPerStudentPerCourseDAO extends ConnectionDB {
    
  
    private static String findAssignmentsByStudent = "select ass.title, ass.description, ass.subdate, ass.oralmark, ass.totalmark\n" +
                                                     "from studentpercourse spc, assignmentpercourse apc, student s, course c, assignment ass\n" +
                                                     "where spc.cid = apc.cid\n" +
                                                     "and spc.cid = c.id\n" +
                                                     "and apc.aid = ass.id\n" +
                                                     "and spc.sid = s.id\n" +
                                                     "and s.id = ?;";

    public void findAssignmentByStudentByCourse() {
         
        int studentId = Tools.Utils.typeTheStudentYouWantToAccess();
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(findAssignmentsByStudent);
            pstm.setInt(1, studentId);
            rs = pstm.executeQuery();
            System.out.println("Assignments are : \n");
            while (rs.next()) {

                String title = rs.getString(1);
                String description = rs.getString(2);
                LocalDate subdate = rs.getDate(3).toLocalDate();
                int oralmark = rs.getInt(4);
                int totalmark = rs.getInt(5);

                System.out.println("title :" + title + " Description : " +description + " subdate : " + subdate + " oralmark :" + oralmark + " totalmark: " + totalmark );
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
    }

   

}
