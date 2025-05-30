
public class WordList implements Comparable<WordList> {
    int id;
    String english;
    String japanese;
    int score;
    boolean isChange =false;

    public WordList(int id,String english,String japanese,int score){
        this.id = id;
        this.english = english;
        this.japanese = japanese;
        this.score = score;
    }

    public void ToString(){
        System.out.printf("%d,%s,%s,%d\n",id,english,japanese,score);
    }

    @Override
    public int compareTo(WordList s) {
        return  this.id - s.id;
    }
}
