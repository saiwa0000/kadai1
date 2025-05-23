import java.util.*;



public class EditWord {


    public static void selectMenuUI(List<WordList> wordList) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("--------------------------------------");
            int editMenu = SelectMenu.createUI("書き換えメニュー", scanner, "単語を追加", "単語を削除", "単語を編集", "戻る");
            switch(editMenu) {
                case 1:
                    addToList(wordList);
                    break;
                case 2:
                    DeleteFormList(wordList);
                    break;
                case 3:
                    editInList(wordList);
                    break;
                case 4:
                    return;
            }
        }
    }
    public static void addToList(List<WordList> wordList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("追加する英単語の情報を入力");
        System.out.print("英単語：");
        String english = scanner.nextLine();
        System.out.print("意味：");
        String japanese = scanner.nextLine();


        // ==============================
        //  書き換え処理: リストに英単語を追加
        // ==============================
        if(wordList.size()> 0) {
            wordList.add(new WordList(wordList.size()+1, english, japanese, 0));
        }
        
        System.out.println(wordList.getLast().english + "が追加されました");
        
    }
    public static void DeleteFormList(List<WordList> wordList) {
        Scanner scanner = new Scanner(System.in);
        List<WordList> searchedList = new ArrayList<>();
        while(true) {
            System.out.println("--------------------------------");
            System.out.println("削除する英単語を検索");
            System.out.print("英単語：");
            String english = scanner.nextLine();
            searchedList = SearchWord.byEnglish(wordList, english);
            if (searchedList.size() > 0) break;

            System.out.println("該当する英単語が見つかりませんでした");
            int option = SelectMenu.createUI("メニュー", scanner, "再度検索", "戻る");
            switch (option) {
            case 1:
                continue;
            case 2:
                return;
            }

        };

        System.out.println("-----------------------------");
        System.out.println("削除する英単語を選択");
        int deletedId = SelectMenu.createUI(scanner, searchedList).id;
        String deletedEn = wordList.get(deletedId - 1).english;
        System.out.println("----------------------------");
        System.out.println("本当に" + deletedEn + "を削除しますか");
        int option = SelectMenu.createUI("メニュー", scanner, "はい", "いいえ");



        // ==============================
        //  書き換え処理: リストから英単語削除
        // ==============================
        switch (option) {
            case 1:
                wordList.remove(deletedId-1);
                for (int i = 0; i < wordList.size(); i++) {
                    wordList.get(i).id = i+1;
                    //いるかどうかわからない
                    wordList.get(i).isChange = true;
                }
                System.out.println(deletedEn + "が削除されました。");
                break;
            case 2:
                System.out.println(deletedEn + "の削除がキャンセルされました");
                break;
        }
        

    }

    public static void editInList(List<WordList> wordList) {
        Scanner scanner = new Scanner(System.in);
        List<WordList> searchedList = new ArrayList<>();
        while(true) {
            System.out.println("-----------------------------------");
            System.out.println("編集する英単語を検索");
            System.out.print("英単語：");
            String english = scanner.nextLine();
            searchedList = SearchWord.byEnglish(wordList, english);
            if (searchedList.size() > 0) break;

            System.out.println("該当する英単語が見つかりませんでした");
            int option = SelectMenu.createUI("メニュー", scanner, "再度検索", "戻る");
            switch (option) {
            case 1:
                continue;
            case 2:
                return;
            }
        };

        System.out.println("--------------------------------");
        System.out.println("編集する英単語を選択");
        int editedEnId = SelectMenu.createUI(scanner, searchedList).id;
        System.out.println("----------------------------");
        int editMenu = SelectMenu.createUI("メニュー", scanner, "英単語を編集", "意味を編集", "どちらも編集");


        // ==============================
        //  書き換え処理: リストの英単語を編集
        // ==============================
        switch (editMenu) {
            case 1:
                System.out.print("編集後の英単語：");
                String editedEn = scanner.nextLine();
                wordList.get(editedEnId - 1).english = editedEn;
                wordList.get(editedEnId - 1).isChange = true;
                break;
            case 2:
                System.out.print("編集後の意味：");
                String editedJp = scanner.nextLine();
                wordList.get(editedEnId - 1).japanese = editedJp;
                wordList.get(editedEnId - 1).isChange = true;
                break;
            case 3:
                System.out.print("編集後の英単語：");
                editedEn = scanner.nextLine();
                wordList.get(editedEnId - 1).english = editedEn;
                wordList.get(editedEnId - 1).isChange = true;
                System.out.print("編集後の意味：");
                editedJp = scanner.nextLine();
                wordList.get(editedEnId - 1).japanese = editedJp;
                wordList.get(editedEnId - 1).isChange = true;
        }
        
        System.out.println(wordList.get(editedEnId - 1).english + "が編集されました。");
    }
}
