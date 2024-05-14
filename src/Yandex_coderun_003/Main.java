package Yandex_coderun_003;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] data = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
            data[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int[][] maxSum = new int[n][m];
        maxSum[0][0] = data[0][0];

        for(int j = 1; j < m; j++){
            maxSum[0][j] = maxSum[0][j - 1] + data[0][j];
        }

        for(int i = 1; i < n; i++){
            maxSum[i][0] = maxSum[i - 1][0] + data[i][0];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                maxSum[i][j] = Math.max(maxSum[i - 1][j], maxSum[i][j - 1]) + data[i][j];
            }
        }

        StringBuilder path = new StringBuilder();
        int i = n - 1;
        int j = m - 1;

        while(i > 0 && j > 0) {
            if(maxSum[i - 1][j] > maxSum[i][j - 1]) {
                path.insert(0, "D ");
              i--;
            } else {
                path.insert(0, "R ");
                j--;
            }
        }

        while(i > 0){
            path.insert(0, "D ");
            i--;
        }

        while(j > 0){
            path.insert(0, "R ");
            j--;
        }

        System.out.println(maxSum[n - 1][m - 1]);
        System.out.println(path.toString());
    }
}
