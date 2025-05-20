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


}
