package DataAccess;

import ConnectionDB.ConnectionDB;
import Entities.Course;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


public class CourseDAO extends ConnectionDB implements DaoInterface<Course> {

    private static String insertCourse = "insert into course (title, Stream,type,startDate,endDate) VALUES (?,?,?,?,?);";
    private static String findCourseById = "SELECT * FROM course where id = ? ";
    private static String findAllCourses = "SELECT * FROM course";

    @Override
    public boolean create(Course c) {
        
        getConnection();
        PreparedStatement pst = null;
        boolean created = false;

        try {
            pst = conn.prepareStatement(insertCourse);
            pst.setString(1, c.getTitle());
            pst.setString(2, c.getType());
            pst.setString(3, c.getTitle());
            pst.setDate(4, Date.valueOf(c.getStartDate()));
            pst.setDate(5, Date.valueOf(c.getEmdDate()));
            int result = pst.executeUpdate();

            if (result > 0) {
                created = true;
            } else {
                System.out.println("values of student : " + c.getTitle() + " wasn't added to db");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Course> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Course> list = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(findAllCourses);
            while (rs.next()) {
                int code = rs.getInt(1);
                String title = rs.getString(2);
                String stream = rs.getString(3);
                String type = rs.getString(4);
                LocalDate startdate = rs.getDate(5).toLocalDate();
                LocalDate enddate = rs.getDate(6).toLocalDate();

                Course c = new Course(title, stream, type, startdate, enddate);
                c.setCode(code);

                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Course findById(int id) {
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Course c = null;
        try {
            pstm = conn.prepareStatement(findCourseById);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int code = rs.getInt(1);
            String title = rs.getString(2);
            String stream = rs.getString(3);
            String type = rs.getString(4);
            LocalDate startdate = rs.getDate(5).toLocalDate();
            LocalDate enddate = rs.getDate(6).toLocalDate();

            c = new Course(title, stream, type, startdate, enddate);
            c.setCode(code);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }

        return c;
    }
    
    
    
    public static void printAllCourses(){
        CourseDAO cdao = new CourseDAO();
        List<Course> list = cdao.findAll();
        for (Course c : list){
            System.out.println(c.toString());
        }
    }
    
}
