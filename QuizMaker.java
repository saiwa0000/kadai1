import java.util.*;

public class QuizMaker {
    //低いスコア優先で問題を作る関数
    public static ArrayList<WordList> PrioritizeLowScore(ArrayList<WordList> wl,int size){
        ArrayList<WordList> returnlist = new ArrayList<>();
        if(wl.size()>(size+5)){
            for(int i=0;i < size;i++){
                Random rand = new Random();
                WordList q = new WordList(0, null, null, 100);
                for(int j=0;j<5;j++){
                    
                    int a = rand.nextInt(wl.size());
                    if(q.score>wl.get(a).score){
                        q=wl.get(a);
                    }
                }
                
                returnlist.add(q);
                for(int l = 0;l < wl.size();l++){//問題内でIDのかぶりをなくしたい
                    if(wl.get(l).id==q.id){
                        wl.remove(l);
                        break;
                    }
                }
            }
        }
        else{
            returnlist = wl;
        }
        

        return returnlist;
    }
    public static ArrayList<WordList> SpecifyScore(ArrayList<WordList> wl,int size,int score){
        ArrayList<WordList> list = new ArrayList<>(SearchWord.byScore(wl,score));
        if(list.size()>size){
            for(int i=0;i < size;i++){
                Random rand = new Random();
                int a = rand.nextInt(list.size());
                returnlist.add(list.remove(a));
                
            }
        }
        return returnlist;
    }
}
