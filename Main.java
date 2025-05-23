import java.util.*;
public class Main {
    public static void main(String[] args){
        List<WordList> wl = WordListDAO.findAll();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("--------------------------------------------");
            int option = SelectMenu.createUI(
            "初期メニュー",
            scanner,
            "単語テスト",
            "単語の追加・削除・編集",
            "単語の検索",
            "終了"
            );
            switch (option) {
                case 1:
                    // 単語テスト処理...
                    Quiz.QuizExe(wl);
                    WordListDAO.SaveAll(wl);
                    break;
                case 2:
                    // 単語の追加・削除・編集...
                    EditWord.selectMenuUI(wl);
                    WordListDAO.SaveAll(wl);
                    System.out.println("2が呼ばれた");
                    break;
                case 3:
                    // 検索処理...
                    SearchWord.selectMenuUI(wl);
                    System.out.println("3が呼ばれた");
                    break;
                case 4:
                    
                    return;
            }
        }
        
    }
}

