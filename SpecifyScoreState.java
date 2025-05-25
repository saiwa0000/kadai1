import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SpecifyScoreState implements QuizMakerState {
    QuizMaker quizmaker;
    public SpecifyScoreState(QuizMaker q){
        this.quizmaker = q;
    }
    @Override
    //スコアを指定
    public List<WordList> MakeQuiz(List<WordList> wl,int size){
        Scanner scanner = new Scanner(System.in);
        System.out.println("どのスコアの問題を出題しますか？");
        int score = scanner.nextInt();
        List<WordList> list = new ArrayList<>(SearchWord.byScore(wl,score));
        
        List<WordList> returnlist = new ArrayList<>();
        if(list.size()>size){
            for(int i=0;i < size;i++){
                Random rand = new Random();
                int a = rand.nextInt(list.size());
                returnlist.add(list.remove(a));
            }
        }
        else{
            returnlist = list;
            if(returnlist.size()==0){
                System.out.println("スコアに該当する単語はありませんでした");
                returnlist.add(wl.get(0));
                
            }
        }
        return returnlist;
    }
}
