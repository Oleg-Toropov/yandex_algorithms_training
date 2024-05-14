package Yandex_coderun_002;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int[][] weight = new int[n][m];
        weight[0][0] = data[0][0];

        for (int j = 1; j < m; j++) {
            weight[0][j] = weight[0][j - 1] + data[0][j];
        }

        for (int i = 1; i < n; i++) {
            weight[i][0] = weight[i - 1][0] + data[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                weight[i][j] = Math.min(weight[i][j - 1], weight[i - 1][j]) + data[i][j];
            }
        }

        System.out.println(weight[n - 1][m - 1]);
    }
}