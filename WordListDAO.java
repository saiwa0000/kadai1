
import java.sql.*;
import java.util.*;


public class WordListDAO {
    public static List<WordList> findAll(){
        Connection con = null;
        List<WordList> list =new ArrayList<WordList>();
        try{
            Class.forName("org.sqlite.JDBC");
            
            con = DriverManager.getConnection("jdbc:sqlite:KADAI1DB");
            
            String sql = "SELECT ID,ENGLISH,JAPANESE,SCORE FROM WORDLIST";
            PreparedStatement pstmt=
                con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("ID");
                String english = rs.getString("ENGLISH");
                String japanese = rs.getString("JAPANESE");
                int score = rs.getInt("SCORE");
                WordList wordlist = new WordList(id,english,japanese,score);
                list.add(wordlist);
            }
            rs.close();
            pstmt.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
        return list;
    }

    
}
