import java.util.*;
public class QuizTest {
    public static void main(String[] args){
        ArrayList<WordList>wl = new ArrayList<>();

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
        
        for(int i=0;i<wl.size();i++){
            wl.get(i).ToString();
        }
        

        ArrayList<WordList> result=Quiz.QuizExe(wl);
        
        for(int i=0;i<result.size();i++){
            result.get(i).ToString();
        }
        
    }
}
