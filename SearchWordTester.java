import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;


public class SearchWordTester {
    @Test public void eSearch() {
        List<WordList> wordList = new ArrayList<WordList>();
        WordList word1 = new WordList(0, "apple", "りんご", 0);
        WordList word2 = new WordList(1, "sing", "歌う", 0);
        wordList.add(word1);
        wordList.add(word2);



        List<WordList> searchedWordE = SearchWord.byEnglish(wordList, "ap");
        List<WordList> searchedWordJ = SearchWord.byJapanese(wordList, "んご");
        List<WordList> searchedWordS = SearchWord.byScore(wordList, 0);
        System.out.println("aaaaaaaa");
        System.out.println(searchedWordE.get(0).english);
        System.out.println(searchedWordJ.get(0).english);
        System.out.println(searchedWordS.get(0).english);
        System.out.println(searchedWordS.get(1).english);
        assertEquals(searchedWordE.get(0).english, "apple");
        assertEquals(searchedWordJ.get(0).english, "apple");
        assertEquals(searchedWordS.get(0).english, "apple");
        assertEquals(searchedWordS.get(1).english, "sing");

    }
}
