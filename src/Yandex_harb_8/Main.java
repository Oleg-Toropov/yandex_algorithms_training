package Yandex_harb_8;
/*
Слияние отрезков:
Вход: [1, 3] [100, 200] [2, 4]
Выход: [1, 4] [100, 200]
3
1 3
100 200
2 4
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                intervals[i][j] = sc.nextInt();
            }
        }
        sc.close();

        Arrays.sort(intervals, (a, b) -> {return a[0] - b[0];});

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for(int i = 1; i < n; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = intervals[i][1];
            } else {
                current = intervals[i];
                result.add(current);
            }
        }

        for(int[] i: result) {
            System.out.println(Arrays.toString(i));
        }
    }
}
