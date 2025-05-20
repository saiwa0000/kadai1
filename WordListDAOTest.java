
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

        WordListDAO.SaveAll(wlist);


        List<WordList> wlist2 = WordListDAO.findAll(); 

        System.out.println("1");

        List<WordList> wlist3 = new ArrayList<>();
        wlist3.add(wlist2.get(1));


        for(int i=0; i<wlist3.size(); i++){
            wlist3.get(i).score ++;
            wlist3.get(i).ToString();
        }

        System.out.println("1");

        WordListDAO.Save(wlist3);

        List<WordList> wlist4 = WordListDAO.findAll();

        System.out.println("1");

        for(int i=0; i<wlist4.size(); i++){
            wlist4.get(i).ToString();
        }

        System.out.println("1");
    }

    
}
