import java.util.*;
public class Quiz {
    
    //与えられた出題範囲を用いて実際にクイズを出題し、スコアを更新した新しいリストを返す関数
    //それぞれWordListのリスト(FindAll()で取得する)
    public static ArrayList<WordList> QuizExe(ArrayList<WordList> list){
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<WordList> result = new ArrayList<>();
        if(QuizMaker.MakeQuiz(list)!= null){
            result =QuizMaker.MakeQuiz(list);
        }
        else{
            return list;
        }
        for(int i = 0;i<list.size();i++){
            WordList wl =list.get(i);
            System.out.println("第"+(i+1)+"問");
            System.out.println(wl.japanese);
            String answer = scanner.nextLine();
            if(answer.equals(wl.english)){//正解なら
                System.out.println("正解！");
                if(wl.score<5){
                    wl.score++;
                }
            }else{
                System.out.println("不正解...");
                if(wl.score>-5){
                    wl.score--;
                }
            }
            result.add(wl);
        }
        System.out.println("クイズおわり");
        return result;
    }

    
}
