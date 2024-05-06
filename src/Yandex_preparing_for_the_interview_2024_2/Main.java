package Yandex_preparing_for_the_interview_2024_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();

            if (a == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }

        }
        sc.close();

        System.out.println(maxCount);
    }
}
/*
5
1
0
1
1
1
 */