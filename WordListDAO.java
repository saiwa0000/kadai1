
import java.sql.*;
import java.util.*;

/*メソッド一覧
findAll()　　　　　　　　　データベースをリストに入れて返す。
Add(int, String, String)　　データベースに要素を追加する。
AddList(List<WordList>)　　リストから足りないものをデータベースに追加する。
maxID()　　　　　　　　　　IDの最大値を返す。
Delete(int)　　　　　　　　指定したIDの要素を消してデータベースのIDを詰める。
Sort()　　　　　　　　　　データベースをIDでソートして空きを詰める。
SaveAll(List<WordList>)　　データベースにリストの要素を完全に保存する。　
Save(List<WordList>)　　　　データベースにリストでの変更を適応させる。
 */

public class WordListDAO {
    public static List<WordList> findAll(){
        Connection con = null;
        List<WordList> list = new ArrayList<WordList>();
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
    
    public static void Add(int ID, String English, String Japanese){
        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlite:KADAI1DB");
            PreparedStatement ps = con.prepareStatement("insert into wordlist values(?,?,?,0)");
            if(checkID(ID)){
                ps.setInt(1, ID);
            }else{
                ps.setInt(1, maxID()+1);
            }
            ps.setString(2, English);
            ps.setString(3, Japanese);
            ps.executeUpdate();
            
            ps.close();
            con.close();
            Sort();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<WordList> AddList(List<WordList> wlist){
        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlite:KADAI1DB");

            for(int i=0; i<wlist.size(); i++){
                if(checkList(wlist.get(i))){
                    PreparedStatement pstmt = con.prepareStatement("insert into wordlist values(?,?,?,?)");
                    if(checkID(wlist.get(i).id)){
                        pstmt.setInt(1, wlist.get(i).id);
                    }else{
                        pstmt.setInt(1, maxID() + 1);
                        wlist.get(i).id = maxID() + 1;
                    }
                    pstmt.setString(2, wlist.get(i).english);
                    pstmt.setString(3, wlist.get(i).japanese);
                    pstmt.setInt(4, wlist.get(i).score);
                    pstmt.executeUpdate();
                    
                    pstmt.close();
                }
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return wlist;
    }

    public static int maxID(){
        List<WordList> wlist = WordListDAO.findAll();
        int max = wlist.get(wlist.size()-1).id;

        for(int i=0; i<wlist.size(); i++){
            if(wlist.get(i).id > max)
                max = wlist.get(i).id;
        }

        return max;
    }

    public static boolean checkID(int n){
        List<WordList> wlist = WordListDAO.findAll();
        for(int i=0; i<wlist.size(); i++){
            if(wlist.get(i).id == n)
                return false;
        }
        return true;
    }

    public static boolean checkList(WordList w){
        List<WordList> wlist = WordListDAO.findAll();
        for(int i=0; i<wlist.size(); i++){
            int count = 0;
            if(wlist.get(i).id == w.id)
                count++;
            else if(wlist.get(i).english.equals(w.english))
                count++;
            else if(wlist.get(i).japanese.equals(w.japanese))
                count++;
            if(count > 1)
                return false;
        }
        return true;
    }

    public static void Delete(int ID){
        try{
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
        Sort();
    }
    public static void DeleteAll(){
        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlite:KADAI1DB");
            PreparedStatement ps = con.prepareStatement("delete from wordlist");
            ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void Sort(){
        List<WordList> wlist = WordListDAO.findAll(); 
        Collections.sort(wlist);
        for(int i=0; i<wlist.size(); i++){
            if(wlist.get(i).id != i+1)
                wlist.get(i).id = i+1;
        }

        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlite:KADAI1DB");
            PreparedStatement ps = con.prepareStatement("delete from wordlist");
            ps.executeUpdate();
            
            ps.close();
            
            for(int i=0; i<wlist.size(); i++){
                PreparedStatement pstmt = con.prepareStatement("insert into wordlist values(?,?,?,?)");
                pstmt.setInt(1, wlist.get(i).id);
                pstmt.setString(2, wlist.get(i).english);
                pstmt.setString(3, wlist.get(i).japanese);
                pstmt.setInt(4, wlist.get(i).score);
                pstmt.executeUpdate();
            
                pstmt.close();
            }

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //要素を追加したときの保存
    public static void SaveAll(List<WordList> wlist){
        List<WordList> wlist2 = AddList(wlist);
        Save(wlist2);
        Sort();
    }

    //要素を追加してないときの保存
    public static void Save(List<WordList> wlist){
        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlite:KADAI1DB");
            for(int i=0; i<wlist.size(); i++){
                PreparedStatement pstmt = con.prepareStatement("update wordlist set english=? where id=?");
                pstmt.setString(1, wlist.get(i).english);
                pstmt.setInt(2, wlist.get(i).id);
                pstmt.executeUpdate();
            
                pstmt.close();
            }
            for(int i=0; i<wlist.size(); i++){
                PreparedStatement pstmt = con.prepareStatement("update wordlist set japanese=? where id=?");
                pstmt.setString(1, wlist.get(i).japanese);
                pstmt.setInt(2, wlist.get(i).id);
                pstmt.executeUpdate();
            
                pstmt.close();
            }
            for(int i=0; i<wlist.size(); i++){
                PreparedStatement pstmt = con.prepareStatement("update wordlist set score=? where id=?");
                pstmt.setInt(1, wlist.get(i).score);
                pstmt.setInt(2, wlist.get(i).id);
                pstmt.executeUpdate();
            
                pstmt.close();
            }

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
