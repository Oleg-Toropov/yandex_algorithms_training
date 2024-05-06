package Yandex_internship_2024_3; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////
// ПРОСТОЙ СПОСОБ РЕШЕНИЯ - НЕ ПРОХОДИТ ЛИМИТ ПО ВРЕМЕНИ

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];

        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        sc.close();

        int countNonIntersecting = 0;

        for (int i = 0; i < n; i++) {
            int xCurrent = segments[i][0];
            int yCurrent = segments[i][1];

            int count = 0;
            for (int j = 0; j < n; j++) {
                int xOther = segments[j][0];
                int yOther = segments[j][1];

                if (xCurrent < xOther && yCurrent < yOther || xCurrent > xOther && yCurrent > yOther) {
                    count++;
                } else {
                    if (i != j) {
                        break;
                    }
                }

                if (j == n - 1 && count == n - 1) {
                    countNonIntersecting++;
                }
            }
        }

        System.out.println(countNonIntersecting);
    }
}