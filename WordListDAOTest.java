import java.util.ArrayList;
import java.util.*;
public class WordListDAOTest {
    public static void main(String args[]){
        List<WordList> wlist=WordListDAO.findAll(); 

        for(int i=0;i<wlist.size();i++){
            wlist.get(i).ToString();
        }

    }

    
}
