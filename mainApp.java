import java.util.*;
public class mainApp {
    public static void main(String[] args){
        ArrayList<WordList>wl = new ArrayList<>();

        wl.add(new WordList(1, "apple", "りんご", 0));
        wl.add(new WordList(3, "banana", "バナナ", 1));
        wl.add(new WordList(4, "grape", "ぶどう", 5));
        wl.add(new WordList(2, "dog", "いぬ", 0));
        wl.add(new WordList(5, "cat", "ねっこ", 1));
        wl.add(new WordList(6, "bird", "とり", 5));
        wl.add(new WordList(7, "sad", "かなしい", 0));
        wl.add(new WordList(8, "happy", "しあわせな", 1));
        wl.add(new WordList(9, "angry", "おこった", 5));
        wl.add(new WordList(10, "joy", "だのしい", 0));
        wl.add(new WordList(11, "play", "あそぶ", 1));
        wl.add(new WordList(12, "study", "勉強する", 5));


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
                    System.out.println("1が呼ばれた");
                    break;
                case 2:
                    // 単語の追加・削除・編集...
                    EditWord.selectMenu(wl);
                    System.out.println("2が呼ばれた");
                    break;
                case 3:
                    // 検索処理...
                    System.out.println("3が呼ばれた");
                    break;
                case 4:
                    
                    return;
            }
        }
        
    }
}
