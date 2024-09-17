package Yandex_internship_autumn_2024_1; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        String[] crossword = new String[r];

        for (int i = 0; i < r; i++) {
            crossword[i] = scanner.nextLine();
        }

        scanner.close();

        List<String> allWords = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String[] rowWords = crossword[i].split("#");

            for (String word : rowWords) {
                if (word.length() >= 2) {
                    allWords.add(word);
                }
            }
        }

        for (int j = 0; j < c; j++) {
            StringBuilder colWord = new StringBuilder();

            for (int i = 0; i < r; i++) {
                char ch = crossword[i].charAt(j);

                if (ch == '#') {
                    if (colWord.length() >= 2) {
                        allWords.add(colWord.toString());
                    }
                    colWord = new StringBuilder();
                } else {
                    colWord.append(ch);
                }
            }

            if (colWord.length() >= 2) {
                allWords.add(colWord.toString());
            }
        }

        Collections.sort(allWords);
        System.out.println(allWords.get(0));
    }
}