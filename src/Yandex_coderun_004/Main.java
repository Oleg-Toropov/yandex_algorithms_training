package Yandex_coderun_004;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        long result;

            long [][] moves = new long[n][m];
            moves[0][0] = 1;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {

                    if(i - 2 >= 0 && j - 1 >= 0){
                        moves[i][j] += moves[i - 2][j - 1];
                    }

                    if(i - 1 >= 0 && j - 2 >= 0){
                        moves[i][j] += moves[i - 1][j - 2];
                    }
                }
            }

            result = moves[n - 1][m - 1];

        System.out.println(result);
    }
}