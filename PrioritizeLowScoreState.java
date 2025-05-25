import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
public class PrioritizeLowScoreState implements QuizMakerState{
    QuizMaker quizmaker;
    public PrioritizeLowScoreState(QuizMaker q){
        this.quizmaker = q;
    }
    @Override 
    public List<WordList> MakeQuiz(List<WordList> wl,int size){
        List<WordList> list = new ArrayList<>(wl);
        List<WordList> returnlist = new ArrayList<>();
        if(list.size()>(size+5)){
            for(int i=0;i < size;i++){
                //Random rand = new Random();
                RandomGenerator rand = RandomGeneratorFactory.of("L64X128MixRandom").create();
                WordList q = new WordList(0, null, null, 100);
                for(int j=0;j<5;j++){
                    
                    int a = rand.nextInt(list.size());
                    if(q.score>list.get(a).score){
                        q=list.get(a);
                    }
                }
                
                returnlist.add(q);
                for(int l = 0;l < list.size();l++){//問題内でIDのかぶりをなくしたい
                    if(list.get(l).id==q.id){
                        list.remove(l);
                        break;
                    }
                }
            }
        }
        else{
            returnlist = list;
        }
        

        return returnlist;
    }
}
