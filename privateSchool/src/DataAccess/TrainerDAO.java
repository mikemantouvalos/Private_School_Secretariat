

package DataAccess;

import ConnectionDB.ConnectionDB;
import Entities.Trainer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TrainerDAO extends ConnectionDB implements DaoInterface<Trainer>  {

    private static String insertTrainer = "insert into trainer (name,lname,subject) VALUES (?,?,?);";
    private static String findTrainerById = "SELECT * FROM trainer where id = ? ";
    private static String findAllTrainers = "SELECT * FROM trainer";

    @Override
    public boolean create(Trainer t) {
        getConnection();
        PreparedStatement pst = null;
        boolean created = false;

        try {
            pst = conn.prepareStatement(insertTrainer);
            pst.setString(1, t.getName());
            pst.setString(2, t.getLastName());
            pst.setString(3, t.getSubject());
            int result = pst.executeUpdate();

            if (result > 0) {
                created = true;
            } else {
                System.out.println("values of trainer : " + t.getName() + " wasn't added to db");
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;
    }

    @Override
    public List<Trainer> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Trainer> list = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(findAllTrainers);
            while (rs.next()) {
                int code = rs.getInt(1);
                String name = rs.getString(2);
                String lname = rs.getString(3);
                String subject = rs.getString(4);
                Trainer t = new Trainer(name, lname, subject);
                t.setCode(code);

                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return list;
    }

    @Override
    public Trainer findById(int id) {
        getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Trainer t = null;
        try {
            pstm = conn.prepareStatement(findTrainerById);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int code = rs.getInt(1);
                String name = rs.getString(2);
                String lname = rs.getString(3);
                String subject = rs.getString(4);
                 t = new Trainer(name, lname, subject);
            t.setCode(id);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }

        return t;
    }
    
    
    
    public static void printAllTrainers(){
        TrainerDAO tdao = new TrainerDAO();
        List<Trainer> list = tdao.findAll();
        for (Trainer t : list){
            System.out.println(t.toString());
        }
    }
}
