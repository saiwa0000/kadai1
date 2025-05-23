import java.util.*;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
public class QuizMaker {
    
    public static List<WordList> MakeQuiz(List<WordList> wl){
        Scanner scanner = new Scanner(System.in);
        System.out.println("出題方法は?");
        System.out.println("0:低いスコア優先 1:スコアを指定 2:ランダム");
        int num = scanner.nextInt();
        System.out.println("問題数は?");
        int size = scanner.nextInt();
        List<WordList> returnlist = new ArrayList<>();
        switch(num){
            case 0: returnlist = PrioritizeLowScore(wl, size); break;
            case 1: returnlist = SpecifyScore(wl, size); break;
            case 2: returnlist = RandomMake(wl, size); break;
            default : System.out.println("該当する問題はありません");
        }

        return returnlist;
    }
    //低いスコア優先で問題を作る関数
    static List<WordList> PrioritizeLowScore(List<WordList> wl,int size){
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
    //スコアを指定
    static List<WordList> SpecifyScore(List<WordList> wl,int size){
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
                returnlist = null;
            }
        }
        return returnlist;
    }
    //完全ランダム
    static List<WordList> RandomMake(List<WordList> wl,int size){
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
