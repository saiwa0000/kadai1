import java.util.Scanner;
import java.sql.*;
public class AddWord {
    public void Add(){
        Scanner scanner = new Scanner()
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlite:pro4db");
            PreparedStatement ps = con.prepareStatement("insert into account values(?,?,?)");
            ps.setInt(1, 1);
            ps.setString(2, "Ogura");
            ps.setInt(3,100);
            ps.executeUpdate();
            PreparedStatement pstmt=
                con.prepareStatement("select * from account where id=?");
            pstmt.setInt(1,1);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name")+":"+rs.getInt("balance"));
            }
            rs.close();
            pstmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
