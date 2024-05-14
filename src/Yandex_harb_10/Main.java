package Yandex_harb_10;
/*
Даны две строки.
Написать функцию, которая вернёт True, если из первой строки можно получить вторую, совершив не более 1 изменения
(== удаление / замена символа).
apple
aple

apple
aplle

apple
apless
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        if (s1.equals(s2)) {
            System.out.println("True");
            return;
        }

        int len1 = s1.length();
        int len2 = s2.length();

        if (Math.abs(len1 - len2) > 1) {
            System.out.println("False");
            return;
        }

        int countDifferences = 0;
        int i = 0, j = 0;

        while (i < len1 && j < len2) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (countDifferences == 1) {
                    System.out.println("False");
                    return;
                }

                if (len1 > len2) {
                    i++;
                } else if (len2 > len1) {
                    j++;
                } else {
                    i++;
                    j++;
                }

                countDifferences++;
            } else {
                i++;
                j++;
            }
        }

        if (i < len1 || j < len2) {
            countDifferences++;
        }

        System.out.println(countDifferences <= 1 ? "True" : "False");
    }
}





