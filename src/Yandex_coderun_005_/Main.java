package Yandex_coderun_005_;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }
        sc.close();

        if (n == 0) {
            System.out.println("0\n0 0");
            return;
        }

        int[][] dp = new int[n + 1][n + 1];
        int[][] from = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int day = 1; day <= n; day++) {
            int cost = costs[day - 1];

            for (int col = 0; col <= day; col++) {
                int coupon = col + ((cost > 100)? 1 : 0);

                if (coupon <= day) {
                    if (dp[day - 1][col] + cost < dp[day][coupon]) {
                        dp[day][coupon] = dp[day - 1][col] + cost;
                        from[day][coupon] = col;
                    }
                }

                if (col > 0 && cost > 0 && dp[day - 1][col] < dp[day][col - 1]) {
                    dp[day][col - 1] = dp[day - 1][col];
                    from[day][col - 1] = col;
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        int remainingCoupons = 0;
        for (int j = 0; j <= n; j++) {
            if (dp[n][j] < minCost) {
                minCost = dp[n][j];
                remainingCoupons = j;
            }
        }

        List<Integer> usedCouponsDays = new ArrayList<>();
        int trackCoupons = remainingCoupons;

        for (int i = n; i > 0; i--) {
            if (from[i][trackCoupons] != trackCoupons) {
                if (from[i][trackCoupons] == trackCoupons + 1) {
                    usedCouponsDays.add(i);
                }
                trackCoupons = from[i][trackCoupons];
            }
        }

        Collections.sort(usedCouponsDays);


        System.out.println(minCost);
        System.out.println(remainingCoupons + " " + usedCouponsDays.size());
        for (int day : usedCouponsDays) {
            System.out.println(day);
        }
    }
}
