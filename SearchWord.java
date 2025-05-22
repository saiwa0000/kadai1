import java.util.*;

public class SearchWord {
    private SearchWord() {
        // インスタンス化防止用
        throw new AssertionError("Do not instantiate utility class");
    }


    public static List<WordList> byScore(List<WordList> wordList, int score) {
        List<WordList> seachedList =new ArrayList<WordList>();

        for(WordList word : wordList){
            if(word.score == score) {
                seachedList.add(word);
            }
        }
        return seachedList;

    }



    public static List<WordList> byEnglish(List<WordList> wordList, String english) {
        List<WordList> seachedList =new ArrayList<WordList>();

        for (WordList word : wordList) {
            //ワードリスト内の英単語
            String wordListEn = word.english;
            if(wordListEn.length() < english.length()) {
                continue;
            }
            else{
                //ワードリスト内英単語の最初の数文字
                String initialWord = wordListEn.substring(0, english.length());
                if (initialWord.equalsIgnoreCase(english)) {
                    seachedList.add(word);
                }
            }
        }
        return seachedList;
    }



    public static List<WordList> byJapanese(List<WordList> wordList, String japanese) {
        List<WordList> seachedList =new ArrayList<WordList>();

        for (WordList word : wordList) {
            //ワードリスト内の日本語
            String wordListJp = word.japanese;
            //検索ワードがワードリストの日本語よりも長い
            if(wordListJp.length() < japanese.length()) {
                continue;
            }
            else{
                if (wordListJp.contains(japanese)) {
                    seachedList.add(word);
                }
            }
        }
        return seachedList;
    }

    private enum SearchType {
        ENGLISH("英単語"),    // ordinal = 0
        JAPANESE("意味"),    // ordinal = 1
        SCORE("スコア(0から5の整数)");     // ordinal = 2

        // 表示用ラベル
        private final String label;

        // コンストラクタ（暗黙的に private）
        SearchType(String label) {
            this.label = label;
        }

        // ラベル取得メソッド
        public String getLabel() {
            return label;
        }
    }

    public static void selectMenuUI(List<WordList> wordList) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("--------------------------------------");
            int editMenu = SelectMenu.createUI("検索メニュー", scanner, "英単語で検索", "意味で検索", "スコアで検索", "一覧表示", "戻る");
            switch(editMenu) {
                case 1:
                    searchWordUI(wordList, SearchType.ENGLISH);
                    
                    break;
                case 2:
                    searchWordUI(wordList,  SearchType.JAPANESE);
                    break;
                case 3:
                    searchWordUI(wordList, SearchType.SCORE);
                    break;
                case 4:
                    for(WordList word: wordList) {
                        word.ToString();
                        System.out.println();
                    }
                    break;
                case 5:
                    return;
            }
        }
    };

    

    private static void searchWordUI(List<WordList> wordList, SearchType type) {
        Scanner scanner = new Scanner(System.in);
        List<WordList> searchedList = new ArrayList<>();
        while(true) {
            System.out.println("--------------------------------");
            System.out.println(type.getLabel() + "で検索");
            System.out.print(type.getLabel() + "：");
            String searchWord = scanner.nextLine();

            switch (type) {
                case ENGLISH:
                    searchedList = SearchWord.byEnglish(wordList, searchWord);
                    break;
                case JAPANESE:
                    searchedList = SearchWord.byJapanese(wordList, searchWord);
                    break;
                case SCORE:
                    int score = 0;
                    try {
                        score = Integer.parseInt(searchWord);
                    } catch (NumberFormatException e) {
                        System.out.println("0から5の整数を入力してください。");
                        continue;
                    }
                    searchedList = SearchWord.byScore(wordList, score);
                    break;
                default:
                    break;
            }
            
            if (searchedList.size() > 0) {
                for(WordList word: searchedList) {
                    word.ToString();
                    System.out.println();
                }
            }
            else {
                System.out.println("該当する英単語が見つかりませんでした");
            }
            int option = SelectMenu.createUI("メニュー", scanner, "再度検索", "戻る");
            switch (option) {
            case 1:
                continue;
            case 2:
                return;
            }

        }
    }

    

}
