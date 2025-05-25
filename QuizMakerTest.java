import java.util.*;

public class QuizMakerTest {
    public static void main(String[] args){
        List<WordList>wl = new ArrayList<>();

        wl.add(new WordList(1, "apple", "りんご", 0));
        wl.add(new WordList(3, "banana", "バナナ", 1));
        wl.add(new WordList(4, "grape", "ぶどう", 5));
        wl.add(new WordList(2, "dog", "いぬ", 0));
        wl.add(new WordList(5, "cat", "ねっこ", 1));
        wl.add(new WordList(6, "bird", "とり", 5));
        wl.add(new WordList(7, "sad", "かなしい", 0));
        wl.add(new WordList(8, "happy", "しあわせな", 1));
        wl.add(new WordList(9, "angry", "おこった", 5));
        wl.add(new WordList(10, "joy", "だのしい", 0));
        wl.add(new WordList(11, "play", "あそぶ", 1));
        wl.add(new WordList(12, "study", "勉強する", 5));

        QuizMaker q = new QuizMaker();

        List<WordList>list = new ArrayList<>(q.Make(wl));

        
        for(int i=0;i<list.size();i++){
            list.get(i).ToString();
        }
    }
}
