package Yandex_preparing_for_the_interview_2024_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        int count = 0;

        for (int i = 0; i < s2.length(); i++) {
            if (s1.indexOf(s2.charAt(i)) >= 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}