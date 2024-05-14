package Yandex_harb_12;
/*
Для заданной строки s и целого числа k вернуть длину самой длинной подстроки s, содержащей не
более k различных символов.
Input: s = "eceba", k = 2
Output: 3
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        if (k == 0 || s.length() == 0 || s == null) {
            System.out.println(0);
            return;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);

            while (map.size() > k) {
                char ch2 = s.charAt(j);
                map.put(ch2, map.get(ch2) - 1);
                if (map.get(ch2) == 0) {
                    map.remove(ch2);
                }
                j++;
            }

            maxLen = Math.max(maxLen, i - j + 1);
        }

        System.out.println(maxLen);
    }
}
