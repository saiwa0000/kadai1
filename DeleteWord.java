import java.sql.*;

public class DeleteWord {
    public void Delete(int ID){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlite:KADAI1DB");
            PreparedStatement ps = con.prepareStatement("delete from wordlist where id=?");
            ps.setInt(1, ID);
            ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
