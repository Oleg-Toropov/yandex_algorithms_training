package Yandex_preparing_for_the_interview_2024_5;

import java.util.*;

public class MainV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        int result = 0;

        if (s1.length() == s2.length()) {

            Map<Character, Integer> d1 = new HashMap<>();
            Map<Character, Integer> d2 = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(i);

                d1.put(ch1, d1.getOrDefault(ch1, 0) + 1);
                d2.put(ch2, d2.getOrDefault(ch2, 0) + 1);
            }

            if (d1.equals(d2)) {
                result = 1;
            }
        }

        System.out.println(result);
    }
}
