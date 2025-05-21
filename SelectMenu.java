import java.util.*;
public class SelectMenu {
    
    public static int createUI(String title, Scanner scanner, String... options) {
        while (true) {
            // メニュー表示
            System.out.println("[" + title +"]");
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d %s", i + 1, options[i]);
                System.out.println();
            }
            System.out.println();
            System.out.print("選択: ");

            // 整数かどうかチェック
            if (!scanner.hasNextInt()) {
                String bad = scanner.next();
                System.out.printf("→ \"%s\" は整数ではありません。%n", bad);
                continue;
            }

            int option = scanner.nextInt();
            // 範囲チェック
            if (option< 1 || option > options.length) {
                System.out.printf("→ %d は範囲外です。%n", option);
                continue;
            }
            scanner.nextLine();
            return option;
        }
    }

    public static WordList createUI(Scanner scanner, List<WordList> wordLists) {
        while (true) {
            // メニュー表示
            System.out.println("[メニュー]");
            for (int i = 0; i < wordLists.size(); i++) {
                System.out.print((i + 1) + " ");
                wordLists.get(i).ToString();
                System.out.println();
            }
            System.out.print("選択: ");

            // 整数かどうかチェック
            if (!scanner.hasNextInt()) {
                String bad = scanner.next();
                System.out.printf("→ \"%s\" は整数ではありません。%n", bad);
                continue;
            }

            int option = scanner.nextInt();
            // 範囲チェック
            if (option< 1 || option > wordLists.size()) {
                System.out.printf("→ %d は範囲外です。%n", option);
                continue;
            }
            scanner.nextLine();
            return wordLists.get(option-1);
        }
    }
}
