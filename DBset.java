
import java.util.*;

public class DBset {
    public static void main(String args[]){
        List<WordList> wl = WordListDAO.findAll(); 

        wl.add(new WordList(1, "apple", "りんご", 0));
        wl.add(new WordList(2, "banana", "バナナ", 0));
        wl.add(new WordList(3, "grape", "ぶどう", 0));
        wl.add(new WordList(4, "dog", "いぬ", 0));
        wl.add(new WordList(5, "cat", "ねっこ", 0));
        wl.add(new WordList(6, "bird", "とり", 0));
        wl.add(new WordList(7, "sad", "かなしい", 0));
        wl.add(new WordList(8, "happy", "しあわせな", 0));
        wl.add(new WordList(9, "angry", "おこった", 0));
        wl.add(new WordList(10, "joy", "だのしい", 0));
        wl.add(new WordList(11, "play", "あそぶ", 0));
        wl.add(new WordList(12, "study", "勉強する", 0));

        WordListDAO.SaveAll(wl);
    }

    
}
