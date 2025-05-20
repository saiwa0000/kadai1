
import java.util.*;

public class WordListDAOTest {
    public static void main(String args[]){
        List<WordList> wlist = WordListDAO.findAll(); 

        System.out.println("1");

        for(int i=0; i<wlist.size(); i++){
            wlist.get(i).ToString();
        }

        System.out.println("1");

        WordListDAO.Add(1, "one", "いち");

        wlist = WordListDAO.findAll(); 

        for(int i=0; i<wlist.size(); i++){
            wlist.get(i).ToString();
        }

        System.out.println("1");

        WordListDAO.Delete(1);
        wlist = WordListDAO.findAll(); 

        for(int i=0; i<wlist.size(); i++){
            wlist.get(i).ToString();
        }
    }

    
}
