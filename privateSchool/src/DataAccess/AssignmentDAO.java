package DataAccess;

import ConnectionDB.ConnectionDB;
import Entities.Assignment;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignmentDAO extends ConnectionDB implements DaoInterface<Assignment> {

    private static String insertAssignment = "insert into assignment (title, description, subdate, oralmark, totalmark) VALUES (?,?,?,?,?);";
    private static String findAssignmentById = "SELECT * FROM assignment where id = ? ";
    private static String findAllAssignments = "SELECT * FROM assignment";

    @Override
    public boolean create(Assignment ass) {
        getConnection();
        PreparedStatement pst = null;
        boolean created = false;

        try {
            pst = conn.prepareStatement(insertAssignment);
            pst.setString(1, ass.getTitle());
            pst.setString(2, ass.getDescription());
            pst.setDate(3, Date.valueOf(ass.getSubDateTime()));
            pst.setInt(4, ass.getOralMark());
            pst.setInt(5, ass.getTotalMark());

            int result = pst.executeUpdate();

            if (result > 0) {
                created = true;
            } else {
                System.out.println("values of trainer : " + ass.getTitle()+ " wasn't added to db");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Assignment> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Assignment> list = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(findAllAssignments);
            while (rs.next()) {
                int code = rs.getInt(1);
                String title = rs.getString(2);
                String description = rs.getString(3);
                LocalDate subdate = rs.getDate(4).toLocalDate();
                int oralmark = rs.getInt(5);
                int totalmark = rs.getInt(6);
                Assignment ass = new Assignment(title, description, subdate, oralmark, totalmark);
                ass.setCode(code);

                list.add(ass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Assignment findById(int id) {
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Assignment ass = null;
        try {
            pstm = conn.prepareStatement(findAssignmentById);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int code = rs.getInt(1);
            String title = rs.getString(2);
            String description = rs.getString(3);
            LocalDate subdate = rs.getDate(4).toLocalDate();
            int oralmark = rs.getInt(5);
            int totalmark = rs.getInt(6);
            ass = new Assignment(title,description,subdate,oralmark,totalmark);
            ass.setCode(code);
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }

        return ass;
    }
    
    
     public static void printAllAssignments(){
        AssignmentDAO assdao = new AssignmentDAO();
        List<Assignment> list = assdao.findAll();
        for (Assignment ass : list){
            System.out.println(ass.toString());
        }
    }

}
