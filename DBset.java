
import java.util.*;

public class DBset {
    public static void main(String args[]){
        List<WordList> wlist = WordListDAO.findAll(); 

        wlist.add( new WordList(1, "apple", "りんご", 0));

        WordListDAO.SaveAll(wlist);
    }

    
}
