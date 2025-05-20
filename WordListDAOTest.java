
import java.util.*;

public class WordListDAOTest {
    public static void main(String args[]){
        List<WordList> wlist = WordListDAO.findAll(); 

        System.out.println("1");

        wlist.add( new WordList(1, "one", "壱", 0));
        wlist.add( new WordList(76, "four", "四", 0));
        wlist.add( new WordList(13, "two", "に", 0));
        wlist.add( new WordList(42, "three", "サン", 0));

        for(int i=0; i<wlist.size(); i++){
            wlist.get(i).ToString();
        }

        System.out.println("1");

        WordListDAO.Save(wlist);


        List<WordList> wlist2 = WordListDAO.findAll(); 

        System.out.println("1");


        for(int i=0; i<wlist2.size(); i++){
            wlist2.get(i).ToString();
        }

        WordListDAO.DeleteAll();
    }

    
}
