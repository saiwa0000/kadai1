import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMakeState implements QuizMakerState{

    QuizMaker quizmaker;
    public RandomMakeState(QuizMaker q){
        this.quizmaker = q;
    }
    public List<WordList> MakeQuiz(List<WordList> wl,int size){
        List<WordList> list = new ArrayList<>(wl);
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
        }
        

        return returnlist;
    }
}
