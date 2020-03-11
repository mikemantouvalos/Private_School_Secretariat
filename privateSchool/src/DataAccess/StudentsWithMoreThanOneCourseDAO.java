
package DataAccess;

import ConnectionDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentsWithMoreThanOneCourseDAO extends ConnectionDB {

    /* 
   
       Για το συγκεκριμένο, δημιουργήθηκαν 2 views ως εξής :
    
       create view CoursePerStudent as
       select  s.fname, s.lname, s.dob, s.tuitionFees, c.Title
       from student s, studentpercourse spc , course c , assignmentpercourse apc, assignment ass
       where spc.sid = s.id
       and c.id = spc.cid
       and apc.cid = spc.cid
       and apc.aid = ass.id;
    
    
        create view numberOfCoursesPerStudent as
        select fname, lname, dob, tuitionfees, count(*) as number_of_courses
        from CoursePerStudent
        group by fname, lname, dob, tuitionfees;
    
        
     */
    private static String findStudentsWithMultipleCourses = "select * from numberOfCoursesPerStudent where number_of_courses>1;";

    public void findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(findStudentsWithMultipleCourses);
            System.out.println(" Students that have more than one courses : ");
            if (rs.next() == false) {
                System.out.println("***There are no students that have multiple Courses***");
            }
            while (rs.next()) {

                String fname = rs.getString(1);
                String lname = rs.getString(2);
                LocalDate dob = rs.getDate(3).toLocalDate();
                int fees = rs.getInt(4);
                int numCourses = rs.getInt(5);

                System.out.println(fname + " " + lname + ", with date of birth : " + dob
                        + ",  and tuition fees : " + fees + " ----> (" + numCourses + " Courses)");

            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }

    }
}
