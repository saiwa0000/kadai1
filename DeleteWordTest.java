import java.util.*;

public class DeleteWordTest {
    public static void main(String args[]){
        AddWord add = new AddWord();
        add.Add(1, "one", "一");

        List<WordList> wlist = WordListDAO.findAll(); 

        for(int i=0; i<wlist.size(); i++){
            wlist.get(i).ToString();
        }

        DeleteWord del = new DeleteWord();
        del.Delete(1);

        wlist = WordListDAO.findAll(); 

        for(int i=0; i<wlist.size(); i++){
            wlist.get(i).ToString();
        }
    }

}
