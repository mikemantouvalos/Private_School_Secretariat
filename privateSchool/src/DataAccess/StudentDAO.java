package DataAccess;

import ConnectionDB.ConnectionDB;
import Entities.Student;
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


public class StudentDAO extends ConnectionDB implements DaoInterface<Student> {

    private static String insertStudent = "insert into student (fname, lname,dob,tuitionfees) VALUES (?,?,?,?);";
    private static String findStudentById = "SELECT * FROM student where id = ? ";
    private static String findAllstudents = "SELECT * FROM student";

    @Override
    public boolean create(Student s) {
        getConnection();
        PreparedStatement pst = null;
        boolean created = false;

        try {
            pst = conn.prepareStatement(insertStudent);
            pst.setString(1, s.getName());
            pst.setString(2, s.getLastName());
            pst.setDate(3, Date.valueOf(s.getDateOfBirth()));
            pst.setInt(4, s.getTuitionFees());
            int result = pst.executeUpdate();

            if (result > 0) {
                created = true;
            } else {
                System.out.println("values of student : " + s.getName() + " wasn't added to db");
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Student> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(findAllstudents);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String lname = rs.getString(3);
                LocalDate dob = rs.getDate(4).toLocalDate();
                int tuition = rs.getInt(5);
                Student s = new Student(name, lname, dob, tuition);
                s.setCode(id);

                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Student findById(int id) {
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Student s = null;
        try {
            pstm = conn.prepareStatement(findStudentById);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int code = rs.getInt(1);
            String name = rs.getString(2);
            String lname = rs.getString(3);
            LocalDate dob = rs.getDate(4).toLocalDate();
            int tuition = rs.getInt(5);
            
            s = new Student(name, lname, dob, tuition);
            s.setCode(code);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }

        return s;
    }
    
    
     public static void printAllStudents(){
        StudentDAO tdao = new StudentDAO();
        List<Student> list = tdao.findAll();
        for (Student s : list){
            System.out.println(s.toString());
        }
    }
}
