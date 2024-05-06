package Yandex_school_2024_2; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();

        StringBuilder result = new StringBuilder();
        int cursor = 0;

        for (int i = 0; i < b.length(); ) {
            if (b.charAt(i) == '<') {
                int end = b.indexOf('>', i);
                String command = b.substring(i, end + 1);
                i = end + 1;

                switch (command) {
                    case "<left>":
                        if (cursor > 0) {
                            cursor--;
                        }
                        break;
                    case "<right>":
                        if (cursor < result.length()) {
                            cursor++;
                        }
                        break;
                    case "<delete>":
                        if (cursor < result.length()) {
                            result.deleteCharAt(cursor);
                        }
                        break;
                    case "<bspace>":
                        if (cursor > 0) {
                            result.deleteCharAt(cursor - 1);
                            cursor--;
                        }
                        break;
                }
            } else {
                result.insert(cursor, b.charAt(i));
                cursor++;
                i++;
            }
        }

        System.out.println(result.toString().equals(a) ? "Yes" : "No");
    }
}