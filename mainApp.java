import java.util.*;
public class mainApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("[メニューを選択してください]");
        System.out.println("1 単語テスト");
        System.out.println("2 単語の追加・削除・編集");
        System.out.println("3 単語の検索");
        System.out.println("4 戻る");

        while (true) {
            //整数かどうかチェック
            if (!scanner.hasNextInt()) {
                String bad = scanner.next();
                System.out.println("→ \"" + bad + "\" は整数ではありません。");
                continue;
            }

            //整数なら読み込んで大小比較
            option = scanner.nextInt();
            if (option < 0 || option > 4) {
                System.out.println("→ " + option + " は範囲外です。");
                continue;
            }
            break;
        }

        switch(option){
            case 1:
            break;
            case 2:
            
            break;
            case 3:
            break;
            case 4:
            break;
        }

        

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
