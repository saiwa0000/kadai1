import java.util.*;
public class EditWord {
    public static void addToList(List<WordList> wordList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("追加する英単語の情報を入力してください。");
        System.out.println("英単語：");
        String english = scanner.nextLine();
        System.out.println("意味：");
        String japanese = scanner.nextLine();
        wordList.add(new WordList(wordList.size()+1, english, japanese, 0));
    }

    public static void DeleteFormList() {
        System.out.println("削除する英単語を入力してください。");
    }

    public static void editInList() {
        
    }
}
