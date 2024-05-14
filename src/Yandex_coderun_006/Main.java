package Yandex_coderun_006;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sequence1 = new int[n];
        for (int i = 0; i < n; i++) {
            sequence1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] sequence2 = new int[m];
        for (int i = 0; i < m; i++) {
            sequence2[i] = sc.nextInt();
        }
        sc.close();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (sequence1[i - 1] == sequence2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int maxLength = dp[n][m];
        int[] result = new int[maxLength];

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (sequence1[i - 1] == sequence2[j - 1]) {
                result[--maxLength] = sequence1[i - 1];
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        for (int k = 0; k < result.length; k++) {
            System.out.print(result[k] + " ");
        }
    }
}
