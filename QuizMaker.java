import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {
    private QuizMakerState prioritizelowscore;
    private QuizMakerState specifyscore;
    private QuizMakerState randommake;

    QuizMakerState state;

    public QuizMaker(){
        prioritizelowscore = new PrioritizeLowScoreState(this);
        specifyscore = new SpecifyScoreState(this);
        randommake = new RandomMakeState(this);

        state = prioritizelowscore;
    }

    public List<WordList> MakeQuiz(List<WordList> wl, int size){
        return state.MakeQuiz(wl, size);
    }

    public void SetState(QuizMakerState state){
        this.state = state;
    }

    public List<WordList> Make(List<WordList> wl){
        Scanner scanner = new Scanner(System.in);
        System.out.println("出題方法は?");
        System.out.println("0:低いスコア優先 1:スコアを指定 2:ランダム");
        int num = scanner.nextInt();
        System.out.println("問題数は?");
        int size = scanner.nextInt();
        switch(num){
            case 0: SetState(prioritizelowscore); break;
            case 1: SetState(specifyscore); break;
            case 2: SetState(randommake); break;
            default : System.out.println("該当する問題はありません");
        }
        return this.MakeQuiz(wl, size);
    }
}
