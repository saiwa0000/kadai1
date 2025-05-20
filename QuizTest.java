import java.util.*;
public class QuizTest {
    public static void main(String[] args){
        ArrayList<WordList>wl = new ArrayList<>();

        wl.add(new WordList(1, "apple", "りんご", 0));
        wl.add(new WordList(3, "banana", "バナナ", 1));
        wl.add(new WordList(4, "grape", "ぶどう", 5));
        
        for(int i=0;i<wl.size();i++){
            wl.get(i).ToString();
        }
        

        ArrayList<WordList> result=Quiz.QuizExe(wl);
        
        for(int i=0;i<result.size();i++){
            result.get(i).ToString();
        }
        
    }
}
